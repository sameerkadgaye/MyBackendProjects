package com.practice.controller.admin.acOpenings.loan;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.dao.admin.acOpenings.loan.LoanAccountRepository;
import com.practice.model.admin.acOpenings.loan.LoanAccount;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.loan.LoanAccountService;
import com.practice.util.AllUtils;

@RestController
@CrossOrigin
@RequestMapping("/master")
public class LoanAccountController {

	@Autowired
	private LoanAccountService loanAccountService;

	@Autowired
	private LoanAccountRepository loanAccountRepository;

	@GetMapping("/loanAccountsDate/{fromDate}/{toDate}")
	public ResponseEntity<RequestResponse> getLoanBetDates(
			@PathVariable("fromDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date fromDate,
			@PathVariable("toDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date toDate) {

		System.out.println("From Date Are : " + fromDate);
		System.out.println("to Date Are : " + toDate);

		List<LoanAccount> loanAccount = this.loanAccountRepository.findByTransactionDateBetween(fromDate, toDate);
		if (loanAccount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					loanAccount);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				loanAccount);
	}

	@PutMapping("/loanAccountsDate/{loanAccountId}/{flag}")
	public ResponseEntity<RequestResponse> approveLoans(@PathVariable("loanAccountId") Long loanAccountId,
			@PathVariable("flag") Boolean flag, @RequestBody Object loanAccount) throws JSONException, ParseException {
		System.out.println("Put Mapping Heated ===>>" + loanAccountId);
		LoanAccount loanAcc = this.loanAccountService.getLoanAccountById(loanAccountId);

		JSONObject mainRoleObject = new JSONObject(new Gson().toJson(loanAccount));
		String approveDate = mainRoleObject.getString("approveDate");
		String approveDateTime = mainRoleObject.getString("approveDateTime");

		loanAcc.setApprovedStatusFlag(flag);

		System.out.println("Date are : " + AllUtils.getFormattedDate(approveDate));
		loanAcc.setApproveDate(AllUtils.getFormattedDate(approveDate));
		loanAcc.setApproveDateTime(AllUtils.getFormattedDate(approveDateTime));

		this.loanAccountService.saveLoanAccount(loanAcc);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.ACCEPTED,
				loanAcc);

	}

