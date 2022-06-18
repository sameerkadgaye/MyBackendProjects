package com.practice.service.inf.admin.masters.otherMasters;

import java.util.List;

import com.practice.model.admin.masters.otherMaster.MenuMaster;

public interface MenuService {

	List<MenuMaster> getMenu();

	MenuMaster saveMenu(MenuMaster menu);

	public MenuMaster getMenuById(int menuId);

	public List<MenuMaster> getMenusByModuleId(int moduleId);

	MenuMaster updateMenuMaster(MenuMaster menu, Integer menuId);

}
