/**
 * 
 */
package com.practice.controller.admin.acOpenings.deposit;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.admin.acOpenings.deposit.DepositUploadedDocuments;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.deposit.DepositAccountService;
import com.practice.service.inf.admin.acOpenings.deposit.DepositUploadedDocumentsService;
import com.practice.util.AllUtils;

/**
 * @author SAMEER.KADGAYE
 *
 */
@RestController
@CrossOrigin
public class DepositUploadedDocumentsController {

	@Autowired
	private DepositUploadedDocumentsService depositUploadedDocumentsService;

	@Autowired
	private DepositAccountService depositAccountService;

	@GetMapping("/depositUploadedDocuments")
	public ResponseEntity<RequestResponse> getDepositUploadedDocuments() {
		List<DepositUploadedDocuments> depositUploadedDocuments = this.depositUploadedDocumentsService
				.getDepositUploadedDocuments();
		if (depositUploadedDocuments.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, depositUploadedDocuments);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, depositUploadedDocuments.stream().filter(d -> d.getDeleteStatus() == false)
					.collect(Collectors.toList()));
		}
	}

	@GetMapping("/depositUploadedDocument/depositAccountId/{depositAccountId}")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<RequestResponse> getDepositAccountIdWiseDepositEmiCalculator(
			@PathVariable("depositAccountId") Long depositAccountId) {
		List<DepositUploadedDocuments> depositUploadedDocuments = new ArrayList();
		try {
			depositUploadedDocuments = this.depositAccountService.getDepositAccountById(depositAccountId)
					.getDepositUploadedDocuments();
			if (depositUploadedDocuments.size() <= 0) {
				return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
						HttpStatus.NOT_FOUND, depositUploadedDocuments);
			}
		} catch (Exception e) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, depositUploadedDocuments);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				depositUploadedDocuments);
	}

	@GetMapping("/depositUploadedDocuments/{depositAccountId}")
	public ResponseEntity<RequestResponse> getdepositUploadedDocumentsByDepositAccountId(@PathVariable("depositAccountId") Long depositAccountId) {
		List<DepositUploadedDocuments> depositUploadedDocumentsByDepositAccount = this.depositUploadedDocumentsService.getDepositUploadedDocumentsByDepositAccount(depositAccountId);
		if (depositUploadedDocumentsByDepositAccount.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.ACCEPTED, depositUploadedDocumentsByDepositAccount);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, depositUploadedDocumentsByDepositAccount);
		}
	}
	
	@PostMapping("/depositUploadedDocument")
	public ResponseEntity<RequestResponse> saveOperatorDetails(@Valid @RequestBody List<DepositUploadedDocuments> depositUploadedDocuments) throws UnknownHostException, SocketException {
		depositUploadedDocuments.forEach(document -> {
			try {
				document.setDeleteStatus(false);
				document.setIpAddress(AllUtils.getIpAddress());
				document.setMacAddress(AllUtils.getMacAddress());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		List<DepositUploadedDocuments> depositUploadedDocumentsFetched = this.depositUploadedDocumentsService.getDepositUploadedDocuments();
		if (depositUploadedDocumentsFetched.size() != 0) {
			depositUploadedDocumentsFetched.forEach(docs -> {
				if (docs.getDepositAccount().getDepositAccountId() != null) {
					docs.setDeleteStatus(true);
				}
			});
			List<DepositUploadedDocuments> deletedDepositUploadedDocuments = this.depositUploadedDocumentsService.saveDepositUploadedDocuments(depositUploadedDocumentsFetched);
			if (deletedDepositUploadedDocuments != null) {
				List<DepositUploadedDocuments> savedDepositUploadedDocuments = this.depositUploadedDocumentsService.saveDepositUploadedDocuments(depositUploadedDocuments);
				return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED, savedDepositUploadedDocuments);
			}
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveFailed, HttpStatus.ACCEPTED, null);
		} else {
			// For Newly Final Save Starts
			System.out.println("depositUploadedDocument  ====>>>  " + depositUploadedDocuments);
			List<DepositUploadedDocuments> savedDepositUploadedDocuments = this.depositUploadedDocumentsService.saveDepositUploadedDocuments(depositUploadedDocuments);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED, savedDepositUploadedDocuments);
			// For Newly Final Save Ends
		}
	}
}
