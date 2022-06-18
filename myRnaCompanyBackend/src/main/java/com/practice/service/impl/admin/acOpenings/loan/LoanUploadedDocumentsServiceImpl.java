/**
 * 
 */
package com.practice.service.impl.admin.acOpenings.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class LoanUploadedDocumentsServiceImpl implements LoanUploadedDocumentsService {

	@Autowired
	private LoanUploadedDocumentsRepository loanUploadedDocumentsRepository;

}
