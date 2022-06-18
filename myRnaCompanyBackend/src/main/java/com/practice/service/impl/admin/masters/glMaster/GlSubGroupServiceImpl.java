package com.practice.service.impl.admin.masters.glMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.glMaster.GlSubGroupRepository;
import com.practice.model.admin.masters.glMaster.GlSubGroup;
import com.practice.service.inf.admin.masters.glMaster.GlSubGroupService;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 26/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Service
public class GlSubGroupServiceImpl implements GlSubGroupService{
	@Autowired
	private GlSubGroupRepository glSubGroupRepository;

	@Override
	public List<GlSubGroup> getGlSubGroupData() {
		List<GlSubGroup> glSubGroup = this.glSubGroupRepository.findAll();
		return glSubGroup;
		
	}

	
}
