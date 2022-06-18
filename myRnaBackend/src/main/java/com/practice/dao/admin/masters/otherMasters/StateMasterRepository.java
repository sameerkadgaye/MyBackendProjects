package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.StateMaster;

/**
 * @author ASHWINI SHEBE
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
public interface StateMasterRepository extends JpaRepository<StateMaster, Long> {

	public StateMaster findById(long stateId);

//	@Query("from StateMaster as s where s.stateId =:stateId")
//	public List<DistrictMaster> findDistrictsByFalse(Integer stateId);

	// @Query("from StateMaster as s where s.status = false") // HQL Script
	public List<StateMaster> findByStatusFalse();

	public List<StateMaster> findByStateGstCodeAndStatusFalse(@Param("stateGstCode") Integer stateGstCode);

	public List<StateMaster> findByStateId(int stateId);
	
	public List<StateMaster> findByStateNameAndStatusFalse(@Param("stateName") String stateName);

}
