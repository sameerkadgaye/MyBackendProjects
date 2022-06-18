/*
 		This Class Is Responsible For Token Generation Only.
 */
package com.practice.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dao.admin.masters.otherMasters.UserCreationRepository;
import com.practice.model.admin.masters.otherMaster.User;
import com.practice.model.common.JwtRequest;
import com.practice.model.common.JwtResponse;
import com.practice.service.inf.common.CustomUserDetailsService;
import com.practice.util.JwtUtil;

@RestController
@CrossOrigin(origins = "*")
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@Autowired
	private UserCreationRepository userRepository;

	@Autowired
	private JwtUtil jwtUtil;

	@Value("${jwt.http.request.header}")
	private String tokenHeader;

	// @RequestMapping(value = "/token", method = RequestMethod.POST)
	@RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		System.out.println("Inside Controller");
		System.out.println("jwt request   ===>>>> " + jwtRequest);

		Integer getmPin = null;
		String username = null;
		String password = null;
		try {
			// M-PIN Logic Build Starts Here
			if (!jwtRequest.getmPin().isEmpty()) {
				System.out.println("Mpin is Not Empty ===>>> " + jwtRequest.getmPin());
				User findByMPin = userRepository.findBymPin(jwtRequest.getmPin());
				if (findByMPin != null) {
					System.out.println("findByMPin ====>>>> " + findByMPin.getMPin());
					System.out.println("findByMPin ====>>>> " + findByMPin.getUsername());
					System.out.println("findByMPin ====>>>> " + findByMPin.getPassword());
					getmPin = findByMPin.getMPin();
					username = findByMPin.getUsername();
					password = findByMPin.getPassword();
				}
				this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			} else {
				System.out.println("Mpin is Empty ===>>> " + jwtRequest.getmPin());
				username = jwtRequest.getUsername();
				this.authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			}
			// M-PIN Logic Build Ends Here

			// this.authenticationManager.authenticate(new
			// UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),
			// jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}

		// fine area..
		// UserDetails userDetails =
		// this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);

		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT " + token);

		// {"token":"value"}

		return ResponseEntity.ok(new JwtResponse(token));

	}

	// @RequestMapping(value = "/refresh/token", method = RequestMethod.GET)
	@RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.GET)
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
		System.out.println("refresh Token ========>>>>  ");
		String authToken = request.getHeader(tokenHeader);
		System.out.println("authToken  ===>>> " + authToken);
		final String token = authToken.substring(7);
		System.out.println("token  ===>>>> " + token);
		String username = jwtUtil.getUsernameFromToken(token);
		System.out.println("username  ===>>>> " + username);
		UserDetails user = jwtInMemoryUserDetailsService.loadUserByUsername(username);

		if (jwtUtil.canTokenBeRefreshed(token)) {
			String refreshedToken = jwtUtil.refreshToken(token);
			System.out.println("refreshedToken  ===>>> " + refreshedToken);
			return ResponseEntity.ok(new JwtResponse(refreshedToken));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping("/getTokenExpirationStatus")
	public Boolean getLoggedUser(@RequestBody JwtResponse token) {
		System.out.println("token ==>> "+token.getToken());
		String tokenValid = token.getToken();
		Boolean tokenExpired = true; // Return True If Token Is Expired Otherwise return false
		try {
			tokenExpired = this.jwtUtil.isTokenExpired(tokenValid);
			System.out.println("Token Is Not Expired ===>> " + tokenExpired);
		} catch (Exception e) {
			System.out.println("Token Is Expired ===>>> ");
		}
		return tokenExpired;
	}
}
