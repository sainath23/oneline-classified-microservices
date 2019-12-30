package com.doitgeek.oc.authserver.service;

import com.doitgeek.oc.authserver.entity.CustomUserDetails;
import com.doitgeek.oc.authserver.entity.UserAccount;
import com.doitgeek.oc.authserver.repository.UserAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private UserAccountRepository userAccountRepository;

    @Autowired
    public CustomUserDetailsService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("USERNAME = {}", username);
        Optional<UserAccount> optionalUserAccount = userAccountRepository.findByUsername(username);
        UserDetails userDetails = optionalUserAccount
                                    .map(CustomUserDetails::new)
                                    .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found!"));
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
