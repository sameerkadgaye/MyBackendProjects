/**
 * 
 */
package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.BranchMaster;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 11/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@Repository
public interface BranchMasterRepository extends JpaRepository<BranchMaster, Long> {
	public BranchMaster findById(long branchId);

	public List<BranchMaster> findByStatusFalse();

	
	@Query("select B from BranchMaster B join B.adCompanyMst C where C.adcmId = ?1 group by B")
	public List<BranchMaster> findBranchByCompId(Integer adcmId);

	
	
	
	
}
