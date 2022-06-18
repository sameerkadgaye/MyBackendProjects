package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.TalukaMaster;

/**
 * @author Anurag Ninawe
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
public interface TalukaRepository extends JpaRepository<TalukaMaster, Long> {

	public TalukaMaster findById(long talukaId);

	@Query("from TalukaMaster as p where p.status = false") // HQL Script
	public List<TalukaMaster> findTalukaByStatus();

	
	public List<TalukaMaster> findByTalukaCodeAndStatusFalse(String talukaCode);
	
	public List<TalukaMaster> findByStatusFalse();


}
