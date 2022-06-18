package com.practice.service.impl.admin.masters.glMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.glMaster.GlNoteRepository;
import com.practice.model.admin.masters.glMaster.GlNote;
import com.practice.service.inf.admin.masters.glMaster.GlNoteService;

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
public class GlNoteServiceImpl implements GlNoteService{
	
	@Autowired
	private GlNoteRepository glNoteRepository;

	@Override
	public List<GlNote> getGlNoteData() {
		List<GlNote> glNote = this.glNoteRepository.findAll();
		return glNote;
	}

}
