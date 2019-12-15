package com.doitgeek.oc.usermanagementservice.repository;

import com.doitgeek.oc.usermanagementservice.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByEmailOrMobileNumber(String email, String mobileNumber);
    Optional<UserAccount> findByEmailAndIdNot(String email, Long id);
    Optional<UserAccount> findByMobileNumberAndIdNot(String mobileNumber, Long id);
}
