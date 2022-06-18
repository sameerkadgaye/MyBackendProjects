package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.SelectedModule;

@Repository
public interface SelectModuleRepository extends JpaRepository<SelectedModule, Integer> {

	List<SelectedModule> findByAdmmStatusFalse();

}
