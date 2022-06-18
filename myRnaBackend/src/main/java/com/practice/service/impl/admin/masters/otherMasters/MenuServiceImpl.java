package com.practice.service.impl.admin.masters.otherMasters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.otherMasters.MenuRepository;
import com.practice.model.admin.masters.otherMaster.MenuMaster;
import com.practice.service.inf.admin.masters.otherMasters.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<MenuMaster> getMenu() {

		return menuRepository.findByStatusFalse();
	}

	@Override
	public MenuMaster saveMenu(MenuMaster menu) {

		MenuMaster menuMaster = this.menuRepository.save(menu);
		return menuMaster;
	}

	@Override
	public MenuMaster getMenuById(int menuId) {
		MenuMaster menu = null;
		try {
			menu = this.menuRepository.findById(menuId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public List<MenuMaster> getMenusByModuleId(int moduleId) {
		return this.menuRepository.findByModuleMasterAdmmModuleId(moduleId);
	}

	@Override
	public MenuMaster updateMenuMaster(MenuMaster menu, Integer menuId) {
		menu.setMenuId(menuId);

		MenuMaster saveMenu = this.menuRepository.save(menu);
		return saveMenu;
	}

}
