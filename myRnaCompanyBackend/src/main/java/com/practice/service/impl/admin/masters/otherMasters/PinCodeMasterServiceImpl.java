package com.practice.service.impl.admin.masters.otherMasters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.otherMasters.DistrictRepository;
import com.practice.dao.admin.masters.otherMasters.PinCodeMasterRepository;
import com.practice.dao.admin.masters.otherMasters.StateMasterRepository;
import com.practice.dao.admin.masters.otherMasters.TalukaRepository;
import com.practice.model.admin.masters.otherMaster.DistrictMaster;
import com.practice.model.admin.masters.otherMaster.PinCodeMaster;
import com.practice.model.admin.masters.otherMaster.StateMaster;
import com.practice.model.admin.masters.otherMaster.TalukaMaster;
import com.practice.service.inf.admin.masters.otherMasters.PinCodeMasterService;

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

@Service
public class PinCodeMasterServiceImpl implements PinCodeMasterService {

	@Autowired
	private PinCodeMasterRepository pinCodeMasterRepository;

	@Autowired
	private TalukaRepository talukaRepository;

	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private StateMasterRepository stateRepository;

	@Override
	public List<PinCodeMaster> getPinCodeMaster() {
		return this.pinCodeMasterRepository.findAll();
	}

	@Override
	public List<PinCodeMaster> findPinCodeByStatus() {
		return this.pinCodeMasterRepository.findPinCodeByStatus();
	}

	@Override
	public PinCodeMaster savePinCodeMaster(PinCodeMaster pinCode) {

		PinCodeMaster savePinCode = this.pinCodeMasterRepository.save(pinCode);
		return savePinCode;
	}

	@Override
	public PinCodeMaster getPinCodeMasterById(int pinCodeId) {
		PinCodeMaster pinCode = null;
		try {
			pinCode = this.pinCodeMasterRepository.findById(pinCodeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pinCode;
	}

	@Override
	public void deletePinCodeMaster(Integer pinCodeId) {
		this.pinCodeMasterRepository.deleteById(pinCodeId);
	}

	@Override
	public void updatePinCodeMaster(PinCodeMaster pinCode, int pinCodeId) {
		pinCode.setPinCodeId(pinCodeId);
		this.pinCodeMasterRepository.save(pinCode);
	}

	@Override
	public List<TalukaMaster> findTalukaByStatusFalse() {
		return this.talukaRepository.findAll();
	}

	@Override
	public List<DistrictMaster> findDistrictByStatusFalse() {
		return this.districtRepository.findAll();
	}

	@Override
	public List<StateMaster> findStateByStatusFalse() {
		return this.stateRepository.findAll();
	}

	@Override
	public PinCodeMaster findByPinCode(int pinCode) {
		return this.pinCodeMasterRepository.findByPinCode(pinCode);
	}

	@Override
	public List<StateMaster> findDistrictListBtStateId(int stateId) {
		return this.stateRepository.findByStateId(stateId);
		
	}
	
}
