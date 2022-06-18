/**
 * 
 */
package com.practice.controller.admin.masters.otherMasters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.dao.admin.masters.otherMasters.SelectModuleRepository;
import com.practice.dao.admin.masters.otherMasters.UserRoleRepository;
import com.practice.model.admin.masters.otherMaster.MenuMaster;
import com.practice.model.admin.masters.otherMaster.ModuleMaster;
import com.practice.model.admin.masters.otherMaster.SelectedModule;
import com.practice.model.admin.masters.otherMaster.User;
import com.practice.model.admin.masters.otherMaster.UserRoleMaster;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.MenuService;
import com.practice.service.inf.admin.masters.otherMasters.ModuleMasterService;
import com.practice.service.inf.admin.masters.otherMasters.SelectedModuleService;
import com.practice.service.inf.admin.masters.otherMasters.UserService;

/**
 * @author palash.kharwade
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/master")
public class UserRoleController {

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ModuleMasterService moduleMasterService;

	@Autowired
	private SelectModuleRepository selectedModuleRepository;

	@Autowired
	private SelectedModuleService selectedModuleService;

	@Autowired
	private MenuService menuMasterService;

	@GetMapping("/userRoles")
	public ResponseEntity<RequestResponse> getDistrict() {

		List<UserRoleMaster> userRoleList = userRoleRepository.findAll();

		if (userRoleList.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, userRoleList);
		}

	}

	@SuppressWarnings("unused")
	@PostMapping("/userRole")
	@ResponseBody
	public ResponseEntity<RequestResponse> saveUserRole(@RequestBody Object userRole)
			throws JSONException, JsonMappingException, JsonProcessingException {

		UserRoleMaster userRoleMaster = new UserRoleMaster();
		User user = new User();
		List<SelectedModule> selectedModuleList = new ArrayList<>();

		ModuleMaster modulem = new ModuleMaster();

		System.out.println("userRole  ===>>>> " + userRole);
		JSONObject mainRoleObject = new JSONObject(new Gson().toJson(userRole));
		System.out.println("mainRoleObject ==========>>>>  " + mainRoleObject);

		if (mainRoleObject.has("userRoleId")) {
			Integer userRoleId = mainRoleObject.getString("userRoleId").isEmpty() ? null
					: Integer.parseInt(mainRoleObject.getString("userRoleId"));
			userRoleMaster.setUserRoleId(userRoleId);

			String userName = mainRoleObject.getString("userName").isEmpty() ? null
					: mainRoleObject.getString("userName");

			userRoleMaster.setUserName(userName);
		} else {
			userRoleMaster.setUserRoleId(null);
			String userName = mainRoleObject.getString("userName").isEmpty() ? null
					: mainRoleObject.getString("userName");

			userRoleMaster.setUserName(userName);
		}

		if (mainRoleObject != null) {
			if (mainRoleObject.has("users")) {

				JSONObject usersJsonObj = new JSONObject(mainRoleObject.getString("users"));
				Long userId = Long.parseLong(usersJsonObj.getString("userId"));
				user = this.userService.getUserById(userId);

				if (mainRoleObject.has("moduleModList")) {
					System.out.println("moduleModList  ====>>> " + mainRoleObject.has("moduleModList"));
					JSONArray moduleArray = new JSONArray(mainRoleObject.getString("moduleModList"));

					for (int moduleI = 0; moduleI < moduleArray.length(); moduleI++) {

						JSONObject moduleObj = moduleArray.getJSONObject(moduleI);

						Integer moduleId = Integer.parseInt(moduleObj.getString("admmModuleId"));
						System.out.println("module id is : " + moduleId);
						modulem = moduleMasterService.getModuleMasterById(moduleId);
						SelectedModule selectedModule = new SelectedModule();

						System.out.println("moduleId ==========>>>  " + modulem.getAdmmModuleId());
//						
						selectedModule.setSelectedModuleId(null);
						selectedModule.setAdmmModSource(modulem.getAdmmModSource());
						selectedModule.setAdmmModuleCode(modulem.getAdmmModuleCode());
						selectedModule.setAdmmModuleName(modulem.getAdmmModuleName());
						selectedModule.setAdmmStatus(modulem.getAdmmStatus());

						selectedModule.setIpAddress(modulem.getIpAddress());
						selectedModule.setLastUpdate(modulem.getLastUpdate());
						selectedModule.setMacAddress(modulem.getMacAddress());
						selectedModule.setReportServerName(modulem.getReportServerName());
						selectedModule.setSeqNo(modulem.getSeqNo());
						selectedModule.setUserId(modulem.getUserId());
						selectedModule.setColorCode(modulem.getColorCode());
						selectedModule.setModuleIcon(modulem.getModuleIcon());

						Set<MenuMaster> menusList = new HashSet<>();
						System.out.println("Selected Module Data is : " + selectedModule);
						// Menu Setting Stuff
						if (moduleObj.has("menus")) {
							System.out.println("menus  ====>>> " + moduleObj.has("menus"));
							JSONArray menuArray1 = new JSONArray(moduleObj.getString("menus"));
							System.out.println("menus =====>  " + menuArray1);
							for (int j = 0; j < menuArray1.length(); j++) {
								JSONObject menuObjet = menuArray1.getJSONObject(j);
								int menuId = Integer.parseInt(menuObjet.getString("menuId"));
								System.out.println("Menu Id ====>> " + menuId);
								MenuMaster menu = new MenuMaster();
								menu = this.menuMasterService.getMenuById(menuId);
								System.out.println(menu.getMenuName());
								menusList.add(menu);
							}
							selectedModule.setMenus(menusList);
						}

						System.out.println("Before Adding selected Module : " + selectedModuleList);
						selectedModuleList.add(selectedModule);
						System.out.println("After Adding selected Module : " + selectedModuleList);
					}
					selectedModuleList.forEach(me -> {
						System.out.println("menu name ==>>> " + me.getAdmmModuleName());
					});
				}
			}

		}
//		System.out.println("moduleId ==========>>>  " + moduleMaster.getAdmmModuleId());
		userRoleMaster.setModuleModList(selectedModuleList);
		userRoleMaster.setUsers(user);
		System.out.println("userRoleId  ===>>> " + userRoleMaster.getUserRoleId());
		this.userRoleRepository.save(userRoleMaster);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
				userRole);
	}

	@GetMapping("/userRole/{userRoleId}")
	public ResponseEntity<RequestResponse> getUserRoleById(@PathVariable("userRoleId") Long userRoleId) {
		List<UserRoleMaster> userRole = this.userRoleRepository.findByUsersUserId(userRoleId);

		if (userRole == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					userRole);
		}

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				userRole);
	}

	// Find by userName
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@GetMapping("/userRoles/{userName}/{requestUrl}")
	public ResponseEntity<RequestResponse> getUserRoleById(@PathVariable("userName") String userName,
			@PathVariable("requestUrl") String path) {
		Boolean isPathAvailable = false;
		List<SelectedModule> modules = this.userRoleRepository.findByUserNameAndPath(userName, path);
		Set<MenuMaster> menus = new LinkedHashSet();
		if (modules.size() != 0) {
			for (SelectedModule selectedModule : modules) {
				menus = selectedModule.getMenus();
				for (MenuMaster menu : menus) {
					if (menu.getPath().equals(path)) {
						isPathAvailable = true;
					}
				}
			}
		}
		List<SelectedModule> userRole = this.userRoleRepository.findByUserNameAndPath(userName, path);
		System.out.println("userRole  ===>>> " + userRole);

		if (userRole == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					isPathAvailable);
		}

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				isPathAvailable);
	}

	@SuppressWarnings("unused")
	@GetMapping("/getUserRoleDetails/{userRoleMenuId}")
	public ResponseEntity<RequestResponse> getUserRoleByUserRoleMenuId(
			@PathVariable("userRoleMenuId") Long userRoleMenuId) {
		UserRoleMaster userRole = this.userRoleRepository.findByUserRoleMenuId(userRoleMenuId);

		if (userRole == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					userRole);
		} else {
			Collections.sort(userRole.getModuleModList(), new Comparator<SelectedModule>() {
				@Override
				public int compare(SelectedModule o1, SelectedModule o2) {
					return o1.getSeqNo() - o2.getSeqNo();
				}
			});
			System.out.println("Sequence Modules in get Sequence ===>> " + userRole.getModuleModList());

			List<SelectedModule> userRoleSeqModules = new ArrayList<>();

			userRole.getModuleModList().forEach(modules -> {
				List<MenuMaster> module = new ArrayList<MenuMaster>(modules.getMenus());
				Collections.sort(module, new Comparator<MenuMaster>() {
					@Override
					public int compare(MenuMaster o1, MenuMaster o2) {
						return o1.getSeqno() - o2.getSeqno();
					}
				});
				System.out.println("Sequence Module Menus in get Sequence ===>> " + module);

				Set<MenuMaster> menus = new LinkedHashSet<MenuMaster>(module);
				System.out.println("Sequence Menus in get Sequence ===>> " + menus);

				modules.setMenus(menus);

				userRoleSeqModules.add(modules);
			});

			userRole.setModuleModList(userRoleSeqModules);

			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, userRole);
		}
	}

}
