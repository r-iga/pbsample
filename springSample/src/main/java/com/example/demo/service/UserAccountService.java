package com.example.demo.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.auth.UserAccount;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class UserAccountService implements UserDetailsService {

	@Autowired
	private AccountRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username == null || "".equals(username)) {
			throw new UsernameNotFoundException("Username is empty");
		}

		Account ac = repository.findByUsername(username);
		if (ac == null) {
			throw new UsernameNotFoundException("User not found: " + username);
		}

		if (!ac.isEnabled()) {
			throw new UsernameNotFoundException("User not found: " + username);
		}

		UserAccount user = new UserAccount(ac, getAuthorities(ac));

		return user;
	}

	private Collection<GrantedAuthority> getAuthorities(Account account) {

		if (account.isAdmin()) {
			return AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
		} else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}

	}

	@Transactional
	public void registerAdmin(Integer id, String username, String password) {
		Account user = new Account(id, username, passwordEncoder.encode(password), true);
		repository.save(user);
	}

	@Transactional
	public void registerUser(Integer id, String username, String password) {
		Account user = new Account(id, username, passwordEncoder.encode(password), false);
		repository.save(user);
	}
}
