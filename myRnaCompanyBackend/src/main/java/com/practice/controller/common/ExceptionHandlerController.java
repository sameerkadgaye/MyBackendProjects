/**
 * 
 */
package com.practice.controller.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.practice.model.common.RequestResponse;

/**
 * @author SAMEER KADGAYE
 * @version 0.1
 * 
 *          Created Date : 28/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<RequestResponse> errorMessage(RequestResponse exception) {

		System.out.println("Exception To STRING =============>>>>" + exception.toString());
		System.out.println("Exception Get Message =============>>>>" + exception.getMessage());
//		System.out.println("Exception Get Class Name =============>>>>"+exception.getStackTrace().getClass());
//		System.out.println("Exception  =============>>>>"+exception.getStackTrace());

		// return getBaseResponse(Constants.ErrorCode, exception.getMessage(),
		// HttpStatus.INTERNAL_SERVER_ERROR, null);
		return getBaseResponse(exception.getCode(), exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
				exception.getResponse());

	}

	public ResponseEntity<RequestResponse> getBaseResponse(int code, String msg, HttpStatus httpStatus,
			Object response) {

		RequestResponse requestResponse = new RequestResponse();

		requestResponse.setCode(code);
		requestResponse.setMsg(msg);
		requestResponse.setResponse(response);
		requestResponse.setHttpStatus(httpStatus);

		return new ResponseEntity<RequestResponse>(requestResponse, httpStatus);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
}
