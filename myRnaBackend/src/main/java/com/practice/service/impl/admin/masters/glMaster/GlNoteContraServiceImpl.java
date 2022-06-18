package com.practice.service.impl.admin.masters.glMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.glMaster.GlNoteContraRepository;
import com.practice.model.admin.masters.glMaster.GlNoteContra;
import com.practice.service.inf.admin.masters.glMaster.GlNoteContraService;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 30/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Service
public class GlNoteContraServiceImpl implements GlNoteContraService{
	@Autowired
	private GlNoteContraRepository glNoteContraRepository;

	@Override
	public List<GlNoteContra> getGlNoteContraData() {
		List<GlNoteContra> glContraNote = this.glNoteContraRepository.findAll();
		return glContraNote;
	}

}
