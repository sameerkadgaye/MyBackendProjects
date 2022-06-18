/**
 * 
 */
package com.practice.dao.admin.masters.otherMasters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.UserCompany;

/**
 * @author SAMEER KADGAYE
 *
 */
@Repository
public interface UserCompanyRepository extends JpaRepository<UserCompany, Long> {
	public UserCompany findBySelectedCompanyId(Long selectedCompanyId);
}
