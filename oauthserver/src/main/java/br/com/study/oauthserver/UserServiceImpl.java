package br.com.study.oauthserver;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {
	


	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//		User user = userDao.findByUsername(userId);
//		if(user == null){
//			throw new UsernameNotFoundException("Invalid username or password.");
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
		return new org.springframework.security.core.userdetails.User("usuario","GnyKI.4/yT2SMKpErORN2ufMJG29.CpqVfe3xte1x947To5wZUAeC", getAuthority());
	}

	
	private Collection<? extends GrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List findAll() {
		List list = new ArrayList();
		//userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
}
