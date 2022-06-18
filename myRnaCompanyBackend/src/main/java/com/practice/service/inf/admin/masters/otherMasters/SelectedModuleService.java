/**
 * 
 */
package com.practice.service.inf.admin.masters.otherMasters;

import java.util.List;

import com.practice.model.admin.masters.otherMaster.SelectedModule;

/**
 * @author palash.kharwade
 *
 */


public interface SelectedModuleService {

	List<SelectedModule> getSelectedModule();

	SelectedModule getSelectedModuleById(Integer moduleId);

}
