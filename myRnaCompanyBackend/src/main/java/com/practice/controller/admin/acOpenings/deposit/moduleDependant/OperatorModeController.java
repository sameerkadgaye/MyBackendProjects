/**
 * 
 */
package com.practice.controller.admin.acOpenings.deposit.moduleDependant;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.admin.acOpenings.deposit.moduleDependant.OperatorMode;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.deposit.moduleDependant.OperatorModeService;
import com.practice.util.AllUtils;

/**
 * @author SAMEER KADGAYE
 *
 */
@RestController
@CrossOrigin
public class OperatorModeController {

	@Autowired
	private OperatorModeService operatorModeService;

	@GetMapping("/operatorModes")
	public ResponseEntity<RequestResponse> getOperatorModeDetails() {
		List<OperatorMode> allOperatorModes = this.operatorModeService.getAllOperatorModes();
		if (allOperatorModes.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, allOperatorModes);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED,
					allOperatorModes.stream().filter(o -> o.getStatus() == false).collect(Collectors.toList()));
		}
	}

	@PostMapping("/operatorModes")
	public ResponseEntity<RequestResponse> saveOperatorDetails(@Valid @RequestBody List<OperatorMode> operatorModes)
			throws UnknownHostException, SocketException {
		operatorModes.forEach(operator -> {
			try {
				operator.setStatus(false);
				operator.setIpAddress(AllUtils.getIpAddress());
				operator.setMacAddress(AllUtils.getMacAddress());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		List<OperatorMode> savedOperatorModes = this.operatorModeService.saveAllOperatorModes(operatorModes);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
				savedOperatorModes);
	}
}
