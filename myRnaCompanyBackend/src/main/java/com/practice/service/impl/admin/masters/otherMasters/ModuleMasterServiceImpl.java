package com.practice.service.impl.admin.masters.otherMasters;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.otherMasters.ModuleMasterRepository;
import com.practice.model.admin.masters.otherMaster.ModuleMaster;
import com.practice.service.inf.admin.masters.otherMasters.ModuleMasterService;

/**
 * @author PALASH KHARWADE
 * @version 0.1
 * 
 *          Created Date : 29/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Service
public class ModuleMasterServiceImpl implements ModuleMasterService {

	@Autowired
	private ModuleMasterRepository moduleMasterRepository;

	@Override
	public List<ModuleMaster> getModuleMaster() {
		List<ModuleMaster> moduleMasterList = this.moduleMasterRepository.findByAdmmStatusFalse();
		return moduleMasterList;
	}

	@Override
	public ModuleMaster saveModuleMaster(ModuleMaster moduleMaster) {
		// create object of Random class
		Random obj = new Random();
		int rand_num = obj.nextInt(0xffffff + 1);
		// format it as hexadecimal string and print
		String colorCode = String.format("#%06x", rand_num);

		Color color = new Color(Color.HSBtoRGB((float) Math.random() / 2, (float) Math.random() / 2,
				0.5F + ((float) Math.random()) / 2F));
		System.out.println("Color are : " + color.toString().replace("java.awt.Color", "rgb").replace("=", "")
				.replace("[", "(").replace("]", ")").replace("r", "").replace("g", "").replace("b", ""));
		String c = "rgb" + color.toString().replace("java.awt.Color", "rgb").replace("=", "").replace("[", "(")
				.replace("]", ")").replace("r", "").replace("g", "").replace("b", "");
		moduleMaster.setColorCode(c);
		System.out.println(" C >>>>>>>>>> : " + c);

		ModuleMaster saveModuleMaster = this.moduleMasterRepository.save(moduleMaster);
		return saveModuleMaster;
	}

	@Override
	public ModuleMaster getModuleMasterById(Integer admmModuleId) {
		ModuleMaster moduleMaster = null;
		try {
			moduleMaster = this.moduleMasterRepository.findById(admmModuleId).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return moduleMaster;
	}

	@Override
	public void deleteModuleMaster(Integer admmModuleId) {
		this.moduleMasterRepository.deleteById(admmModuleId);

	}

	@Override
	public void updateModuleMaster(ModuleMaster moduleMaster, int admmModuleId) {
		moduleMaster.setAdmmModuleId(admmModuleId);
		this.moduleMasterRepository.save(moduleMaster);
	}

	@Override
	public ModuleMaster findBySeqNo(Integer seqNo) {
		return this.moduleMasterRepository.findBySeqNo(seqNo);

	}
}