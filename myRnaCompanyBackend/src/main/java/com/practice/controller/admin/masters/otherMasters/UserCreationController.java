package com.practice.controller.admin.masters.otherMasters;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.component.FileUploadHelper;
import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.dao.admin.masters.otherMasters.UserBranchRepository;
import com.practice.dao.admin.masters.otherMasters.UserCompanyRepository;
import com.practice.model.admin.masters.otherMaster.User;
import com.practice.model.common.ApplicationException;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.BranchMasterService;
import com.practice.service.inf.admin.masters.otherMasters.CompanyMasterService;
import com.practice.service.inf.admin.masters.otherMasters.StateMasterService;
import com.practice.service.inf.admin.masters.otherMasters.UserService;

/**
 * @author Anurag Ninawe
 * @version 0.1
 * 
 *          Created Date : 12/11/2021
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/master")
public class UserCreationController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserCompanyRepository userCompanyRepository;

	@Autowired
	private UserBranchRepository userBranchRepository;

	@Autowired
	private StateMasterService stateMasterService;

	@Autowired
	private CompanyMasterService companyMasterService;

	@Autowired
	private BranchMasterService branchMasterService;

	@Autowired
	private CompanyMasterService companyMasterservice;

	@Autowired
	FileUploadHelper fileUploadHelper;

	@PostMapping("/user")
	public ResponseEntity<RequestResponse> saveUser(@RequestBody User userdetails)throws Exception {
		System.out.println("user Data Check----->>>  " + userdetails);

		try {
			this.userService.saveUser(userdetails);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED,userdetails);
			}
		
			catch (ApplicationException e) {
				return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(),HttpStatus.ALREADY_REPORTED, null);
				}
	}
	
	

	@PutMapping("/user/{userId}")
	public ResponseEntity<RequestResponse> updateuser(@RequestBody User user, @PathVariable("userId") Long userId) throws Exception {
		System.out.println("user imgPath Frontend  =====>>>>>        " + user.getImgPath());
		System.out.println("user imgImageName Frontend  =====>>>>>   " + user.getImgname());

		if (user.getImgPath() != null) {
			String upDatedPathName = user.getImgPath();
			String upDatedImageName = user.getImgname();
			System.out.println("user imgPath Frontend  =====>>>>>        " + upDatedPathName);
			System.out.println("user imgImageName Frontend  =====>>>>>   " + upDatedImageName);
			User userById = this.userService.getUserById(userId);

			if (userById.getImgPath() != null) {
				System.out.println("userById imgPath Backend  ==>>>>        " + userById.getImgPath());
				System.out.println("user Before ===========>>>> " + user.getImgPath());
				System.out.println("user Before ===========>>>> " + user.getImgname());
				if (!userById.getImgPath().equals(user.getImgPath())) {
					System.out.println("HOT AHE RE ==========>>>> " + userById.getImgPath());
					user.setImgPath(null);
					user.setImgname(null);
				}
				System.out.println("user Before ===========>>>> " + user.getImgPath());
				System.out.println("user Before ===========>>>> " + user.getImgname());
			} else if(userById.getImgPath() == null){
				user.setImgPath(null);
				user.setImgname(null);
			}
		
			
			try {
				User updateUserMain = this.userService.updateUserMain(user, userId);
				if (updateUserMain.getImgPath() == null) {
					updateUserMain.setImgPath(upDatedPathName);
					updateUserMain.setImgname(upDatedImageName);
					System.out.println("updateUserMain After ===========>>>> " + updateUserMain.getImgPath());
					System.out.println("updateUserMain Afters ===========>>>> " + updateUserMain.getImgname());
				}
				return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,HttpStatus.CREATED, updateUserMain);
				}
			
		        catch (ApplicationException e) {
					return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(),HttpStatus.ALREADY_REPORTED, null);
					}
		} 
		
		else {
			
			try {
				User updateUserMain = this.userService.updateUserMain(user, userId);
				return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,HttpStatus.CREATED, updateUserMain);
				}
			
				catch (ApplicationException e) {
					return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(),HttpStatus.ALREADY_REPORTED, null);
					}
			
		}
		
		
		
		
		
		
		
		
		

	}

	@PostMapping("/uploadFile/{userId}")
	public ResponseEntity<String> uploadFile(@PathVariable("userId") long userId,
			@RequestParam("file") MultipartFile file) {
		System.out.println("File upload Controller ===========================>>>>> ");
		System.out.println("userId In uploadFile ==============>>>>>      " + userId);
		System.out.println("File Name ==============>>>>>      " + file.getOriginalFilename());
		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Select File First For Uplaod");
			}

			// File Upload Code
			boolean status = fileUploadHelper.uploadFile(file);

			if (status) {
				User user = this.userService.getUserById(userId);
				String imgPath = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/userImages/").path(file.getOriginalFilename()).toUriString();
				String imgName = file.getOriginalFilename();

				System.out.println("imgName  " + imgName);
				System.out.println("imgPath  " + imgPath);

				user.setImgPath(imgPath);
				user.setImgname(imgName);
				this.userService.saveUserAfterSave(user);
				System.out.println("Image Name Saved Successfully");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath()
						.path("/images/userImages/").path(file.getOriginalFilename()).toUriString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Something Went To Wrong !! Please Try Again Letter");
	}

	@GetMapping("/users")
	public ResponseEntity<RequestResponse> getUsers() {

		List<User> usersLists = this.userService.getUsers();

		if (usersLists.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, usersLists);
		}
	}

	@SuppressWarnings("unused")
	@GetMapping("/user/{userId}")
	public ResponseEntity<RequestResponse> getUser(@PathVariable("userId") Long userId) {
		System.out.println("user By id Called");

		User User = this.userService.getUserById(userId);
//		List<AdCompanyMst> companylist = User.getCompanylist();
//		companylist.forEach(cm->{
//			System.out.println("Company Name  ==>> "+cm.getAdcmName());
//		});
		System.out.println("user By id list ---->>>>>>>>" + User);
		if (User == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, User);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, User);
		}
	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<RequestResponse> deleteUser(@PathVariable("userId") Long userId) {
		System.out.println("Delete Mapping user Hited ===>>" + userId);

		User UserById = this.userService.getUserById(userId);
		UserById.setStatus(true);
		this.userService.updateuser(UserById, userId);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess, HttpStatus.CREATED,
				UserById);

	}

	@GetMapping("/user/username/{username}")
	public ResponseEntity<RequestResponse> getUserByUserName(@PathVariable("username") String username) {
		User userByUsername = this.userService.getUserByUsername(username);
		if (userByUsername == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					userByUsername);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				userByUsername);
	}

}
