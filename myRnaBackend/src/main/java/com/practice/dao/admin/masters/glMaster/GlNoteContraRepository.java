package com.practice.dao.admin.masters.glMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.glMaster.GlNoteContra;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 30/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@Repository
public interface GlNoteContraRepository extends JpaRepository<GlNoteContra, Long> {

	public GlNoteContra findById(long contraId);
}
