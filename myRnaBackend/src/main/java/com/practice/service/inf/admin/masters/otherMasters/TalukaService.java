package com.practice.service.inf.admin.masters.otherMasters;

import java.util.List;

import com.practice.model.admin.masters.otherMaster.TalukaMaster;
import com.practice.model.common.ApplicationException;

/**
 * @author Anurag Ninawe
 * @version 0.1
 * 
 *          Created Date : 29/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

public interface TalukaService {

		//this method used for to get all data
		public List<TalukaMaster> getTalukas();
		
		//this method used to save district master data in db
		public TalukaMaster saveTalukaMaster(TalukaMaster Taluka)throws ApplicationException, Exception;
		
		
		// this method used for to get all data By Status false.
		public List<TalukaMaster> findTalukaByStatus();
		
		
		//this method used for to get district master data by id
		public TalukaMaster getTalukaById(Long talukaId);
		
		//this method used for to delete district data by id
		public void deleteTaluka(Long talukaId);
		
		//this method used for to update district master data in db
		public void updateTaluka(TalukaMaster Taluka, Long talukaId)throws ApplicationException, Exception;

	
	
}
