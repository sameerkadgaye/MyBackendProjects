package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.DistrictMaster;

/**
 * @author PALASH KHARWADE
 * @version 0.1
 * 
 *          Created Date : 29/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Repository
public interface DistrictRepository extends JpaRepository<DistrictMaster, Long> {

	public DistrictMaster findById(long districtId);

//	@Query("SELECT t FROM Tab_district t WHERE LOWER(t.districtCode) = LOWER(:districtCode)")
	public List<DistrictMaster> findByDistrictCodeAndStatusFalse(@Param("districtCode") Integer districtCode);

	public List<DistrictMaster> findByDistrictNameAndStatusFalse(@Param("districtName") String districtName);
	
	public List<DistrictMaster> findByStatusFalse();

}
