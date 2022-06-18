package com.practice.service.inf.admin.masters.otherMasters;

import java.util.List;

import com.practice.model.admin.masters.otherMaster.DistrictMaster;
import com.practice.model.common.ApplicationException;

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

public interface DistrictService {

	//this method used for to get all data
	public List<DistrictMaster> getDistrict();
	
	//this method used to save district master data in db
	public DistrictMaster saveDistrict(DistrictMaster district) throws ApplicationException, Exception;
	//public ResponseEntity<RequestResponse> saveDistrict(DistrictMaster district);
	
	//this method used for to get district master data by id
	public DistrictMaster getDistrictById(Long districtId);
	
	//this method used for to delete district data by id
	public void deleteDistrict(Long districtId);
	
	//this method used for to update district master data in db
	public DistrictMaster updatedistrictMaster(DistrictMaster districtbyid, Long districtId) throws ApplicationException;

	

}
