package com.doitgeek.oc.usermanagementservice.model;

import com.doitgeek.oc.usermanagementservice.constant.MessageConstant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegistrationDto {

    @NotBlank(message = MessageConstant.FIRST_NAME_REQUIRED)
    @Size(max = 50, message = MessageConstant.FIRST_NAME_VALID)
    private String firstName;

    @NotBlank(message = MessageConstant.LAST_NAME_REQUIRED)
    @Size(max = 50, message = MessageConstant.LAST_NAME_VALID)
    private String lastName;

    @NotBlank(message = MessageConstant.EMAIL_REQUIRED)
    @Email(message = MessageConstant.EMAIL_VALID)
    @Size(max = 255, message = MessageConstant.EMAIL_SIZE)
    private String email;

    @NotBlank(message = MessageConstant.USERNAME_REQUIRED)
    @Size(max = 50, message = MessageConstant.USERNAME_SIZE)
    private String username;

    @NotBlank(message = MessageConstant.PASSWORD_REQUIRED)
    @Size(min = 6, max = 20, message = MessageConstant.PASSWORD_VALID)
    private String password;

    @NotBlank(message = MessageConstant.MOBILE_NO_REQUIRED)
    @Pattern(regexp = "^\\d{8,20}$", message = MessageConstant.MOBILE_NO_VALID)
    private String mobileNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public UserAccountDto getUserAccountDto() {
        return new UserAccountDto(username, password, email, mobileNumber);
    }
}
