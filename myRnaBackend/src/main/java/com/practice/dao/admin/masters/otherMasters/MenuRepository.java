package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.MenuMaster;

@Repository
public interface MenuRepository extends JpaRepository<MenuMaster, Integer> {

	public List<MenuMaster> findByStatusFalse();

	public MenuMaster findById(int menuId);
	
	@Query("select mm from MenuMaster mm join mm.moduleMaster vf where vf.admmModuleId = ?1 group by mm")
	public List<MenuMaster> findByModuleMasterAdmmModuleId(Integer admmModuleId);

	@Query("select mm from MenuMaster mm join mm.moduleMaster vf where vf.admmModuleId IN (:admmModuleId) and mm.status = 'false' group by mm")
	public List<MenuMaster> findByModuleMasterAdmmModuleIdStatusFalseIn(@Param("admmModuleId") List<Integer> admmModuleId);
	
}
