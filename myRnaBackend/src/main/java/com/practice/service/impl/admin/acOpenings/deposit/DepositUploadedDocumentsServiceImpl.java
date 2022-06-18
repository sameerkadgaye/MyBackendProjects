/**
 * 
 */
package com.practice.service.impl.admin.acOpenings.deposit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.deposit.DepositUploadedDocumentsRepository;
import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.acOpenings.deposit.DepositUploadedDocuments;
import com.practice.service.inf.admin.acOpenings.deposit.DepositAccountService;
import com.practice.service.inf.admin.acOpenings.deposit.DepositUploadedDocumentsService;

/**
 * @author SAMEER KADGAYE
 *
 */
@Service
public class DepositUploadedDocumentsServiceImpl implements DepositUploadedDocumentsService {

	@Autowired
	private DepositUploadedDocumentsRepository depositUploadedDocumentsRepository;
	
	@Autowired
	private DepositAccountService depositAccountService;

	@Override
	public DepositUploadedDocuments saveDepositEmiCalculator(DepositUploadedDocuments depositUploadedDocument) {
		return this.depositUploadedDocumentsRepository.save(depositUploadedDocument);
	}

	@Override
	public List<DepositUploadedDocuments> saveDepositUploadedDocuments(List<DepositUploadedDocuments> depositUploadedDocuments) {
		//return this.saveDepositUploadedDocuments(depositUploadedDocuments);
		return this.depositUploadedDocumentsRepository.saveAll(depositUploadedDocuments);
	}

	@Override
	public List<DepositUploadedDocuments> getDepositUploadedDocuments() {
		return this.depositUploadedDocumentsRepository.findAll();
	}

	@Override
	public DepositUploadedDocuments getDepositUploadedDocumentsById(Long despositUploadDocId) {
		return this.depositUploadedDocumentsRepository.findById(despositUploadDocId).get();
	}

	@Override
	public void deleteDepositUploadedDocuments(Long despositUploadDocId) {
		
	}

	@Override
	public void updateDepositUploadedDocuments(DepositUploadedDocuments depositUploadedDocument) {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DepositUploadedDocuments> getDepositUploadedDocumentsByDepositAccount(Long depositAccountId) {
		List<DepositUploadedDocuments> depositUploadedDocuments= new ArrayList();
		DepositAccount depositAccountById = this.depositAccountService.getDepositAccountById(depositAccountId);
		if(depositAccountById != null && !depositAccountById.getStatus()) {
			depositUploadedDocuments = this.depositUploadedDocumentsRepository.findByDepositAccount(depositAccountById);
		}
		return depositUploadedDocuments.stream().filter(dd -> dd.getDeleteStatus() == false).collect(Collectors.toList());
	}
}
