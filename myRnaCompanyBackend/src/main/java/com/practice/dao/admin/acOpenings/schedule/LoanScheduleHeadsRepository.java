/**
 * 
 */
package com.practice.dao.admin.acOpenings.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.schedule.LoanScheduleHeads;

/**
 * @author palash.kharwade
 *
 */

@Repository
public interface LoanScheduleHeadsRepository extends JpaRepository<LoanScheduleHeads, Long> {
	
}
