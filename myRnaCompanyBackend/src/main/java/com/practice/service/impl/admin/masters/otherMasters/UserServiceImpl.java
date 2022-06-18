package com.practice.service.impl.admin.masters.otherMasters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.constants.Constants;
import com.practice.dao.admin.masters.otherMasters.StateMasterRepository;
import com.practice.dao.admin.masters.otherMasters.UserCreationRepository;
import com.practice.model.admin.masters.otherMaster.User;
import com.practice.model.common.ApplicationException;
import com.practice.service.inf.admin.masters.otherMasters.UserService;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private StateMasterRepository stateMasterRepository;
		
	@Autowired 
	private UserCreationRepository userCreationRepository;
	
	
//	@Override
//	public User saveUser(User userCreation) {
//		//create Mapping and save user to db
//				//this.userCreationRepository.save(userCreation);
//				return this.userCreationRepository.save(userCreation);
//	}

//	@Override
//	public void saveUser(User userFront, MultipartFile file) {
//		// TODO Auto-generated method stub
//		
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		User user = new User(userFront,  file.getBytes());
//		long size = file.getSize();
//	
//		System.out.println("File path in service============="+size);
//		return userCreationRepository.save(user);
//		
//	}

//
//	@Override
//	public User saveUser(User userFront) {
//
//		return this.userCreationRepository.save(userFront);
//
//	}


	

	@Override
	public List<User> getUsers() {
		return this.userCreationRepository.findByStatusFalse();
	}


	@Override
	public User getUserById(Long userId) {
		User user = null;
		try {
			user = this.userCreationRepository.findById(userId).get();
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return user;
	}


	@Override
	public void updateUser(User user, Long userId) {
		user.setUserId(userId);
	    this.userCreationRepository.save(user);
	}

	@Override
	public void updateuser(User userById, Long userId) {
		
		userById.setUserId(userId);
		this.userCreationRepository.save(userById);
	}


	@Override
	public User getUserByUsername(String username) {
		return this.userCreationRepository.findByUsername(username);
	}


//	@Override
//	public User saveUser(List<User> user) {
//		return (User) this.userCreationRepository.saveAll(user);
//	}


	@Override
	public User saveUser(User userdetails) throws ApplicationException {
		
		if(userdetails.getUsername() != null && userdetails.getUsername() != "" && !userdetails.getUsername().isEmpty()) {
			
		System.out.println("Inside Username IS not Empty");	
		String  username = userdetails.getUsername();
		List<User> findByuserName = userCreationRepository.findByusernameAndStatusFalse(username);
	    System.out.println("findByuserName List--->>"+findByuserName);
		if (!findByuserName.isEmpty() && findByuserName !=null) {
			System.out.println("Inside UserNameAlreadyPresent");	
			throw new ApplicationException(Constants.ErrorCode, Constants.UserNameAlreadyPresent);
		}
		}
		
		System.out.println("Going For Save");
		
		return this.userCreationRepository.save(userdetails);
	}


	@Override
	public User updateUserMain(User user, Long userId) throws ApplicationException {
		
		
//		if(user.getUsername() != null && user.getUsername() != "" && !user.getUsername().isEmpty()) {
//			
//		System.out.println("Inside Username IS not Empty");	
//		String  username = user.getUsername();
//		List<User> findByuserName = userCreationRepository.findByusernameAndStatusFalse(username);
//	    System.out.println("findByuserName List In Update--->>"+findByuserName);
//		if (!findByuserName.isEmpty() && findByuserName !=null) {
//			System.out.println("Inside UserNameAlreadyPresent");	
//			throw new ApplicationException(Constants.ErrorCode, Constants.UserNameAlreadyPresent);
//		}
//		}
//		System.out.println("Going For Save");
		
		user.setUserId(userId);
		return this.userCreationRepository.save(user);
	}


	@Override
	public void saveUserAfterSave(User user) {

	 this.userCreationRepository.save(user);
		
	}



	
	
}
