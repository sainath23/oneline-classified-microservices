package com.doitgeek.oc.usermanagementservice.client;

import com.doitgeek.oc.usermanagementservice.model.ApiResponseModel;
import com.doitgeek.oc.usermanagementservice.model.UserAccountModel;
import com.doitgeek.oc.usermanagementservice.model.UserAccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("auth-server")
public interface AuthServerFeignClient {

    @PostMapping("/accounts")
    ApiResponseModel<UserAccountModel> createUserAccount(@RequestBody UserAccountDto userAccountDto);

    @GetMapping("/accounts/{id}")
    ApiResponseModel<UserAccountModel> getUserAccountById(@PathVariable("id") Long id);
}
