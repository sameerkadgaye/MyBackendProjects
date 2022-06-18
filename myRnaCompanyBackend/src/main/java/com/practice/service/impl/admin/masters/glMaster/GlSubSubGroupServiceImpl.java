package com.practice.service.impl.admin.masters.glMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.glMaster.GlSubSubGroupRepository;
import com.practice.model.admin.masters.glMaster.GlSubSubGroup;
import com.practice.service.inf.admin.masters.glMaster.GlSubSubGroupService;

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
public class GlSubSubGroupServiceImpl implements GlSubSubGroupService{
	@Autowired
	private GlSubSubGroupRepository glSubSubGroupRepository;

	@Override
	public List<GlSubSubGroup> getGlSubSubGroupData() {
		List<GlSubSubGroup> glSubSubGroup = this.glSubSubGroupRepository.findAll();
		return glSubSubGroup;
	}

}
