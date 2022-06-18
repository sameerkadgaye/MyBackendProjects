/**
 * 
 */
package com.practice.dao.admin.masters.glMaster;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.glMaster.GlMaster;


/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 25/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Repository
public interface GlMasterRepository extends JpaRepository<GlMaster, Long> {
	public GlMaster findById(long glId);

	public List<GlMaster> findByStatusFalse();
	//select MAX(tgm.gl_code) from rnas.rnas.tab_gl_master tgm where tgm.gl_type='E'
	
	  @Query("SELECT max(glCode) FROM GlMaster where glType= ?1") 
	  public String getMaxGlCode(String glType);
	  
	  public List<GlMaster> findByGlCodeAndStatusFalse(@Param("glCode") String glCode);
	 }
