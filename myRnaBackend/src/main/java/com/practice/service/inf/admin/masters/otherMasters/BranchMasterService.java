/**
 * 
 */
package com.practice.service.inf.admin.masters.otherMasters;

import java.util.List;

import com.practice.model.admin.masters.otherMaster.BranchMaster;



/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 11/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
public interface BranchMasterService {
	
	// this method used to save state master data in db
		public BranchMaster saveBranch(BranchMaster branch);
		
		// this method used for to get all data
		public List<BranchMaster> getBranchMasterData();
		
		// this method used for to get state master data by id
		public BranchMaster getBranchById(long branchId);

	
		// this method used for to delete state data by id
		public void deleteBranchMaster(Long branchId);

		// this method used for to update state master data in db
		public void updateBranch(BranchMaster branch, long branchId);
		
		// this method used for to get all data By Status false.
		public List<BranchMaster> findBranchMasterByStatus();

}
