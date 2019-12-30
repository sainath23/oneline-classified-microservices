package com.doitgeek.oc.authserver.rest;

import com.doitgeek.oc.authserver.constant.AppConstant;
import com.doitgeek.oc.authserver.constant.ErrorMessageConstant;
import com.doitgeek.oc.authserver.entity.UserAccount;
import com.doitgeek.oc.authserver.exception.UserAccountNotFoundException;
import com.doitgeek.oc.authserver.model.ApiResponseModel;
import com.doitgeek.oc.authserver.model.UserAccountDto;
import com.doitgeek.oc.authserver.service.UserAccountService;
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

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class UserAccountRestController {

    private UserAccountService userAccountService;

    @Autowired
    public UserAccountRestController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/current")
    public Principal getUser(Principal principal) {
        System.out.println("Inside getUser");
        System.out.println("Principal = " + principal.getName());
        return principal;
    }

    @PostMapping
    public ResponseEntity<ApiResponseModel<UserAccount>> createUserAccount(@RequestBody UserAccountDto userAccountDto) {
        UserAccount userAccount = userAccountService.createUserAccount(userAccountDto);
        ApiResponseModel<UserAccount> apiResponseModel = new ApiResponseModel<>(AppConstant.SUCCESS, userAccount);
        return new ResponseEntity<>(apiResponseModel, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseModel<UserAccount>> getUserAccountById(@PathVariable("id") Long id) {
        UserAccount userAccount = userAccountService.findById(id)
                                                    .orElseThrow(() -> new UserAccountNotFoundException(String.format(ErrorMessageConstant.USER_ACCOUNT_DOES_NOT_EXIST, id)));
        ApiResponseModel<UserAccount> apiResponseModel = new ApiResponseModel<>(AppConstant.SUCCESS, userAccount);
        return new ResponseEntity<>(apiResponseModel, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponseModel<List<UserAccount>>> getAllUserAccounts() {
        ApiResponseModel<List<UserAccount>> apiResponseModel = new ApiResponseModel<>(AppConstant.SUCCESS, userAccountService.findAll());
        return new ResponseEntity<>(apiResponseModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseModel<String>> deleteUserAccountById(@PathVariable("id") Long id) {
        userAccountService.deleteById(id);
        return new ResponseEntity<>(new ApiResponseModel<>(AppConstant.SUCCESS, ""), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseModel<UserAccount>> updateUserAccountById(@PathVariable("id") Long id,
                                                                               @RequestBody UserAccountDto userAccountDto) {
        UserAccount userAccount = userAccountService.updateById(id, userAccountDto);
        ApiResponseModel<UserAccount> apiResponseModel = new ApiResponseModel<>(AppConstant.SUCCESS, userAccount);
        return new ResponseEntity<>(apiResponseModel, HttpStatus.OK);
    }
}
