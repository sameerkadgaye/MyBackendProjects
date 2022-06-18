/**
 * 
 */
package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.SelectedModule;
import com.practice.model.admin.masters.otherMaster.UserRoleMaster;

/**
 * @author palash.kharwad
 *
 */

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleMaster, Integer> {

	public UserRoleMaster findByUserRoleId(Integer userRoleId);
	
	@Query("select vc from UserRoleMaster vc join vc.users vf where vf.userId = ?1 group by vc")
	public List<UserRoleMaster> findByUsersUserId(Long userId);

	@Query("select vc from UserRoleMaster vc join vc.users vf where vf.userId = ?1 group by vc")
	public UserRoleMaster findByUserRoleMenuId(Long userId);

	@Query("select ur.moduleModList from UserRoleMaster ur join ur.moduleModList jmm join jmm.menus jmenu where ur.userName = ?1 and jmenu.path =?2 ")
//	@Query("select ur from UserRoleMaster ur where ur.userName = ?1 and ur.moduleModList.menus.path =?2")
	public List<SelectedModule> findByUserNameAndPath(String userName, String path);

//	@Query("select vc from UserRoleMaster vc join vc.users vf where vf.userId in = ?1 group by vc")
//	public List<UserRoleMaster> findByUsersUserIdIn(List<String> userId);
	
	public UserRoleMaster findByUserName(String userName);

}
