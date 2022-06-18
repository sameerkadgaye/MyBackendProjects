package com.practice.service.inf.admin.masters.otherMasters;

import java.util.List;

import com.practice.model.admin.masters.otherMaster.DistrictMaster;
import com.practice.model.admin.masters.otherMaster.PinCodeMaster;
import com.practice.model.admin.masters.otherMaster.StateMaster;
import com.practice.model.admin.masters.otherMaster.TalukaMaster;

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 29/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

public interface PinCodeMasterService {

	// this method used for to get all data
		public List<PinCodeMaster> getPinCodeMaster();

		// this method used for to get all data By Status false.
		public List<PinCodeMaster> findPinCodeByStatus();

		// this method used to save pinCode master data in db
		public PinCodeMaster savePinCodeMaster(PinCodeMaster pinCode);

		// this method used for to get pinCode master data by id
		public PinCodeMaster getPinCodeMasterById(int pinCodeId);

		// this method used for to delete pinCode data by id
		public void deletePinCodeMaster(Integer pinCodeId);

		// this method used for to update pinCode master data in db
		public void updatePinCodeMaster(PinCodeMaster pinCode, int pinCodeId);

		// this method used for to get all talukas
		public List<TalukaMaster> findTalukaByStatusFalse();

		// this method used for to get all districts
		public List<DistrictMaster> findDistrictByStatusFalse();
		
		// this method used for to get all state
		public List<StateMaster> findStateByStatusFalse();
		
		public PinCodeMaster findByPinCode(int pinCode);
		
		public List<StateMaster> findDistrictListBtStateId(int stateId);
}
