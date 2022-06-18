package com.practice.dao.admin.masters.glMaster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.glMaster.GlTypeFilter;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 26/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Repository
public interface GlTypeFilterRepository extends JpaRepository<GlTypeFilter, Long>{
	public GlTypeFilter findById(long glId);

}
