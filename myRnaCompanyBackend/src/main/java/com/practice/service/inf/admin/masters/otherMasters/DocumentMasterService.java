/**
 * 
 */
package com.practice.service.inf.admin.masters.otherMasters;

import java.util.List;

import com.practice.model.admin.masters.otherMaster.DocumentMaster;
import com.practice.model.common.ApplicationException;

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
public interface DocumentMasterService {

	public List<DocumentMaster> saveDocument(List<DocumentMaster> data) throws ApplicationException;

	//public List<DocumentMaster> getDocumentMasterData();

	public List<DocumentMaster> findDocumentMasterByStatus();

	public DocumentMaster findDocumentMasterById(Long docId);

	public List<DocumentMaster> findDocumentMasterByDocType(String docType);
	
	public void updateDocument(DocumentMaster documnt , long docId);

}
