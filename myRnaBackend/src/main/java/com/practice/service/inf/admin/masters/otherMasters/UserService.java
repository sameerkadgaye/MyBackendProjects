package com.practice.service.inf.admin.masters.otherMasters;

import java.util.List;

import com.practice.model.admin.masters.otherMaster.User;
import com.practice.model.common.ApplicationException;

/**
 * @author Anurag Ninawe
 * @version 0.1
 * 
 *          Created Date : 12/11/2021
 *
 */


public interface UserService {
	
	public User saveUser(User userdetails)throws ApplicationException, Exception;

	public List<User> getUsers();

	public User getUserById(Long userId);
	
	public User getUserByUsername(String username);

	public void updateUser(User user, Long userId);
	public User updateUserMain(User user, Long userId)throws ApplicationException, Exception;

	public void updateuser(User userById, Long userId);

	public void saveUserAfterSave(User user);

//	public User saveUser(List<User> user);

//	public User uploadFile(MultipartFile userfile, User userFront, long userid);



	
}
