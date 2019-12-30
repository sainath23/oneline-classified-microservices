package com.doitgeek.oc.usermanagementservice.rest;

import com.doitgeek.oc.usermanagementservice.model.ApiResponseModel;
import com.doitgeek.oc.usermanagementservice.model.UserAccountModel;
import com.doitgeek.oc.usermanagementservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ApiResponseModel<UserAccountModel> getUserAccountById(@PathVariable("id") Long id) {
        System.out.println("Inside getUserAccountById");
        return userService.getUserAccountById(id);
    }


}
