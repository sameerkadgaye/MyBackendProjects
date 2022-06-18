/**
 * 
 */
package com.practice.service.impl.admin.masters.otherMasters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.otherMasters.SelectModuleRepository;
import com.practice.model.admin.masters.otherMaster.SelectedModule;
import com.practice.service.inf.admin.masters.otherMasters.SelectedModuleService;

/**
 * @author palash.kharwade
 *
 */

@Service
public class SelectedModuleServiceImpl implements SelectedModuleService {

	@Autowired
	private SelectModuleRepository selectedModuleRepository;

	@Override
	public List<SelectedModule> getSelectedModule() {
		// TODO Auto-generated method stub
		List<SelectedModule> selectedModuleList = this.selectedModuleRepository.findByAdmmStatusFalse();
		return selectedModuleList;
	}

	@Override
	public SelectedModule getSelectedModuleById(Integer selectedmoduleId) {
		// TODO Auto-generated method stub
		SelectedModule moduleMaster = null;
		try {
			moduleMaster = this.selectedModuleRepository.findById(selectedmoduleId).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return moduleMaster;
	}

}
