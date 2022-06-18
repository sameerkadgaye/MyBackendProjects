/**
 * 
 */
package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.DocumentMaster;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 16/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@Repository
public interface DocumentMasterRepository extends JpaRepository<DocumentMaster, Long> {
	public DocumentMaster findById(long docId);

	public List<DocumentMaster> findByStatusFalse();

	public List<DocumentMaster> findByDocTypeAndStatusFalse(String docType);

	public List<DocumentMaster> findByDocNameAndDocTypeAndStatusFalse(String documentName, String docType );

}
