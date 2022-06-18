package com.practice.controller.admin.acOpenings.acTransaction;

import java.net.SocketException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.admin.acOpenings.acTransaction.RecoveryReceipt;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.acTransaction.RecoveryReceiptService;
import com.practice.util.AllUtils;


@RestController
@CrossOrigin
@RequestMapping("/master")
public class RecoveryReceiptController {

	
	@Autowired
	private  RecoveryReceiptService recoveryReceiptService ;
	
	
	
	@PostMapping("/recoveryReceipt")
	public ResponseEntity<RequestResponse> saveRecoveryReceipt(@RequestBody Object recoveryReceipt)throws JSONException, SocketException, ParseException {
		System.out.println("recoveryReceipt Data Check----->>>  " + recoveryReceipt);
		
		try {
			System.out.println("receipt=======>>>>>" + recoveryReceipt);
			List<RecoveryReceipt> accTransListForSave = new ArrayList<>();
			
			JSONObject jsonObject = new JSONObject(AllUtils.getFormatReceiptJson(recoveryReceipt.toString()));
			
			
			System.out.println("jsonObject=======>>>>>" + jsonObject);
			String docNo = jsonObject.getString("docNo");
			Date recDate = AllUtils.getFormatDate(jsonObject.getString("recDate"));
			System.out.println("recDate ====>> " + recDate);

			JSONArray jsonArray = new JSONArray(jsonObject.getString("receiptData"));
			System.out.println("jsonArray=======>>>>>" + jsonArray);

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject receiptJsonObj = jsonArray.getJSONObject(i);

		    Long customerId = receiptJsonObj.getString("customerId").isEmpty() ? null : Long.parseLong(receiptJsonObj.getString("customerId"));
			
		    System.out.println("acTrnId For Integer ===>> " + customerId);
				if (customerId == 0) {
                    System.out.println("Inside Controller  Save");

					RecoveryReceipt accTransaction = new RecoveryReceipt();
					accTransaction.setCustomerCode(receiptJsonObj.getLong("customerCode"));
					accTransaction.setCustomerName(receiptJsonObj.getString("acName"));
					accTransaction.setPrincipalAmount(receiptJsonObj.getString("principalAmount"));
					accTransaction.setInstallmentDueDate(AllUtils.getFormatDate(receiptJsonObj.getString("transData")));
					accTransaction.setInstallmentAmount(receiptJsonObj.getString("principalRepay"));
					accTransaction.setBalance(receiptJsonObj.getString("balance"));
					accTransaction.setMode(receiptJsonObj.getString("mode"));
					accTransaction.setReferenceNumber(receiptJsonObj.getString("refNo"));
					accTransaction.setChequeOrDDNumber(receiptJsonObj.getString("cheqNo"));
					accTransaction.setRecoveryDate(AllUtils.getFormatDate(receiptJsonObj.getString("cheqDate")));
					accTransaction.setApproval(receiptJsonObj.getString("approval"));
					accTransaction.setTranType("Receipt");
					accTransaction.setAccountNo(receiptJsonObj.getLong("accountNo"));
					accTransaction.setMode(receiptJsonObj.getString("mode"));
//					accTransaction.setChequeNo(receiptJsonObj.getInt("cheqNo"));
					accTransaction.setReceiptDate(recDate);
					accTransaction.setChequeDate(AllUtils.getFormatDate(receiptJsonObj.getString("cheqDate")));
					accTransaction.setDocNo(docNo);
					accTransaction.setStatus(false);
					accTransaction.setRecoveryAmount(receiptJsonObj.getLong("recoveryAmount"));
					accTransaction.setRemainingAmount(receiptJsonObj.getLong("remainingAmount"));
					accTransaction.setEnterBy(AllUtils.getSystemName());
					accTransaction.setEnterDate(AllUtils.getCurrentDate());
					accTransaction.setIpAddress(AllUtils.getIpAddress());
					accTransaction.setMacAddress(AllUtils.getMacAddress());
					accTransListForSave.add(accTransaction);		
					
				} else {
					RecoveryReceipt accTransactionforUpdate = this.recoveryReceiptService.findAcTransactionsById(customerId); 
                    System.out.println("Inside Controller  Update");
					accTransactionforUpdate.setCustomerId(receiptJsonObj.getLong("customerId"));
					accTransactionforUpdate.setCustomerCode(receiptJsonObj.getLong("customerCode"));
					accTransactionforUpdate.setCustomerName(receiptJsonObj.getString("customerName"));
					accTransactionforUpdate.setPrincipalAmount(receiptJsonObj.getString("principalAmount"));
					accTransactionforUpdate.setInstallmentDueDate(AllUtils.getFormatDate(receiptJsonObj.getString("installmentDueDate")));
					accTransactionforUpdate.setInstallmentAmount(receiptJsonObj.getString("installmentAmount"));
					accTransactionforUpdate.setBalance(receiptJsonObj.getString("balance"));
					accTransactionforUpdate.setMode(receiptJsonObj.getString("mode"));
					accTransactionforUpdate.setReferenceNumber(receiptJsonObj.getString("refNo"));
					accTransactionforUpdate.setChequeOrDDNumber(receiptJsonObj.getString("chequeOrDDNumber"));
					accTransactionforUpdate.setRecoveryDate(AllUtils.getFormatDate(receiptJsonObj.getString("recoveryDate")));
					accTransactionforUpdate.setApproval(receiptJsonObj.getString("approval"));
					accTransactionforUpdate.setCustomerId(customerId);
					accTransactionforUpdate.setTranType("Receipt");
					accTransactionforUpdate.setAccountNo(receiptJsonObj.getLong("accountNo"));
					accTransactionforUpdate.setMode(receiptJsonObj.getString("mode"));
//					accTransactionforUpdate.setChequeNo(receiptJsonObj.getInt("cheqNo"));
					accTransactionforUpdate.setReceiptDate(recDate);
					accTransactionforUpdate.setChequeDate(AllUtils.getFormatDate(receiptJsonObj.getString("cheqDate")));
					accTransactionforUpdate.setDocNo(docNo);
					accTransactionforUpdate.setStatus(false);
					accTransactionforUpdate.setRecoveryAmount(receiptJsonObj.getLong("recoveryAmount"));
					accTransactionforUpdate.setRemainingAmount(receiptJsonObj.getLong("remainingAmount"));
					
					accTransactionforUpdate.setEnterBy(AllUtils.getSystemName());
					accTransactionforUpdate.setEnterDate(AllUtils.getCurrentDate());
					accTransactionforUpdate.setIpAddress(AllUtils.getIpAddress());
					accTransactionforUpdate.setMacAddress(AllUtils.getMacAddress());

					accTransListForSave.add(accTransactionforUpdate);
				}

			}
			List<RecoveryReceipt> saveAcTransactions = this.recoveryReceiptService.saveAcTransactions(accTransListForSave);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess,HttpStatus.CREATED, saveAcTransactions);
		    } 
		    catch (Exception e)
		    {
			e.printStackTrace();
			return RequestController.getBaseResponse(Constants.ErrorCode, e.getMessage(), HttpStatus.CREATED, null);
		    }
	}
	
	
	@GetMapping("/recRecoverytransaction/docNo")
	public ResponseEntity<RequestResponse> getrecRecoverytransactionMaxDocNo() {
		String docNum = this.recoveryReceiptService.getMaxDocNo();
		
		System.out.println("Max Of Doc No. Available : "+ docNum);
		
		if (docNum == null) {
			System.out.println("Max Of Doc No. Available 2-- : "+ docNum);

			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,docNum);

		} else {
			System.out.println("Max Of Doc No. Available 3-- : "+ docNum);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,HttpStatus.ACCEPTED, docNum);
		}
	}
	
	
	
	
}
