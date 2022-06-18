package com.practice.service.impl.admin.masters.otherMasters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.constants.Constants;
import com.practice.dao.admin.masters.otherMasters.OccupationRepository;
import com.practice.model.admin.masters.otherMaster.OccupationMaster;
import com.practice.model.common.ApplicationException;
import com.practice.service.inf.admin.masters.otherMasters.OccupationService;

@Service
public class OccupationServiceimpl implements OccupationService{

	@Autowired
    OccupationRepository occupationRepository;
	
	
	@Override
	public OccupationMaster saveOccupationMaster(OccupationMaster occupation) throws ApplicationException  {
		
		String  occupationCode = occupation.getOccupationCode();
		List<OccupationMaster> findByoccupationCode = occupationRepository.findByOccupationCodeAndStatusFalse(occupationCode);
		if (!findByoccupationCode.isEmpty()) {
			throw new ApplicationException(Constants.ErrorCode, Constants.CodeAlreadyPresent);
		}
		
		OccupationMaster saveOccupation = this.occupationRepository.save(occupation);
		return saveOccupation;
	}
	
	
	


	@Override
	public List<OccupationMaster> getOccupations() {
		List<OccupationMaster>  occupationlist = this.occupationRepository.findByStatusFalse();
		return occupationlist;
	}


	@Override
	public OccupationMaster getOccupationById(Long occupationId) {
		
		OccupationMaster occupation = null;
		try {
			occupation = this.occupationRepository.findById(occupationId).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return occupation;
	}


	@Override
	public void updateOccupation(OccupationMaster occupationbyId, Long occupationId) throws ApplicationException {
//		String  OccupationCode = occupationbyId.getOccupationCode();
//		List<OccupationMaster> findByOccupationCode = occupationRepository.findByOccupationCodeAndStatusFalse(OccupationCode);
//		if (!findByOccupationCode.isEmpty()) {
//			throw new ApplicationException(Constants.ErrorCode, Constants.CodeAlreadyPresent);
//		}
		
//		else {
			occupationbyId.setOccupationId(occupationId);
		    this.occupationRepository.save(occupationbyId);
//	    }
	}

	
	
	
	
	
}
