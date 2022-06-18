/**
 * 
 */
package com.practice.service.impl.admin.masters.otherMasters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.otherMasters.BranchMasterRepository;
import com.practice.model.admin.masters.otherMaster.AdCompanyMst;
import com.practice.model.admin.masters.otherMaster.BranchMaster;
import com.practice.service.inf.admin.masters.otherMasters.BranchMasterService;
import com.practice.service.inf.admin.masters.otherMasters.CompanyMasterService;

/**
 * @author ASHWINI SHEBE
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
public class BranchMasterServiceImpl implements BranchMasterService {
	
	@Autowired
	private BranchMasterRepository branchMasterRepo;
	
	@Autowired
	private CompanyMasterService companyMasterservice;

	@Override
	public BranchMaster saveBranch(BranchMaster branch) {
		branch.setStatus(false);
		int adcmId = Integer.parseInt(branch.getCompanyName());
		//System.out.println("adcmId in serbvice======>>>>>"+adcmId);
		
		AdCompanyMst companyMst = this.companyMasterservice.getCompanyById(adcmId);
		//System.out.println("adcmId in serbvice======>>>>>"+companyMst);
		branch.setAdCompanyMst(companyMst);
		BranchMaster saveBranch = this.branchMasterRepo.save(branch);
		return saveBranch;
	}

	@Override
	public List<BranchMaster> getBranchMasterData() {
		 List<BranchMaster> branch = this.branchMasterRepo.findAll();
		return branch;
	}

	@Override
	public BranchMaster getBranchById(long branchId) {
		BranchMaster branch = null;
		try {
			branch = this.branchMasterRepo.findById(branchId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return branch;
	}

	@Override
	public void deleteBranchMaster(Long branchId) {
		this.branchMasterRepo.deleteById(branchId);
		
	}

	@Override
	public void updateBranch(BranchMaster branch, long branchId) {
		branch.setBranchId(branchId);
		int adcmId = Integer.parseInt(branch.getCompanyName());
		//System.out.println("adcmId in serbvice======>>>>>"+adcmId);
		
		AdCompanyMst companyMst = this.companyMasterservice.getCompanyById(adcmId);
		//System.out.println("adcmId in serbvice======>>>>>"+companyMst);
		branch.setAdCompanyMst(companyMst);
		this.branchMasterRepo.save(branch);
		
	}

	@Override
	public List<BranchMaster> findBranchMasterByStatus() {
		
		return this.branchMasterRepo.findByStatusFalse();
	}


	
	
	
}
