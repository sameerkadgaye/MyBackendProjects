/**
 * 
 */
package com.practice.service.impl.admin.acOpenings.deposit.moduleDependant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.deposit.moduleDependant.OperatorModeRepository;
import com.practice.model.admin.acOpenings.deposit.moduleDependant.OperatorMode;
import com.practice.service.inf.admin.acOpenings.deposit.moduleDependant.OperatorModeService;

/**
 * @author SAMEER KADGAYE
 *
 */
@Service
public class OperatorModeServiceImpl implements OperatorModeService{

	@Autowired
	private OperatorModeRepository operatorModeRepository;
	
	@Override
	public List<OperatorMode> saveAllOperatorModes(List<OperatorMode> operatorModes) {
		return this.operatorModeRepository.saveAll(operatorModes);
	}

	@Override
	public List<OperatorMode> getAllOperatorModes() {
		return this.operatorModeRepository.findAll();
	}

}
