package com.doitgeek.oc.authserver.service;

import com.doitgeek.oc.authserver.entity.UserAccount;
import com.doitgeek.oc.authserver.model.UserAccountDto;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {
    Optional<UserAccount> findById(Long id);
    List<UserAccount> findAll();
    UserAccount save(UserAccount userAccount);
    void deleteById(Long id);
    Optional<UserAccount> findByUsername(String username);
    Optional<UserAccount> findByUsernameOrEmailOrMobileNumber(String username, String email, String mobileNumber);
    UserAccount createUserAccount(UserAccountDto userAccountDto);
    UserAccount updateById(Long id, UserAccountDto userAccountDto);
    Optional<UserAccount> findByEmailAndIdNot(String email, Long id);
    Optional<UserAccount> findByMobileNumberAndIdNot(String mobileNumber, Long id);
}
