package com.practice.controller.admin.masters.otherMasters;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.dao.admin.masters.otherMasters.MenuRepository;
import com.practice.model.admin.masters.otherMaster.MenuMaster;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.MenuService;

@RestController
@CrossOrigin
@RequestMapping("/master")
public class MenuMasterController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private MenuRepository menuRepository;

	@GetMapping("/menus")
	public ResponseEntity<RequestResponse> getMenus() {

		List<MenuMaster> menuList = menuService.getMenu();
		if (menuList.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, menuList);
		}

	}

	@PostMapping("/menu")
	public ResponseEntity<RequestResponse> saveMenu(@RequestBody MenuMaster menu) throws Exception {
//	try {
		this.menuService.saveMenu(menu);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
				menu);
//		}
//		catch (ApplicationException e) {
//			return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(), HttpStatus.ALREADY_REPORTED,
//					null);
//		}
	}

	@GetMapping("/menu/{menuId}")
	public ResponseEntity<RequestResponse> getMenuById(@PathVariable("menuId") Integer menuId) {
		MenuMaster menulist = this.menuService.getMenuById(menuId);
		if (menulist == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					menulist);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				menulist);
	}

	@GetMapping("/menus/{moduleId}")
	public ResponseEntity<RequestResponse> getMenusByModuleId(@PathVariable("moduleId") Integer moduleId) {
		List<MenuMaster> menulist = this.menuService.getMenusByModuleId(moduleId);
		if (menulist.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					null);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				menulist);
	}

//	@DeleteMapping("/master/district/{districtId}")
//	public ResponseEntity<RequestResponse> deleteDistrict(@PathVariable("districtId") Integer districtId) {
//		System.out.println("Delete Mapping Heated ===>>" + districtId);
//		this.districtService.deleteDistrict(districtId);
//		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess,
//				HttpStatus.NO_CONTENT, null);
//	}

	@DeleteMapping("/menu/{menuId}")
	public ResponseEntity<RequestResponse> deleteMenuMaster(@PathVariable("menuId") int menuId) {
		System.out.println("Delete Mapping Heated ===>>" + menuId);
		MenuMaster menuById = this.menuService.getMenuById(menuId);
		menuById.setStatus(true);
		this.menuService.updateMenuMaster(menuById, menuId);
		// this.pinCodeMasterService.deletePinCodeMaster(pinCodeId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess, HttpStatus.CREATED,
				null);

	}

	@PutMapping("/menu/{menuId}")
	public ResponseEntity<RequestResponse> updateMenu(@RequestBody MenuMaster menu,
			@PathVariable("menuId") Integer menuId) {

		System.out.println("Menu Master : " + menu);
		menu.setStatus(false);
		this.menuService.updateMenuMaster(menu, menuId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED,
				menu);
	}

	@PostMapping("/menuList")
	public ResponseEntity<RequestResponse> getMenuListByModuleId(@RequestBody Object moduleIdList)
			throws JSONException {

		Object mod = moduleIdList.toString().replace("[", "{ moduleIdList : [").replace("]", "]}");
		System.out.println(moduleIdList);

		JSONArray moduleIdListObject = new JSONArray(new Gson().toJson(moduleIdList));

//		JSONObject jsonObject = new JSONObject();

//		jsonObject.put("admmModuleId", moduleIdListObject);

//		System.out.println("Json list are"+ jsonObject);
//		JSONObject moduleJson = new JSONObject(jsonObject.get("admmModuleId"));
//		System.out.println("Json list are"+ moduleJson);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for (int i = 0; i < moduleIdListObject.length(); i++) {
			String stringadmmModuleId = moduleIdListObject.getString(i);
//			System.out.println("Array List are : "+stringadmmModuleId.replace("{\"admmModuleId\":", "").replace("}", ""));

			int admmModuleId = Integer.parseInt(stringadmmModuleId.replace("{\"admmModuleId\":", "").replace("}", ""));

//			av;""
			System.out.println("after Convert to Int : " + admmModuleId);
			arrayList.add(admmModuleId);

		}

		System.out.println("Array List are : " + arrayList);

//		arrayList.add(e)
		List<MenuMaster> findByModuleMasterAdmmModuleId = this.menuRepository
				.findByModuleMasterAdmmModuleIdStatusFalseIn(arrayList);

		if (findByModuleMasterAdmmModuleId == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					findByModuleMasterAdmmModuleId);
		}

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				findByModuleMasterAdmmModuleId);
	}

}
