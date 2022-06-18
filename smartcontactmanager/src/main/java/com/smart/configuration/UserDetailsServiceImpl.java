/**
 * 
 */
package com.smart.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.dao.UserRepository;
import com.smart.model.User;

/**
 * @author sameer
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	/**
	 * 
	 */
	public UserDetailsServiceImpl() {
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Fetching User From Database
		User user = this.userRepository.getUserByUserName(username);

		if (user == null) {
			System.out.println("User IS NULL IN UserDetailsServiceImpl ===========>>>>  " + user);
			throw new UsernameNotFoundException("Could Not Found User !!");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(user);

		return customUserDetails;
	}

}
