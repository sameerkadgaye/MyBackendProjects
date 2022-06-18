package com.practice.service.impl.admin.masters.otherMasters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.constants.Constants;
import com.practice.dao.admin.masters.otherMasters.DistrictRepository;
import com.practice.dao.admin.masters.otherMasters.StateMasterRepository;
import com.practice.model.admin.masters.otherMaster.DistrictMaster;
import com.practice.model.admin.masters.otherMaster.StateMaster;
import com.practice.model.common.ApplicationException;
import com.practice.service.inf.admin.masters.otherMasters.DistrictService;

/**
 * @author PALASH KHARWADE
 * @version 0.1
 * 
 *          Created Date : 29/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Service
public class DistrictServiceImpl implements DistrictService{
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private StateMasterRepository stateRepository;

	@Override
	public List<DistrictMaster> getDistrict() {
//		List<DistrictMaster> districtList = this.districtRepository.findAll();
		List<DistrictMaster> districtList = this.districtRepository.findByStatusFalse();
		return districtList;
	}

	@Override
	public DistrictMaster saveDistrict(DistrictMaster district) throws ApplicationException{
		
		Integer districtCode = district.getDistrictCode();
		String districtName = district.getDistrictName();
		
		List<DistrictMaster> findByDistrictCode = districtRepository.findByDistrictCodeAndStatusFalse(districtCode);
		if (!findByDistrictCode.isEmpty()) {
			throw new ApplicationException(Constants.ErrorCode, Constants.CodeAlreadyPresent);
		}
		
		List<DistrictMaster> findByDistrictNameAndStatusFalse = districtRepository.findByDistrictNameAndStatusFalse(districtName);
		if(!findByDistrictNameAndStatusFalse.isEmpty()) {	
			
			throw new ApplicationException(Constants.ErrorCode, Constants.NameAlreadyPresent);
		}
		
		StateMaster stateMaster = stateRepository.findById(district.getStateMaster().getStateId()).orElse(null);
		if(stateMaster == null)
		{
			stateMaster = new StateMaster();
		}
		stateMaster.setStateId(district.getStateMaster().getStateId());
		district.setStateMaster(stateMaster);
		
		district.setStatus(false);
		System.out.println(district.toString());
		DistrictMaster saveDistrict = this.districtRepository.save(district);
		return saveDistrict;
	}

	@Override
	public DistrictMaster getDistrictById(Long districtId) {
		DistrictMaster district= null;
		try {
			district = this.districtRepository.findById(districtId).get();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return district;
	}

	@Override
	public void deleteDistrict(Long districtId) {
		this.districtRepository.deleteById(districtId);
		
	}


	@Override
	public DistrictMaster updatedistrictMaster(DistrictMaster district, Long districtId) throws ApplicationException {
		// TODO Auto-generated method stub
		district.setDistrictId(districtId);
		
		Integer districtCode = district.getDistrictCode();
		String districtName = district.getDistrictName();
		Long districtObjId = district.getDistrictId();
		
		DistrictMaster districtMaster = this.districtRepository.findById(districtId).get();
		Integer districtCodeobj = districtMaster.getDistrictCode();
		String districtNameobj = districtMaster.getDistrictName();
		if(!districtName.equals(districtNameobj)) {
			System.out.println(districtName + " = "+ districtNameobj);
			List<DistrictMaster> findByDistrictNameAndStatusFalse = districtRepository.findByDistrictNameAndStatusFalse(districtName);
			System.out.println("District Name list : "+findByDistrictNameAndStatusFalse);
			if(!findByDistrictNameAndStatusFalse.isEmpty()) {	
				
				throw new ApplicationException(Constants.ErrorCode, Constants.NameAlreadyPresent);
			}
		}
		else if(!districtCode.equals(districtCodeobj)) {
			System.out.println(districtCode + " = "+ districtCodeobj);
			List<DistrictMaster> findByDistrictCode = districtRepository.findByDistrictCodeAndStatusFalse(districtCode);
			if (!findByDistrictCode.isEmpty()) {
				throw new ApplicationException(Constants.ErrorCode, Constants.CodeAlreadyPresent);
			}
		}
		
		DistrictMaster saveDistrict = this.districtRepository.save(district);
		return saveDistrict;
	}

}
