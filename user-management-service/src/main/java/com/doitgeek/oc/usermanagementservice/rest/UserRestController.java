package com.doitgeek.oc.usermanagementservice.rest;

import com.doitgeek.oc.usermanagementservice.constant.AppConstant;
import com.doitgeek.oc.usermanagementservice.constant.MessageConstant;
import com.doitgeek.oc.usermanagementservice.entity.UserAccount;
import com.doitgeek.oc.usermanagementservice.exception.UserNotFoundException;
import com.doitgeek.oc.usermanagementservice.model.ApiResponseModel;
import com.doitgeek.oc.usermanagementservice.model.UserBasicInfoModel;
import com.doitgeek.oc.usermanagementservice.model.UserRegistrationModel;
import com.doitgeek.oc.usermanagementservice.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private UserAccountService userAccountService;

    @Autowired
    public UserRestController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseModel<UserAccount>> createUserAccount(@Valid @RequestBody final UserRegistrationModel userRegistrationModel) {
        ApiResponseModel<UserAccount> apiResponseModel = new ApiResponseModel<>(AppConstant.SUCCESS,
                                                                                userAccountService.registerUserAccount(userRegistrationModel));
        return new ResponseEntity<>(apiResponseModel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseModel<UserAccount>> getUserAccountById(@PathVariable("id") final Long id) {
        UserAccount userAccount = userAccountService.findById(id).orElseThrow(() -> new UserNotFoundException(MessageConstant.USER_NOT_FOUND));
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, userAccount), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponseModel<List<UserAccount>>> getAllUserAccounts() {
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, userAccountService.findAll()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseModel<UserAccount>> updateUserAccount(@PathVariable("id") final Long id,
                                                                           @RequestBody final UserBasicInfoModel userBasicInfoModel) {
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, userAccountService.updateById(id, userBasicInfoModel)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUserAccount(@PathVariable("id") final Long id) {
        userAccountService.deleteById(id);
    }
}
