package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practice.model.admin.masters.otherMaster.OccupationMaster;

public interface OccupationRepository  extends JpaRepository<OccupationMaster, Long> {

	
	@Query("from OccupationMaster as p where p.status = false") // HQL Script
	List<OccupationMaster> findByStatusFalse();

	List<OccupationMaster> findByOccupationCodeAndStatusFalse(String occupationCode);

	
	
	
	
	
	
	
}
