package com.practice.controller.common;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.dao.admin.acOpenings.deposit.DepositDetailsRepository;
import com.practice.model.common.LoanDepositeDetails;
import com.practice.model.common.LoanDepositeListData;
import com.practice.model.common.PieChartLoanDeposit;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.common.DashboardService;

/**
 * @author Dolly Raut
 *
 */
@RestController
@CrossOrigin
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@Autowired
	private DepositDetailsRepository depositDetailsRepository;

	@GetMapping("/depositCount")
	public ResponseEntity<RequestResponse> getDepositAccountsCountOnToday() {
		Long depositeCount = this.dashboardService.getDepositAccountsCountOnToday();
		System.out.println("====================Deposite Count====" + depositeCount);
		if (depositeCount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					depositeCount);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, depositeCount);
		}
	}

	@GetMapping("/loanCount")
	public ResponseEntity<RequestResponse> getLoanAccountsCountOnToday() {
		Long loanCount = this.dashboardService.getLoanAccountsCountOnToday();
		System.out.println("====================Loan Count====" + loanCount);
		if (loanCount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					loanCount);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, loanCount);
		}
	}

	@GetMapping("/receiptCount/{receiptDate}")
	public ResponseEntity<RequestResponse> getTodaysReceiptCount(
			@PathVariable("receiptDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date receiptDate) {
		Long receiptCount = this.dashboardService.getTodaysReceiptCount(receiptDate);
		System.out.println("====================Receipt Count====" + receiptCount);
		if (receiptCount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					receiptCount);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, receiptCount);
		}
	}

	@GetMapping("/paymentCount/{receiptDate}")
	public ResponseEntity<RequestResponse> getTodaysPaymentCount(
			@PathVariable("receiptDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date receiptDate) {
		Long paymentCount = this.dashboardService.getTodaysPaymentCount(receiptDate);
		System.out.println("====================Payment Count====" + paymentCount);
		if (paymentCount == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					paymentCount);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, paymentCount);
		}
	}

	@GetMapping("/depositDetailsByMonths")
	public ResponseEntity<RequestResponse> getDepositMonthWiseDetails() {

		// List<?> depositMonthWiseDetails =
		// this.depositDetailsRepository.getDepositMonthWiseDetails();
		List<LoanDepositeListData> lineChart = this.depositDetailsRepository.getDepositMonthWiseDetails();
//		List<String> finalList =null;
		System.out.println("lineChart===" + lineChart.toString());
//		depositMonthWiseDetails.forEach(s -> {
//			System.out.println("s ===> "+s.toString());
//			String json = new Gson().toJson("{"+s.toString()+"}".toString());
//			System.out.println("s ===> "+new Gson().toJson(json));
//			//sys
//		
////			Object deserialize = deserializer.deserialize(finalJson);
//		});

//		
//		String splitedList[] = depositMonthWiseDetails.toString().split(",");

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
				HttpStatus.ACCEPTED, lineChart);
	}

	@GetMapping("/pieChartForLoanDeposit")
	public ResponseEntity<RequestResponse> getPieChartForLoanDeposit() {
		List<PieChartLoanDeposit> pieChart = this.depositDetailsRepository.getPieChartForLoanDeposit();
		System.out.println("pieChart===" + pieChart.toString());
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
				HttpStatus.ACCEPTED, pieChart);
	}

	@GetMapping("/detailsOfLoanDeposit")
	public ResponseEntity<RequestResponse> getDetailsOfLoanDeposit() {
		List<LoanDepositeDetails> custDetails = this.depositDetailsRepository.getDetailsOfLoanDeposit();
		System.out.println("Details===" + custDetails.toString());
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
				HttpStatus.ACCEPTED, custDetails);
	}
}
