package com.doitgeek.oc.usermanagementservice.service;

import com.doitgeek.oc.usermanagementservice.entity.UserAccount;
import com.doitgeek.oc.usermanagementservice.model.UserBasicInfoModel;
import com.doitgeek.oc.usermanagementservice.model.UserRegistrationModel;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {
    Optional<UserAccount> findById(Long id);
    List<UserAccount> findAll();
    UserAccount save(UserAccount userAccount);
    void deleteById(Long id);
    UserAccount updateById(Long id, UserBasicInfoModel userBasicInfoModel);
    Optional<UserAccount> findByEmailOrMobileNumber(String email, String mobileNumber);
    UserAccount registerUserAccount(UserRegistrationModel userRegistrationModel);
    Optional<UserAccount> findByEmailAndNotId(String email, Long id);
    Optional<UserAccount> findByMobileNumberAndNotId(String mobileNumber, Long id);
}
