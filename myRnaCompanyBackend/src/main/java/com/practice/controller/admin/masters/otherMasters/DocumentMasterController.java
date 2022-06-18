package com.practice.controller.admin.masters.otherMasters;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.admin.masters.otherMaster.DocumentMaster;
import com.practice.model.common.ApplicationException;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.DocumentMasterService;
import com.practice.util.AllUtils;

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
@RestController
@CrossOrigin
@RequestMapping("/master")
public class DocumentMasterController {

	@Autowired
	private DocumentMasterService docMasterService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/document")
	public ResponseEntity<RequestResponse> saveDocumentMaster(@RequestBody Object document) throws JSONException, ApplicationException {
		System.out.println("DocumentMaster=======>>>>>" + document);
		List<DocumentMaster> documentMastersListForSave = new ArrayList();
		// List<DocumentMaster> documentMastersListForUpdate = new ArrayList();

		JSONObject jsonObject = new JSONObject(AllUtils.getFormatDocTypeJson(document.toString()));
		String docType = jsonObject.getString("docType");
		System.out.println("Doc Type ====>> " + docType);

		JSONArray jsonArray = new JSONArray(jsonObject.getString("documentList"));
		System.out.println("jsonArray  ===>>> " + jsonArray);

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject documentsJsonObj = jsonArray.getJSONObject(i);
			// System.out.println("documentsJsonObj ==>> " + documentsJsonObj);

			Long docId = documentsJsonObj.getString("docId").isEmpty() ? null
					: Long.parseLong(documentsJsonObj.getString("docId"));
			System.out.println("docId For Integer ===>> " + docId);

			if (docId == null) {
				// System.out.println("Document Is Null ===>>>Save ");
				DocumentMaster documentMasterSave = new DocumentMaster();
				documentMasterSave.setDocType(docType);
				documentMasterSave.setDocName(documentsJsonObj.getString("docName"));
				documentMasterSave.setCompulsary(documentsJsonObj.getString("compulsary"));
				documentMasterSave.setPriority(documentsJsonObj.getString("priority"));
				documentMasterSave.setImgStatus(documentsJsonObj.getString("imgStatus"));
				documentMasterSave.setStatus(false);

				documentMastersListForSave.add(documentMasterSave);
			} else {
				// System.out.println("Document Is Not Null ===>>>Update ");
				DocumentMaster documentMasterForUpdate = this.docMasterService.findDocumentMasterById(docId);
				System.out.println("Document Is Not Null ===>>>Update  " + docId);
				documentMasterForUpdate.setDocId(docId);
				documentMasterForUpdate.setDocType(docType);
				documentMasterForUpdate.setDocName(documentsJsonObj.getString("docName"));
				documentMasterForUpdate.setCompulsary(documentsJsonObj.getString("compulsary"));
				documentMasterForUpdate.setPriority(documentsJsonObj.getString("priority"));
				documentMasterForUpdate.setImgStatus(documentsJsonObj.getString("imgStatus"));
				documentMasterForUpdate.setStatus(false);

				documentMastersListForSave.add(documentMasterForUpdate);
			}
		}
		this.docMasterService.saveDocument(documentMastersListForSave);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
				null);

	}

	@PostMapping("/saveDocument")
	public ResponseEntity<RequestResponse> saveDocumentMaster(@RequestBody List<DocumentMaster> documentMasterListForSave) throws JSONException {
		
		try {
			List<DocumentMaster> saveDocumentMaster = this.docMasterService.saveDocument(documentMasterListForSave);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess,
					HttpStatus.CREATED, saveDocumentMaster);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(),
					HttpStatus.ALREADY_REPORTED, null);
		}
	}
	
	@GetMapping("/documents")
	public ResponseEntity<RequestResponse> getDocumentList() {
		List<DocumentMaster> doumentList = this.docMasterService.findDocumentMasterByStatus();
		if (doumentList.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, doumentList);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, doumentList);
		}

	}

	@GetMapping("/document/{docType}")
	public ResponseEntity<RequestResponse> getDocumentListByDocType(@PathVariable("docType") String docType) {
		List<DocumentMaster> doumentList = this.docMasterService.findDocumentMasterByDocType(docType);
		if (doumentList.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, doumentList);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, doumentList);
		}

	}

	@GetMapping("/documents/{docId}")
	public ResponseEntity<RequestResponse> getDocumentMasterById(@PathVariable("docId") long docId) {
		DocumentMaster docMaster = this.docMasterService.findDocumentMasterById(docId);
		System.out.println("docMaster by Id===>>> "+docMaster);
		if (docMaster == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					docMaster);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, docMaster);
		}
	}
	
	
	
	@DeleteMapping("/document/{docId}")
	public ResponseEntity<RequestResponse> deleteDocumentDataById(@PathVariable("docId") long docId){
		DocumentMaster documnt = this.docMasterService.findDocumentMasterById(docId);
		documnt.setStatus(true);
		this.docMasterService.updateDocument(documnt, docId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess, HttpStatus.CREATED, null);
	}
}
