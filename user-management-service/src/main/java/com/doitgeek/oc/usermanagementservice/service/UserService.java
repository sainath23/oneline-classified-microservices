package com.doitgeek.oc.usermanagementservice.service;

import com.doitgeek.oc.usermanagementservice.model.ApiResponseModel;
import com.doitgeek.oc.usermanagementservice.model.UserAccountModel;
import com.doitgeek.oc.usermanagementservice.model.UserRegistrationDto;

public interface UserService {
    UserAccountModel createNewUser(UserRegistrationDto userRegistrationDto);
    ApiResponseModel<UserAccountModel> getUserAccountById(Long id);
}
