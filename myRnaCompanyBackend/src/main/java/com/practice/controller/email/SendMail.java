/**
 * 
 */
package com.practice.controller.email;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.common.ApplicationException;
import com.practice.model.common.RequestResponse;
import com.practice.util.AllUtils;

/**
 * @author palash.kharwade
 *
 */

@RestController
@CrossOrigin
public class SendMail {
		
	@GetMapping("/sendMail/{gmail}")
	public ResponseEntity<RequestResponse> getDepositeBetDates(@PathVariable("gmail") String gmail) throws ApplicationException {
		System.out.println("Ready to send Mail : "+gmail);
		String emailOtp = "1";
		String sendEmailOtp = AllUtils.sendEmailOtp(gmail);
		if (sendEmailOtp == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					null);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.EmailAddressWrong, HttpStatus.ACCEPTED,
				sendEmailOtp);
	}
	
	@GetMapping("/sendReceiptMail/{gmail}")
	public ResponseEntity<RequestResponse> sendConfirmReceiptMail(@PathVariable("gmail") String gmail) {
		System.out.println("Ready to send Mail");
		String subject = "Receipt Conformation.";
		String text = "Dear Customer, /n/t Your receipt generated successfully. ";
		String sendEmail = AllUtils.sendEmail(subject, text, gmail);
		if (sendEmail == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					null);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.SendMail, HttpStatus.ACCEPTED,
				sendEmail);
	}
}
