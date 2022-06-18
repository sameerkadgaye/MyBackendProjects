package com.practice.service.impl.admin.masters.otherMasters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.constants.Constants;
import com.practice.dao.admin.masters.otherMasters.DistrictRepository;
import com.practice.dao.admin.masters.otherMasters.TalukaRepository;
import com.practice.model.admin.masters.otherMaster.DistrictMaster;
import com.practice.model.admin.masters.otherMaster.TalukaMaster;
import com.practice.model.common.ApplicationException;
import com.practice.service.inf.admin.masters.otherMasters.TalukaService;


@Service
public class TalukaServiceIImpl  implements TalukaService {


	@Autowired 
	private TalukaRepository talukaRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Override
	public List<TalukaMaster> getTalukas() {
//		List<TalukaMaster> talukalist = this.talukaRepository.findAll();
//		return talukalist;
		List<TalukaMaster> talukalist = this.talukaRepository.findByStatusFalse();
		return talukalist;
	}
	
	@Override
	public TalukaMaster saveTalukaMaster(TalukaMaster taluka) throws ApplicationException  {
		
		String  talukaCode = taluka.getTalukaCode();
		List<TalukaMaster> findByTalukaCode = talukaRepository.findByTalukaCodeAndStatusFalse(talukaCode);
		if (!findByTalukaCode.isEmpty()) {
			throw new ApplicationException(Constants.ErrorCode, Constants.CodeAlreadyPresent);
		}
		
		//create Mapping and save districtId to db
		DistrictMaster districtId = districtRepository.findById(taluka.getDistrictName().getDistrictId()).orElse(null);
		if(districtId == null) {
			districtId = new DistrictMaster();
		}
		districtId.setDistrictId(taluka.getDistrictName().getDistrictId());
		taluka.setDistrictName(districtId);
		
		
		TalukaMaster saveTaluka = this.talukaRepository.save(taluka);
		return saveTaluka;
	}

	
	
//	
//	@Override
//	public DistrictMaster saveDistrict(DistrictMaster district) throws ApplicationException{
//		Integer districtCode = district.getDistrictCode();
//		List<DistrictMaster> findByDistrictCode = districtRepository.findByDistrictCodeAndStatusFalse(districtCode);
//		if (!findByDistrictCode.isEmpty()) {
//			throw new ApplicationException(Constants.ErrorCode, Constants.CodeAlreadyPresent);
//		}
//		
//		StateMaster stateMaster = stateRepository.findById(district.getStateMaster().getStateId()).orElse(null);
//		if(stateMaster == null)
//		{
//			stateMaster = new StateMaster();
//		}
//		stateMaster.setStateId(district.getStateMaster().getStateId());
//		district.setStateMaster(stateMaster);
//		
//		district.setStatus(false);
//		System.out.println(district.toString());
//		DistrictMaster saveDistrict = this.districtRepository.save(district);
//		return saveDistrict;
//	}
//	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void deleteTaluka(Long talukaId) {
		this.talukaRepository.deleteById(talukaId);
	}
	
	@Override
	public TalukaMaster getTalukaById(Long talukaId) {
		TalukaMaster taluka  = null;
		try {
			taluka = this.talukaRepository.findById(talukaId).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taluka;
	}


	@Override
	public void updateTaluka(TalukaMaster Taluka, Long talukaId) throws ApplicationException {
		
		String  talukaCode = Taluka.getTalukaCode();
		List<TalukaMaster> findByTalukaCode = talukaRepository.findByTalukaCodeAndStatusFalse(talukaCode);
		if (!findByTalukaCode.isEmpty()) {
			throw new ApplicationException(Constants.ErrorCode, Constants.CodeAlreadyPresent);
		}
		
		else {
		Taluka.setTalukaId(talukaId);
		this.talukaRepository.save(Taluka);
		}
	}

	
	
	
	
	@Override
	public List<TalukaMaster> findTalukaByStatus() {
		return this.talukaRepository.findTalukaByStatus();
	}
	
	
	
}
