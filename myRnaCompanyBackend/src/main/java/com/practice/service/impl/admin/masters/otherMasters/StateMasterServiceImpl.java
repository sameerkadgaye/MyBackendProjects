package com.practice.service.impl.admin.masters.otherMasters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.constants.Constants;
import com.practice.dao.admin.masters.otherMasters.StateMasterRepository;
import com.practice.model.admin.masters.otherMaster.StateMaster;
import com.practice.model.common.ApplicationException;
import com.practice.service.inf.admin.masters.otherMasters.StateMasterService;

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

@Service
public class StateMasterServiceImpl implements StateMasterService {

	@Autowired
	private StateMasterRepository stateMasterRepo;

	public StateMaster saveState(StateMaster state) throws ApplicationException {
		Integer stateGstCode = state.getStateGstCode();
		String stateName = state.getStateName();

		List<StateMaster> stateMaster = this.stateMasterRepo.findByStateGstCodeAndStatusFalse(stateGstCode);
		if (!stateMaster.isEmpty()) {
			throw new ApplicationException(Constants.ErrorCode, Constants.CodeAlreadyPresent);
		}

		List<StateMaster> findByStateNameAndStatusFalse = stateMasterRepo.findByStateNameAndStatusFalse(stateName);
		if (!findByStateNameAndStatusFalse.isEmpty()) {

			throw new ApplicationException(Constants.ErrorCode, Constants.NameAlreadyPresent);
		}
		state.setStatus(false);
		StateMaster saveState = this.stateMasterRepo.save(state);
		return saveState;
	}

	@Override
	public List<StateMaster> getState() {
		List<StateMaster> stateMaster = this.stateMasterRepo.findAll();
		return stateMaster;
	}

	@Override
	public StateMaster getStateById(Long stateId) {
		StateMaster stateMaster = null;
		try {
			stateMaster = this.stateMasterRepo.findById(stateId).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stateMaster;
	}

	@Override
	public void deleteState(Long stateId) {
		this.stateMasterRepo.deleteById(stateId);

	}

	@Override
	public StateMaster updateState(StateMaster state, Long stateId) throws ApplicationException {
		state.setStateId(stateId);

		Integer stateCode = state.getStateGstCode();
		String stateName = state.getStateName();
		Long stateObjId = state.getStateId();

		StateMaster stateMaster = this.stateMasterRepo.findById(stateId).get();
		Integer stateObjCode = stateMaster.getStateGstCode();
		String stateNameObj = stateMaster.getStateName();
		if (!stateNameObj.equals(stateName)) {
			List<StateMaster> findByStateNameAndStatusFalse = stateMasterRepo
					.findByStateNameAndStatusFalse(stateName);
			if (!findByStateNameAndStatusFalse.isEmpty()) {

				throw new ApplicationException(Constants.ErrorCode, Constants.NameAlreadyPresent);
			}
		}else if(!stateObjCode.equals(stateCode)) {
			List<StateMaster> findByStateCodeAndStatusFalse = stateMasterRepo.findByStateGstCodeAndStatusFalse(stateCode);
			if(!findByStateCodeAndStatusFalse.isEmpty()) {
				throw new ApplicationException(Constants.ErrorCode, Constants.CodeAlreadyPresent);
			}
		}

		StateMaster saveState = this.stateMasterRepo.save(state);
		return saveState;

	}

	@Override
	public List<StateMaster> findStatesByStatus() {

		return this.stateMasterRepo.findByStatusFalse();
	}

}
