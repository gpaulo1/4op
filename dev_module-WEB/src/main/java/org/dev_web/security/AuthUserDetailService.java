package org.dev_web.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dev_module.model.UserRole;
import org.dev_module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service("userDetailsService")
public class AuthUserDetailService  {

//	@Autowired implements UserDetailsService
//	private UserService userService;
//
//	public UserDetails loadUserByUsername(final String username)
//			throws UsernameNotFoundException {
//
//		org.dev_module.model.User user = userService.findByUserName(username);
//		List<GrantedAuthority> authorities = buildUserAuthority(user
//				.getUserRole());
//
//		return buildUserForAuthentication(user, authorities);
//
//	}
//
//	// Converts com.mkyong.users.model.User user to
//	// org.springframework.security.core.userdetails.User
//	private User buildUserForAuthentication(org.dev_module.model.User user,
//			List<GrantedAuthority> authorities) {
//		return new User(user.getUsername(), user.getPassword(),
//				user.isEnabled(), true, true, true, authorities);
//	}
//
//	private List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles) {
//		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//		// Build user's authorities
//		for (UserRole userRole : userRoles) {
//			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
//		}
//
//		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
//				setAuths);
//
//		return Result;
//	}

}
