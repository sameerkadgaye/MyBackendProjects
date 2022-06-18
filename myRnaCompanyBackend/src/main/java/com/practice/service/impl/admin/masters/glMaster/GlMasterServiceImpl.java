/**
 * 
 */
package com.practice.service.impl.admin.masters.glMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.constants.Constants;
import com.practice.dao.admin.masters.glMaster.GlMasterRepository;
import com.practice.model.admin.masters.glMaster.GlMaster;
import com.practice.model.common.ApplicationException;
import com.practice.service.inf.admin.masters.glMaster.GlMasterService;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 25/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Service
public class GlMasterServiceImpl implements GlMasterService {
	@Autowired
	private GlMasterRepository glMasterRepository;

	@Override
	public GlMaster saveGlData(GlMaster glMaster) throws ApplicationException {

		String glCode = glMaster.getGlCode();
		List<GlMaster> glMasterCode = this.glMasterRepository.findByGlCodeAndStatusFalse(glCode);
		if(!glMasterCode.isEmpty()) {
			throw new ApplicationException(Constants.ErrorCode, Constants.CodeAlreadyPresent);
		}
		glMaster.setStatus(false);
		GlMaster saveGlMaster = this.glMasterRepository.save(glMaster);
		return saveGlMaster;
	}

	@Override
	public List<GlMaster> getGlMasterData() {
		List<GlMaster> glMaster = this.glMasterRepository.findAll();
		return glMaster;
	}

	@Override
	public GlMaster getGlDataById(long glId) {
		GlMaster glMaster = null;
		try {
			glMaster = this.glMasterRepository.findById(glId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return glMaster;
	}

	@Override
	public void deleteGlMaster(Long glId) {
		this.glMasterRepository.deleteById(glId);
	}

	@Override
	public void updateGlMaster(GlMaster glData, long glId) {
		glData.setGlId(glId);
		this.glMasterRepository.save(glData);
	}

	@Override
	public List<GlMaster> findGlMasterByStatus() {
		List<GlMaster> glMaster = this.glMasterRepository.findByStatusFalse();
		return glMaster;
	}

	@Override
	public String getMaxGlCode(String glType) {
		String code = null;
		String genetatedCode = null;
		
		try {
			code = this.glMasterRepository.getMaxGlCode(glType);
			if(code == null) {
				//System.out.println("glType in service=====>>>>"+glType);
				if(glType.equals("L")) {
					genetatedCode = "L0000";
				}else if(glType.equals("A")) {
					genetatedCode = "A0000";
				}else if(glType.equals("I")) {
					System.out.println("glType in service=====>>>>"+glType);
					genetatedCode = "I0000";
				}else  if(glType.equals("E")) {
					genetatedCode = "E0000";
				}
			}else {
				genetatedCode = code;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("genetatedCode in service=====>>>>"+genetatedCode);
		return genetatedCode;
	}

}
