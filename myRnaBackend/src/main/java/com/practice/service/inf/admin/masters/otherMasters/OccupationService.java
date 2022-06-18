package com.practice.service.inf.admin.masters.otherMasters;

import java.util.List;

import com.practice.model.admin.masters.otherMaster.OccupationMaster;
import com.practice.model.common.ApplicationException;

/**
 * @author Anurag Ninawe
 * @version 0.1
 * 
 *          Created Date : 18/01/2022
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
public interface OccupationService {

	OccupationMaster  saveOccupationMaster(OccupationMaster occupation) throws ApplicationException;

	List<OccupationMaster> getOccupations();

	OccupationMaster getOccupationById(Long occupationId);

	void updateOccupation(OccupationMaster occupationbyId, Long occupationId) throws ApplicationException;
	
	
	
	

}
