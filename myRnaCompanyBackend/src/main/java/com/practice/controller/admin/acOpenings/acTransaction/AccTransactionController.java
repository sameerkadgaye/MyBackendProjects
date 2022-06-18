package com.practice.controller.admin.acOpenings.acTransaction;

import java.net.SocketException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.practice.model.admin.acOpenings.acTransaction.AccTransaction;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.acTransaction.AccTransactionService;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 02/12/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/master")
public class AccTransactionController {
	@Autowired
	private AccTransactionService accTransactionService;

	@PostMapping("/transaction")
	public ResponseEntity<RequestResponse> saveTransactionData(@RequestBody List<AccTransaction> accTransListForSave) throws JSONException, SocketException, ParseException {
		//List<AccTransaction> accTransListForSave = new ArrayList<>();
		List<AccTransaction> saveAcTransactions = this.accTransactionService.saveAcTransactions(accTransListForSave);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess,
				HttpStatus.CREATED, saveAcTransactions);
	}

	
	
	
	
	
	@GetMapping("/transaction/ReceiptDate/{recDate}")
	public ResponseEntity<RequestResponse> getReceiptDataByDate(
			@PathVariable("recDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date recDate) {
		List<AccTransaction> accTransaction = this.accTransactionService.findAcTransactionsByDate(recDate);
		System.out.println("accTransaction===>>> " + accTransaction);
		if (accTransaction == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					accTransaction);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, accTransaction);
		}
	}

	@DeleteMapping("/transaction/{acTrnId}")
	public ResponseEntity<RequestResponse> deleteReceiptDataById(@PathVariable("acTrnId") long acTrnId) {
		AccTransaction accTransaction = this.accTransactionService.findAcTransactionsById(acTrnId);
		accTransaction.setStatus(true);
		this.accTransactionService.updateDocument(accTransaction, acTrnId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess, HttpStatus.CREATED,
				null);
	}

	@GetMapping("/transaction/{acTrnId}")
	public ResponseEntity<RequestResponse> getReceiptDataById(@PathVariable("acTrnId") long acTrnId) {
		AccTransaction accTransaction = this.accTransactionService.findAcTransactionsById(acTrnId);
		System.out.println("docMaster by Id===>>> " + accTransaction);
		if (accTransaction == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					accTransaction);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, accTransaction);
		}
	}

	@GetMapping("/transaction/docNo")
	public ResponseEntity<RequestResponse> getAccTransactionMaxDocNo() {
		String docNum = this.accTransactionService.getMaxDocNo();
		if (docNum == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					docNum);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, docNum);
		}
	}

	@GetMapping("/SavedReceiptData/ReceiptDate/{recDate}")
	public ResponseEntity<RequestResponse> getReceiptTableDataByDate(
			@PathVariable("recDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date recDate) {
		System.out.println("accTransaction recDate===>>> " + recDate);
		List<AccTransaction> accTransaction = this.accTransactionService.findAcTransactionsByDate(recDate);
		System.out.println("accTransaction===>>> " + accTransaction);
		if (accTransaction == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					accTransaction);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, accTransaction);
		}
	}

}
