package com.practice.service.impl.admin.masters.otherMasters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.constants.Constants;
import com.practice.dao.admin.masters.otherMasters.DocumentMasterRepository;
import com.practice.model.admin.masters.otherMaster.DocumentMaster;
import com.practice.model.common.ApplicationException;
import com.practice.service.inf.admin.masters.otherMasters.DocumentMasterService;

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

@Service
public class DocumentMasterServiceImpl implements DocumentMasterService {

	@Autowired
	DocumentMasterRepository docMasterRepo;

	@Override
	public List<DocumentMaster> saveDocument(List<DocumentMaster> data) throws ApplicationException {
		//String documentName = null;
		System.out.println("DocumentMaster====>>>"+data);
		for (int i = 0; i < data.size(); i++) {
			String docType = data.get(i).getDocType();
			Long docId = data.get(i).getDocId();
			String documentName = data.get(i).getDocName();
			System.out.println("docType====>>>"+docType);
			System.out.println("documentName====>>>"+documentName);
			System.out.println("docId=====>>>"+docId);
			
			if(docId == null) {
				List<DocumentMaster> findByDocNameAndStatusFalse = docMasterRepo.findByDocNameAndDocTypeAndStatusFalse(documentName, docType);
				System.out.println("documentName for save====>>>"+findByDocNameAndStatusFalse);
				if (!findByDocNameAndStatusFalse.isEmpty()) {
					System.out.println("inside if====>>>");
					throw new ApplicationException(Constants.ErrorCode, Constants.NameAlreadyPresent);
				}
				
			}
			
		}
		

		List<DocumentMaster> saveDocMasterList = this.docMasterRepo.saveAll(data);
		return saveDocMasterList;
	}

	/*
	 * @Override public List<DocumentMaster> getDocumentMasterData() {
	 * List<DocumentMaster> documentList = this.docMasterRepo.findAll(); return
	 * documentList; }
	 */

	@Override
	public List<DocumentMaster> findDocumentMasterByStatus() {

		return this.docMasterRepo.findByStatusFalse();
	}

	public List<DocumentMaster> findDocumentMasterByDocType(String docType) {
		return this.docMasterRepo.findByDocTypeAndStatusFalse(docType);
	}

	@Override
	public DocumentMaster findDocumentMasterById(Long docId) {
		return this.docMasterRepo.findById(docId).get();
	}
	
	@Override
	public void updateDocument(DocumentMaster document, long docId) {
		document.setDocId(docId);
		this.docMasterRepo.save(document);
		
	}

}
