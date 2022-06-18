package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.PinCodeMaster;

/**
 * @author SUMIT KANASKAR
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
public interface PinCodeMasterRepository extends JpaRepository<PinCodeMaster, Integer> {

	public PinCodeMaster findById(int pinCodeId);

	@Query("from PinCodeMaster as p where p.status = false") // HQL Script
	public List<PinCodeMaster> findPinCodeByStatus();

	public PinCodeMaster findByPinCode(Integer pinCode);

}
