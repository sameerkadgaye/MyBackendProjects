/**
 * 
 */
package com.practice.controller.admin.acOpenings.deposit;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.dao.admin.acOpenings.deposit.DepositAccountRepository;
import com.practice.dao.admin.acOpenings.loan.LoanAccountRepository;
import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.acOpenings.loan.LoanAccount;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.deposit.DepositAccountService;
import com.practice.service.inf.admin.acOpenings.loan.LoanAccountService;
import com.practice.util.AllUtils;

/**
 * @author palash.kharwade
 *
 */

@RestController
@CrossOrigin
public class TestDepositeController {
	
	@Autowired
	private DepositAccountRepository depositeAccountRepository;
	
	@Autowired
	private LoanAccountRepository loanAccountRepository;
	
	@Autowired
	private DepositAccountService depositAccountService;
	
	@Autowired
	private LoanAccountService loanAccountService;

	
	@GetMapping("/depositAccountsDate/{fromDate}/{toDate}")
	public ResponseEntity<RequestResponse> getDepositeBetDates(@PathVariable("fromDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date fromDate, @PathVariable("toDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date toDate) {
		
		System.out.println("From Date Are : "+fromDate);
		System.out.println("to Date Are : "+toDate);
		
		List<DepositAccount> depositAccount = this.depositeAccountRepository.findByTransactionDateBetween(fromDate, toDate);
		if (depositAccount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					depositAccount);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				depositAccount);
	}
	
	@GetMapping("/loanAccountsDatesforCaseApproval/{fromDate}/{toDate}")
	public ResponseEntity<RequestResponse> getLoanBetDates(@PathVariable("fromDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date fromDate, @PathVariable("toDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date toDate) {
		
		System.out.println("From Date Are : "+fromDate);
		System.out.println("to Date Are : "+toDate);
		
		List<LoanAccount> loanAccount = this.loanAccountRepository.findByTransactionDateBetween(fromDate, toDate);
		if (loanAccount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					loanAccount);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				loanAccount);
	}
	
	@PutMapping("/depositAccounts/{depositeId}/{flag}")
	public ResponseEntity<RequestResponse> approveDeposits(@Valid @PathVariable("depositeId") Long depositeId, @PathVariable("flag") String flag, @RequestBody Object depositeAccount) throws JSONException, ParseException{
	
		
		System.out.println("Delete Mapping Heated ===>>" + depositeAccount);
		DepositAccount depositAccount = this.depositAccountService.getDepositAccountById(depositeId);
		System.out.println("Account No : "+depositAccount.getAccountNo());
		JSONObject mainRoleObject = new JSONObject(new Gson().toJson(depositeAccount));
		String approveDate = mainRoleObject.getString("approveDate");
		String approveDateTime = mainRoleObject.getString("approveDateTime");
		String reason = mainRoleObject.getString("reason");
		
//		Date d = new SimpleDateFormat("dd/MM/yyyy").parse(approveDate);
		

		
		depositAccount.setApprovedStatusFlag(flag);
		depositAccount.setReasonDescription(reason);
		System.out.println("Date are : "+AllUtils.getFormattedDate(approveDate));
		depositAccount.setApproveDate(AllUtils.getFormattedDate(approveDate));
		depositAccount.setApproveDateTime(AllUtils.getFormattedDate(approveDateTime));
		
		
		if(flag.equals("Y")) {
			this.depositeAccountRepository.save(depositAccount);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.AccountApprove, HttpStatus.ACCEPTED,
					depositAccount);
		}else if(flag.equals("M")) {
			this.depositeAccountRepository.save(depositAccount);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.AccountNotApprove, HttpStatus.ACCEPTED,
					depositAccount);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.ErrorMsg, HttpStatus.ACCEPTED,
				depositAccount);
	}
	
	
	@GetMapping("/depositAccounts/{customerName}")
	public ResponseEntity<RequestResponse> getCustomerCodeWiseDepositAccounts(@PathVariable("customerName") String customerName) {
		List<DepositAccount> depositAccounts = this.depositAccountService.getCustomerNameWiseDepositAccount(customerName);
		if (depositAccounts.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.NOT_FOUND, depositAccounts);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, depositAccounts.stream().filter(da -> da.getStatus()== false).collect(Collectors.toList()));
		}
	}
	
	@GetMapping("/loanAccounts/{customerName}")
	public ResponseEntity<RequestResponse> getCustomerCodeWiseLoanAccounts(@PathVariable("customerName") String customerName) {
		List<LoanAccount> loanAccounts = this.loanAccountService.getCustomerNameWiseLoanAccount(customerName);
		if (loanAccounts.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.NOT_FOUND, loanAccounts);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, loanAccounts.stream().filter(da -> da.getStatus()== false).collect(Collectors.toList()));
		}
	}
	
	
}
