package com.practice.service.impl.admin.acOpenings.deposit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.deposit.DepositAccountRepository;
import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;
import com.practice.service.inf.admin.acOpenings.deposit.DepositAccountService;
import com.practice.service.inf.admin.masters.customerMaster.CustomerMasterService;

/**
 * @author SAMEER KADGAYE
 *
 */
@Service
public class DepositAccountServiceImpl implements DepositAccountService {

	@Autowired
	private DepositAccountRepository depositAccountRepository;

	@Autowired
	private CustomerMasterService customerMasterService;

	@Override
	public DepositAccount saveDepositAccount(DepositAccount depositAccount) {
		return this.depositAccountRepository.save(depositAccount);
	}

	@Override
	public List<DepositAccount> updateDepositAccountList(List<DepositAccount> depositAccounts) {
		return this.depositAccountRepository.saveAll(depositAccounts);
	}

	@Override
	public List<DepositAccount> getDepositAccount() {
//		return this.depositAccountRepository.findAll();
		return this.depositAccountRepository.findByStatusFalse();
	}

	@Override
	public DepositAccount getDepositAccountById(Long depositAccountId) {
		return this.depositAccountRepository.findById(depositAccountId).get();
	}

	@Override
	public void deleteDepositAccount(Long depositAccountId) {
		this.depositAccountRepository.deleteById(depositAccountId);
	}

	@Override
	public void updateDepositAccount(DepositAccount depositAccount) {
		this.depositAccountRepository.save(depositAccount);
	}

	@Override
	public List<DepositAccount> getCustomerIdWiseDepositAccount(Long customerMasterId) {
		CustomerMaster customerMasterById = this.customerMasterService.getCustomerMasterById(customerMasterId);
		return this.depositAccountRepository.findByCustomerMaster(customerMasterById);
	}

	@Override
	public List<DepositAccount> getCustomerCodeWiseDepositAccount(Long customerCode) {
		CustomerMaster customerMasterByCustomerCode = this.customerMasterService.findByCustomerCode(customerCode);
		return this.depositAccountRepository.findByCustomerMaster(customerMasterByCustomerCode);
	}

	public Long getMaxAccountNo() {
		return this.depositAccountRepository.getMaxAccountNo();
	}

	@Override
	public Long getMaxApplicationNo() {
		return this.depositAccountRepository.getMaxApplicationNo();
	}

	@Override
	public DepositAccount getDepositAccountByAccountNo(Long accountcNo) {
		return this.depositAccountRepository.findByAccountNo(accountcNo);
	}

	@Override
	public CustomerMaster getCustomerMasterByDepositAccountId(Long depositAccountId) {
		return this.depositAccountRepository.getCustomerMasterByDepositAccountId(depositAccountId);
	}

	@Override
	public Long getCustomerMasterCodeByDepositAccountId(Long depositAccountId) {
		return this.depositAccountRepository.getCustomerMasterCodeByDepositAccountId(depositAccountId);
	}

	@Override
	public DepositAccount getDepositAccountByAccountNoAndCustomerCode(Long customerCode, Long accountNo) {
		// TODO Auto-generated method stub
		return this.depositAccountRepository.findByCustomerCodeAndAccountNo(customerCode, accountNo);
	}

	@Override
	public List<DepositAccount> getCustomerNameWiseDepositAccount(String customerName) {
		// TODO Auto-generated method stub
//		CustomerMaster customerMasterByCustomerName = this.customerMasterService.findByCustomerName(customerName);
		return this.depositAccountRepository.findByAccountName(customerName);
	}

}
