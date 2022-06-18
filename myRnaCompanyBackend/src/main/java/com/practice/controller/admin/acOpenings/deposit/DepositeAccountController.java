/**
 * 
 */
package com.practice.controller.admin.acOpenings.deposit;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.dao.admin.acOpenings.deposit.DepositAccountRepository;
import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.deposit.DepositAccountService;
import com.practice.util.AllUtils;

/**
 * @author SAMEER KADGAYE
 *
 */
@RestController
@CrossOrigin
public class DepositeAccountController {

	@Autowired
	private DepositAccountService depositAccountService;

	@Autowired
	private DepositAccountRepository depositAccountRepository;

	//Get All Deposit Account Starts.
	@GetMapping("/depositAccounts")
	public ResponseEntity<RequestResponse> getDepositAccounts() {
		List<DepositAccount> depositAccounts = this.depositAccountService.getDepositAccount();
		if (depositAccounts.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, depositAccounts);
		}
	}
	//Get All Deposit Account Ends.

	//Get Deposit Account By Id Starts.
	@GetMapping("/depositAccount/{depositAccountId}")
	public ResponseEntity<RequestResponse> getStudentById(@PathVariable("depositAccountId") Long depositAccountId) {
		DepositAccount depositAccount = this.depositAccountService.getDepositAccountById(depositAccountId);
		if (depositAccount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					depositAccount);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				depositAccount);
	}
	//Get Deposit Account By Id Ends.

	//Get Deposit Account wise Customer By depositAccountId Starts.
	@GetMapping("/depositAccount/customer/{depositAccountId}")
	public ResponseEntity<RequestResponse> getDepositAccountIdWiseCustomerMaster(
			@PathVariable("depositAccountId") Long depositAccountId) {
		CustomerMaster customer = this.depositAccountService.getCustomerMasterByDepositAccountId(depositAccountId);
		if (customer == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					customer);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				customer);
	}
	//Get Deposit Account wise Customer By depositAccountId Ends.

	//SAVE And UPDATE Deposit Account Starts
	@PostMapping("/depositAccount")
	public ResponseEntity<RequestResponse> saveStudent(@Valid @RequestBody DepositAccount depositAccount)
			throws UnknownHostException, SocketException {
		System.out.println("desposite Accoiunt desposite id ========>>> " + depositAccount.getDepositAccountId());
		if (depositAccount.getDepositAccountId() == null) {
			System.out.println("desposite Accoiunt desposite id IF========>>> " + depositAccount.getDepositAccountId());
			Long maxAccountNo = this.depositAccountService.getMaxAccountNo();
			System.out.println("maxAccountNo  ===>>>>>  " + maxAccountNo);

			Long maxApplicationNo = this.depositAccountService.getMaxApplicationNo();
			System.out.println("maxApplicationNo ====>>>> " + maxApplicationNo);

			if (maxAccountNo == null) {
				depositAccount.setAccountNo((long) 100000);
			} else {
				depositAccount.setAccountNo(maxAccountNo);
			}

			if (maxApplicationNo == null) {
				depositAccount.setApplicationNo((long) 1);
			} else {
				depositAccount.setApplicationNo(maxApplicationNo);
			}

			depositAccount.setIpAddress(AllUtils.getIpAddress());
			depositAccount.setMacAddress(AllUtils.getMacAddress());
			DepositAccount savedDepositAccount = this.depositAccountService.saveDepositAccount(depositAccount);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess,
					HttpStatus.CREATED, savedDepositAccount);
		} else {
			System.out
					.println("desposite Accoiunt desposite id Else========>>> " + depositAccount.getDepositAccountId());
			System.out.println("Account Number =========>>>> " + depositAccount.getAccountName());
			System.out.println("Account Number =========>>>> " + depositAccount.getAccountNo());
			DepositAccount updatedDepositAccount = this.depositAccountService.saveDepositAccount(depositAccount);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,
					HttpStatus.CREATED, updatedDepositAccount);
		}

	}
	//SAVE And Update Deposit Account Ends

	//Update Deposit Account Starts(Not Used In Project Currently).
	@PutMapping("/depositAccount/{depositAccountId}")
	public ResponseEntity<RequestResponse> updateDepositAccount(@RequestBody DepositAccount depositAccount,
			@PathVariable("depositAccountId") Long depositAccountId) {
		if (depositAccount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					depositAccount);
		}
		depositAccount.setDepositAccountId(depositAccountId);
		this.depositAccountService.updateDepositAccount(depositAccount);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED,
				depositAccount);
	}
	//Update Deposit Account Ends (Not Used In Project Currently).

	//Delete Deposit Account By depositAccountId Starts.
	@DeleteMapping("/depositAccount/{depositAccountId}")
	public ResponseEntity<RequestResponse> deleteDepositAccountIdById(
			@PathVariable("depositAccountId") Long depositAccountId) {
		DepositAccount depositAccount = this.depositAccountService.getDepositAccountById(depositAccountId);
		if (depositAccount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					depositAccount);
		} else {
			depositAccount.setStatus(true);
			this.depositAccountService.saveDepositAccount(depositAccount);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess, HttpStatus.OK,
					depositAccount);
		}
	}
	//Delete Deposit Account By depositAccountId Ends.

	//Get All Deposit Accounts By customerMasterId Starts.
	@GetMapping("/customer/customerMasterId/depositAccounts/{customerMasterId}")
	public ResponseEntity<RequestResponse> getCustomerIdWiseDepositAccounts(
			@PathVariable("customerMasterId") Long customerMasterId) {
		List<DepositAccount> depositAccounts = this.depositAccountService
				.getCustomerIdWiseDepositAccount(customerMasterId);
		if (depositAccounts.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED,
					depositAccounts.stream().filter(da -> da.getStatus() == false).collect(Collectors.toList()));
		}
	}
	//Get All Deposit Accounts By customerMasterId Ends.

	//Get All Deposit Accounts By customerCode Starts.
	@GetMapping("/customer/customerCode/depositAccounts/{customerCode}")
	public ResponseEntity<RequestResponse> getCustomerCodeWiseDepositAccounts(
			@PathVariable("customerCode") Long customerCode) {
		List<DepositAccount> depositAccounts = this.depositAccountService
				.getCustomerCodeWiseDepositAccount(customerCode);
		if (depositAccounts.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, depositAccounts);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED,
					depositAccounts.stream().filter(da -> da.getStatus() == false).collect(Collectors.toList()));
		}
	}
	//Get All Deposit Accounts By customerCode Ends.

	// Get Deposit Account By Account Number Starts.
	@GetMapping("/depositAccount/accountNo/{accountNo}")
	public ResponseEntity<RequestResponse> getDepositAccountByAccountNo(@PathVariable("accountNo") Long accountNo) {
		DepositAccount depositAccount = this.depositAccountService.getDepositAccountByAccountNo(accountNo);
		if (depositAccount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					depositAccount);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				depositAccount);
	}
	// Get Deposit Account By Account Number Ends.

	// Get CustomerId By Deposit Account Id Starts
	@GetMapping("/depositAccount/customerMasterId/{depositAccountId}")
	public ResponseEntity<RequestResponse> getCustomerAccountCodeByDepositAccountId(
			@PathVariable("depositAccountId") Long depositAccountId) {
		Long customerMasterIdByDepositAccountId = this.depositAccountService
				.getCustomerMasterCodeByDepositAccountId(depositAccountId);
		// Long customerMasterIdByDepositAccountId =
		// this.depositAccountRepository.getCustomerMasterIdByDepositAccountId(depositAccountId);
		// Long depositeAccountIdByDepositAccountId =
		// this.depositOperatorDetailsRepository.getDepositeAccountIdByDepositAccountId(depositOperatorDetailsId);
		System.out.println("customerMasterIdByDepositAccountId  ===>>>> " + customerMasterIdByDepositAccountId);
		if (customerMasterIdByDepositAccountId == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.ACCEPTED,
					customerMasterIdByDepositAccountId);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				customerMasterIdByDepositAccountId);
	}
	// Get CustomerId By Deposit Account Id Ends.

	// Get Deposit Account By Customer Code and Account Number Starts.
	@GetMapping("/depositAccounts/{customerCode}/{accountNo}")
	public ResponseEntity<RequestResponse> getDepositAccountByCustomerCodeAndAccountNo(
			@PathVariable("accountNo") Long accountNo, @PathVariable("customerCode") Long customerCode) {
		DepositAccount depositAccount = this.depositAccountService
				.getDepositAccountByAccountNoAndCustomerCode(customerCode, accountNo);
		if (depositAccount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					depositAccount);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				depositAccount);
	}
	// Get Deposit Account By Customer Code and Account Number Ends.

}
