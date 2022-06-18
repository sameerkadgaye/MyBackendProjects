package com.practice.controller.admin.masters.otherMasters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dao.admin.acOpenings.deposit.DepositEmiCalculatorRepository;

/**
 * @author DOLLY RAUT
 * @version 0.1
 * 
 *          Created Date : 08/12/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/master")
public class SMSMasterController {
	
	@Autowired
	public DepositEmiCalculatorRepository depositEmiCalculatorRepository;
	
	
//	@GetMapping("/depositeList")
//	public ResponseEntity<RequestResponse> getAllDepositeDetails(){
//		List<DepositEmiCalculator> list = (List<DepositEmiCalculator>) this.depositEmiCalculatorRepository.findAll();
//		System.out.println("list ====>> "+list);
//		if (list.size() <= 0) {
//			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
//					HttpStatus.NOT_FOUND, list);
//		} else {
//			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
//					HttpStatus.ACCEPTED, list);
//		}
//		
//	}

}
