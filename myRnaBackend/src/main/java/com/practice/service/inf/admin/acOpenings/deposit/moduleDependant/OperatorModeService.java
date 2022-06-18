/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.deposit.moduleDependant;

import java.util.List;

import com.practice.model.admin.acOpenings.deposit.moduleDependant.OperatorMode;

/**
 * @author SAMEER KADGAYE
 *
 */
public interface OperatorModeService {
	public List<OperatorMode> getAllOperatorModes();
	public List<OperatorMode> saveAllOperatorModes(List<OperatorMode> operatorModes);
}
