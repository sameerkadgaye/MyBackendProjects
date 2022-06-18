package com.practice.service.inf.admin.masters.otherMasters;

import java.util.List;

import com.practice.model.admin.masters.otherMaster.ModuleMaster;

/**
 * @author Dolly Raut
 * @version 0.1
 * 
 *          Created Date : 29/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
public interface ModuleMasterService {

	// this method used for to get all data
	public List<ModuleMaster> getModuleMaster();

	// this method used to save module master data in db
	public ModuleMaster saveModuleMaster(ModuleMaster moduleMaster);

	// this method used for to get module master data by id
	public ModuleMaster getModuleMasterById(Integer admmModuleId);

	// this method used for to delete module data by id
	public void deleteModuleMaster(Integer admmModuleId);

	// this method used for to update district master data in db
	public void updateModuleMaster(ModuleMaster moduleMaster, int admmModuleId);

	// this method used for to get data by seqno.
	public ModuleMaster findBySeqNo(Integer seqNo);
}
