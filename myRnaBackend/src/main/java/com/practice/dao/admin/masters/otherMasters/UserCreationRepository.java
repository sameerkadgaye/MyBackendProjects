package com.practice.dao.admin.masters.otherMasters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.otherMaster.User;

@Repository
public interface UserCreationRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);

	public User findBymPin(String mPin);

	public List<User> findByusernameAndStatusFalse(String username);

	public List<User> findByStatusFalse();


//	public save(User userFront);

	//public User findById(int userId);

}
