package com.practice.service.inf.admin.masters.otherMasters;


import java.util.List;

import com.practice.model.admin.masters.otherMaster.AdCompanyMst;

/**
 * @author ashitosh.tabhane
 *
 */
public interface CompanyMasterService {
	public AdCompanyMst saveCompanydata(AdCompanyMst compMst);
	public List<AdCompanyMst> getCompanyMaster(); // this method used for to get company master data by id	
	public  AdCompanyMst  getCompanyByID(int adcmId) ; // this method used for to update state master data in db
	public void updateCompanyMaster(AdCompanyMst companyMaster, int adcmId);
	public AdCompanyMst getCompanyById(int compMst);
	public List<AdCompanyMst> findByStatus(Boolean status);
}
