package com.doitgeek.oc.authserver.repository;

import com.doitgeek.oc.authserver.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByUsername(String username);
    Optional<UserAccount> findByUsernameOrEmailOrMobileNumber(String username, String email, String mobileNumber);
    Optional<UserAccount> findByEmailAndIdNot(String email, Long id);
    Optional<UserAccount> findByMobileNumberAndIdNot(String mobileNumber, Long id);
}
