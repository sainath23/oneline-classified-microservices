package com.doitgeek.oc.usermanagementservice.service;

import com.doitgeek.oc.usermanagementservice.client.AuthServerFeignClient;
import com.doitgeek.oc.usermanagementservice.model.ApiResponseModel;
import com.doitgeek.oc.usermanagementservice.model.UserAccountModel;
import com.doitgeek.oc.usermanagementservice.model.UserRegistrationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private AuthServerFeignClient authServerFeignClient;

    @Autowired
    public UserServiceImpl(AuthServerFeignClient authServerFeignClient) {
        this.authServerFeignClient = authServerFeignClient;
    }

    @Override
    public UserAccountModel createNewUser(UserRegistrationDto userRegistrationDto) {
        ApiResponseModel<UserAccountModel> apiResponseModel = authServerFeignClient.createUserAccount(userRegistrationDto.getUserAccountDto());
        return apiResponseModel.getData();
    }

    @Override
    public ApiResponseModel<UserAccountModel> getUserAccountById(Long id) {
        ApiResponseModel apiResponseModel = authServerFeignClient.getUserAccountById(id);
        LOGGER.info("API RES == " + apiResponseModel.toString());
        return apiResponseModel;
    }
}
