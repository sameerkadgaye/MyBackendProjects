/**
 * 
 */
package com.practice.dao.admin.acOpenings.deposit.moduleDependant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.deposit.moduleDependant.OperatorMode;

/**
 * @author sameer.kadgaye
 *
 */
@Repository
public interface OperatorModeRepository extends JpaRepository<OperatorMode, Long>{

}
