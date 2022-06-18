package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.ModuleMaster;

/**
 * @author Dolly Raut
 * @version 0.1
 * 
 *          Created Date : 29/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@Repository
public interface ModuleMasterRepository extends JpaRepository<ModuleMaster, Integer> {

	public ModuleMaster findById(int admmModuleId);

//	@Query("from ModuleMaster as n where n.seqNo =: seqNo") // HQL Script
//	public List<ModuleMaster> findPinCodeByStatus();
	public ModuleMaster findBySeqNo(Integer seqNo);

	public List<ModuleMaster> findByAdmmStatusFalse();
}
