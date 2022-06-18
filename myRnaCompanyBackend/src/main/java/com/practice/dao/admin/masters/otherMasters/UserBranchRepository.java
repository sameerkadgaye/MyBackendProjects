/**
 * 
 */
package com.practice.dao.admin.masters.otherMasters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.UserBranch;

/**
 * @author SAMEER KADGAYE
 *
 */
@Repository
public interface UserBranchRepository extends JpaRepository<UserBranch, Long>{

}
