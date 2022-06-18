/**
 * 
 */
package com.practice.service.impl.admin.masters.otherMasters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.otherMasters.CompanyRepository;
import com.practice.model.admin.masters.otherMaster.AdCompanyMst;
import com.practice.service.inf.admin.masters.otherMasters.CompanyMasterService;

/**
 * @author ashitosh.tabhane
 *
 */
@Service
public class CompanyMasterServiceImpl implements CompanyMasterService {

	@Autowired
	private CompanyRepository compRepository;

	@Override
	public AdCompanyMst saveCompanydata(AdCompanyMst compMst) {

		AdCompanyMst saveCompany = this.compRepository.save(compMst);

		return saveCompany;
	}

	@Override
	public List<AdCompanyMst> getCompanyMaster() {
		List<AdCompanyMst> companyMaster = this.compRepository.findAll();
		return companyMaster;
	}

	@Override
	public AdCompanyMst getCompanyByID(int adcmId) {
		// TODO Auto-generated method stub
		AdCompanyMst companyMaster = null;
		try {
			companyMaster = this.compRepository.findById(adcmId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyMaster;
	}

	@Override
	public void updateCompanyMaster(AdCompanyMst companyMaster, int adcmId) {
		// TODO Auto-generated method stub
		companyMaster.setAdcmId(adcmId);
		this.compRepository.save(companyMaster);

	}

	@Override
	public AdCompanyMst getCompanyById(int compMst) {
		AdCompanyMst companyMst = null;
		try {
			companyMst = this.compRepository.findById(compMst);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return companyMst;
	}

	@Override
	public List<AdCompanyMst> findByStatus(Boolean status) {
		return this.compRepository.findByStatus(status);
	}
}
