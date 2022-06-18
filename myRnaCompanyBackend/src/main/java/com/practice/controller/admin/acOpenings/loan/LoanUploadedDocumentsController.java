/**
 * 
 */
package com.practice.controller.admin.acOpenings.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dao.admin.acOpenings.loan.LoanUploadedDocumentsRepository;
import com.practice.service.inf.admin.acOpenings.loan.LoanUploadedDocumentsService;

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 05/02/2022
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@RestController
@CrossOrigin
@RequestMapping
public class LoanUploadedDocumentsController {

	@Autowired
	private LoanUploadedDocumentsRepository loanUploadedDocumentsRepository;

	@Autowired
	private LoanUploadedDocumentsService loanUploadedDocumentsService;

}
