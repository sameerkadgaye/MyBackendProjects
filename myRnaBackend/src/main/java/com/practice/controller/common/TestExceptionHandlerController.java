package com.practice.controller.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.model.common.RequestResponse;

@RestController
public class TestExceptionHandlerController {

	@GetMapping("/testExceptions")
	public ResponseEntity<RequestResponse> getStudents() {
		
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, null);
	}
}
