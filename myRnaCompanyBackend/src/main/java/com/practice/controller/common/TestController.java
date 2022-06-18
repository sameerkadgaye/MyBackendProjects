/**
 * 
 */
package com.practice.controller.common;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dao.admin.masters.customerMaster.CustomerMasterRepository;
import com.practice.dao.common.TestRepository;
import com.practice.model.common.Test;
import com.practice.util.JwtUtil;

/**
 * @author SAMEER KADGAYE
 *
 */
@RestController
@RequestMapping("/api/")
public class TestController {

	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomerMasterRepository masterRepository;

	@GetMapping("/getTest")
	public Long testAnyPageData() {
		Long maxCustomerCode = this.masterRepository.getMaxCustomerCode();
		System.out.println("maxCustomerCode ===>> " + maxCustomerCode);
		return maxCustomerCode;
	}

	@GetMapping("/tests")
	public List<Test> getTestPages() {
		return this.testRepository.findAll();
	}

	@PostMapping("/test")
	public ResponseEntity<Test> getTestSavePage(@Valid @RequestBody Test test) {
		if (this.testRepository.getMaxTestApplicationNo() == null) {
			System.out.println("Max Is Null  ===>>> " + this.testRepository.getMaxTestApplicationNo());
			test.setTestApplicationNo((long) 100000);
			Test saved = testRepository.save(test);
			return new ResponseEntity<Test>(saved, HttpStatus.CREATED);
		} else {
			System.out.println("Max Is Not Null  ===>>> " + this.testRepository.getMaxTestApplicationNo());
			// test.setTestApplicationNo(this.testRepository.getMaxTestApplicationNo());
			Test saved = testRepository.save(test);
			return new ResponseEntity<Test>(saved, HttpStatus.CREATED);
		}
	}

	@GetMapping("/testException")
	public String getTestExceptionPage(@RequestBody Test test) throws Exception {
		System.out.println(test);
		throw new ArithmeticException("got exception");
		// testRepository.save(test);
		// return "Saved Successfully";
	}

	@GetMapping("/testSeq")
	public String getTestSequence() {
		Long maxTestApplicationNo = this.testRepository.getMaxTestApplicationNo();
		System.out.println("maxTestApplicationNo ===>> " + maxTestApplicationNo);
		return "Fetch Successfully";
	}
}
