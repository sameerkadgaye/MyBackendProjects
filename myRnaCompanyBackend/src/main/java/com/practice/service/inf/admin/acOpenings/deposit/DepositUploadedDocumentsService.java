/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.deposit;

import java.util.List;

import com.practice.model.admin.acOpenings.deposit.DepositUploadedDocuments;

/**
 * @author SAMEER KADGAYE
 *
 */
public interface DepositUploadedDocumentsService {

	public DepositUploadedDocuments saveDepositEmiCalculator(DepositUploadedDocuments depositUploadedDocument);

	public List<DepositUploadedDocuments> saveDepositUploadedDocuments(List<DepositUploadedDocuments> depositUploadedDocuments);

	public List<DepositUploadedDocuments> getDepositUploadedDocuments();

	public DepositUploadedDocuments getDepositUploadedDocumentsById(Long despositUploadDocId);

	public void deleteDepositUploadedDocuments(Long despositUploadDocId);

	public void updateDepositUploadedDocuments(DepositUploadedDocuments depositUploadedDocument);
	
	//Customized
	public List<DepositUploadedDocuments> getDepositUploadedDocumentsByDepositAccount(Long depositAccountId);
}
