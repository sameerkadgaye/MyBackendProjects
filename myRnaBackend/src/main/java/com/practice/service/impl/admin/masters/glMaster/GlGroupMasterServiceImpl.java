package com.practice.service.impl.admin.masters.glMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.glMaster.GlGroupMasterRepository;
import com.practice.model.admin.masters.glMaster.GlGroupMaster;
import com.practice.service.inf.admin.masters.glMaster.GlGroupMasterService;

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
public class GlGroupMasterServiceImpl implements GlGroupMasterService{
	@Autowired
	private GlGroupMasterRepository glGroupMasterRepository;

	@Override
	public List<GlGroupMaster> getGlGroupMasterData() {
		List<GlGroupMaster> glGroupMaster = this.glGroupMasterRepository.findAll();
		return glGroupMaster;
	}

}