	// Ashutosh Sir Work
	@GetMapping("/loanAccounts")
	public ResponseEntity<RequestResponse> getAllLoanAccounts() {
		System.out.println("Inside Get All Loan Accounts ==>>>> ");
		List<LoanAccount> loanAccount = this.loanAccountService.getAllLoanAccounts();
		if (loanAccount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					loanAccount);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				loanAccount);
	}

	@GetMapping("/loanAccountById/{loanAccountId}")
	public ResponseEntity<RequestResponse> getLoanAccountById(@PathVariable Long loanAccountId) {
		System.out.println("Inside Get All LOans ==>>>> ");
		LoanAccount loanAccount = this.loanAccountService.getLoanAccountById(loanAccountId);
		if (loanAccount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					loanAccount);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				loanAccount);
	}

	@PostMapping("/loanAccount")
	public ResponseEntity<RequestResponse> saveLoanAccount(@RequestBody LoanAccount loanAccount)
			throws UnknownHostException, SocketException {
		System.out.println("Inside Save Loan Account ==>>>> ");

		Long maxAccountNo = this.loanAccountRepository.getMaxAccountNo();
		System.out.println("maxAccountNo  ===>>>>>  " + maxAccountNo);

		Long maxApplicationNo = this.loanAccountRepository.getMaxApplicationNo();
		System.out.println("maxApplicationNo ====>>>> " + maxApplicationNo);

		if (maxAccountNo == null) {
			loanAccount.setAccountNo((long) 100000);
		} else {
			loanAccount.setAccountNo(maxAccountNo);
		}

		if (maxApplicationNo == null) {
			loanAccount.setApplicationNo((long) 1);
		} else {
			loanAccount.setApplicationNo(maxApplicationNo);
		}

		loanAccount.setIpAddress(AllUtils.getIpAddress());
		loanAccount.setMacAddress(AllUtils.getMacAddress());

		LoanAccount savedLoanAccount = this.loanAccountService.saveLoanAccount(loanAccount);
//		List<LoanAccount> loanAccount = this.loanAccountService.getAllLoanAccounts();
//		if (loanAccount == null) {
//			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
//					loanAccount);
//		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.ACCEPTED,
				savedLoanAccount);
	}

	@PostMapping("/loanSchemeDetails/{loanAccountId}")
	public ResponseEntity<RequestResponse> saveLoanSchemeDetails(@PathVariable Long loanAccountId,
			@RequestBody LoanAccount loanSchemeDetails) throws UnknownHostException, SocketException {
		System.out.println("Inside Save Loan Scheme Details ==>>>> ");

		LoanAccount loanAccount = this.loanAccountService.getLoanAccountById(loanAccountId);

		loanAccount.setScheme(loanSchemeDetails.getScheme());
		loanAccount.setInterestCalculationFlag(loanSchemeDetails.getInterestCalculationFlag());
		loanAccount.setCalculationMode(loanSchemeDetails.getCalculationMode());
		loanAccount.setLedgerNo(loanSchemeDetails.getLedgerNo());
		loanAccount.setInterestProductFrequency(loanSchemeDetails.getInterestProductFrequency());
		loanAccount.setInterestPaymentFrequency(loanSchemeDetails.getInterestPaymentFrequency());
		loanAccount.setInterestStopDate(loanSchemeDetails.getInterestStopDate());
		loanAccount.setInterestStopReason(loanSchemeDetails.getInterestStopReason());
		loanAccount.setIntroducerCustomerCode(loanSchemeDetails.getIntroducerCustomerCode());
		loanAccount.setIntroducerAddress(loanSchemeDetails.getIntroducerAddress());

		LoanAccount savedLoanSchemeDetails = this.loanAccountService.saveLoanAccount(loanAccount);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.ACCEPTED,
				savedLoanSchemeDetails);
	}

	@PutMapping("/editLoanAccount/{loanAccountId}")
	public ResponseEntity<RequestResponse> editLoanAccount(@PathVariable Long loanAccountId,
			@RequestBody LoanAccount loanAccount) {
		System.out.println("Inside Loan Account Update ===>>>>");

		LoanAccount fetchedLoanAccount = this.loanAccountService.getLoanAccountById(loanAccountId);

		fetchedLoanAccount.setAccountName(loanAccount.getAccountName());
		fetchedLoanAccount.setIssueLoanType(loanAccount.getIssueLoanType());
		fetchedLoanAccount.setLoanPurpose(loanAccount.getLoanPurpose());
		fetchedLoanAccount.setRecommendedBySociety(loanAccount.getRecommendedBySociety());
		LoanAccount updatedLoanAccount = this.loanAccountService.saveLoanAccount(fetchedLoanAccount);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,
				HttpStatus.ACCEPTED, updatedLoanAccount);
	}

	@DeleteMapping("/deleteLoanAccount/{loanAccountId}")
	public ResponseEntity<RequestResponse> deleteLoanAccount(@PathVariable Long loanAccountId) {
		System.out.println("Inside Delete Loan Account ==>>>> ");

		LoanAccount loanAccount = this.loanAccountService.getLoanAccountById(loanAccountId);

		if (loanAccount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					loanAccount);
		}

		loanAccount.setStatus(true);

		LoanAccount deletedLoanAccount = this.loanAccountService.saveLoanAccount(loanAccount);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess,
				HttpStatus.ACCEPTED, deletedLoanAccount);
	}

	// Get All Loan Accounts By customerCode Starts.
	@GetMapping("/customer/customerCode/loanAccounts/{customerCode}")
	public ResponseEntity<RequestResponse> getCustomerCodeWiseLoanAccounts(
			@PathVariable("customerCode") Long customerCode) {
		List<LoanAccount> loanAccounts = this.loanAccountService.getCustomerCodeWiseLoanAccount(customerCode);
		if (loanAccounts == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, loanAccounts);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED,
//					loanAccounts.stream().filter(da -> da.getStatus() == false).collect(Collectors.toList())
					loanAccounts
					);
		}
	}
	
	// Get Loan Account By Customer Code and Account Number Starts.
		@GetMapping("/loanAccounts/{customerCode}/{accountNo}")
		public ResponseEntity<RequestResponse> getLoanAccountByCustomerCodeAndAccountNo(
				@PathVariable("accountNo") Long accountNo, @PathVariable("customerCode") Long customerCode) {
			LoanAccount loanAccount = this.loanAccountService
					.getLoanAccountByAccountNoAndCustomerCode(customerCode, accountNo);
			if (loanAccount == null) {
				return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
						loanAccount);
			}
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
					loanAccount);
		}

}
