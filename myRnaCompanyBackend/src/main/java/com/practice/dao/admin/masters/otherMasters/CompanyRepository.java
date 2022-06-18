/**
 * 
 */
package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.AdCompanyMst;

/**
 * @author ashitosh.tabhane
 *
 */
@Repository
public interface CompanyRepository extends JpaRepository<AdCompanyMst, Integer> {

	public AdCompanyMst findById(int adcmId);

	public List<AdCompanyMst> findByStatus(Boolean status);

}