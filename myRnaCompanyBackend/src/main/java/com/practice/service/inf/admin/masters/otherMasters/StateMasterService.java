package com.practice.service.inf.admin.masters.otherMasters;

import java.util.List;

import com.practice.model.admin.masters.otherMaster.StateMaster;
import com.practice.model.common.ApplicationException;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 29/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

public interface StateMasterService {

	// this method used to save state master data in db
	public StateMaster saveState(StateMaster state) throws ApplicationException;

	// this method used for to get all data
	public List<StateMaster> getState();

	// this method used for to get state master data by id
	public StateMaster getStateById(Long stateId);

	// this method used for to delete state data by id
	public void deleteState(Long stateId);

	// this method used for to update state master data in db
	public StateMaster updateState(StateMaster student, Long stateId)  throws ApplicationException;

	// this method used for to get all data By Status false.
	public List<StateMaster> findStatesByStatus();

}
