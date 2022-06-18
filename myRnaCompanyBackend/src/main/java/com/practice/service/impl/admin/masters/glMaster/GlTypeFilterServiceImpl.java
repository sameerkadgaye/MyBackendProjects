package com.practice.service.impl.admin.masters.glMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.glMaster.GlTypeFilterRepository;
import com.practice.model.admin.masters.glMaster.GlTypeFilter;
import com.practice.service.inf.admin.masters.glMaster.GlTypeFilterService;

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
public class GlTypeFilterServiceImpl implements GlTypeFilterService{
	@Autowired
	private GlTypeFilterRepository glTypeFilterRepository;

	@Override
	public List<GlTypeFilter> getGlTypeFilterData() {
		List<GlTypeFilter> glTypeFilter = this.glTypeFilterRepository.findAll();
		return glTypeFilter;
		
	}

}
