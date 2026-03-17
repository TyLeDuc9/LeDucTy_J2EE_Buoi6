package org.example.service;
import java.util.Set;
import java.util.stream.Collectors;

import org.example.model.Account;
import org.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("🔥 LOGIN USERNAME: " + username);

        Account account = accountRepository.findByLoginName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Could not find user"));

        System.out.println("🔥 DB PASSWORD: " + account.getPassword());

        Set<SimpleGrantedAuthority> authorities = account.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                account.getLogin_name(),
                account.getPassword(),
                authorities
        );
    }
}