package com.doitgeek.oc.usermanagementservice.service;

import com.doitgeek.oc.usermanagementservice.constant.AppConstant;
import com.doitgeek.oc.usermanagementservice.constant.MessageConstant;
import com.doitgeek.oc.usermanagementservice.entity.UserAccount;
import com.doitgeek.oc.usermanagementservice.exception.UserNotFoundException;
import com.doitgeek.oc.usermanagementservice.model.UserBasicInfoModel;
import com.doitgeek.oc.usermanagementservice.model.UserRegistrationModel;
import com.doitgeek.oc.usermanagementservice.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public Optional<UserAccount> findById(Long id) {
        return userAccountRepository.findById(id);
    }

    @Override
    public List<UserAccount> findAll() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public void deleteById(Long id) {
        userAccountRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserAccount updateById(Long id, UserBasicInfoModel userBasicInfoModel) {
        Optional<UserAccount> optionalUserAccount = findById(id);
        if(optionalUserAccount.isPresent()) {
            UserAccount userAccountToUpdate = optionalUserAccount.get();
            if(findByEmailAndNotId(userBasicInfoModel.getEmail(), id).isPresent()) {
                throw new RuntimeException(MessageConstant.DUPLICATE_EMAIL);
            }
            if(findByMobileNumberAndNotId(userBasicInfoModel.getMobileNumber(), id).isPresent()) {
                throw new RuntimeException(MessageConstant.DUPLICATE_MOBILE_NUMBER);
            }
            userAccountToUpdate.setFirstName(userBasicInfoModel.getFirstName());
            userAccountToUpdate.setLastName(userBasicInfoModel.getLastName());
            userAccountToUpdate.setEmail(userBasicInfoModel.getEmail());
            userAccountToUpdate.setMobileNumber(userBasicInfoModel.getMobileNumber());
            return save(userAccountToUpdate);
        }
        throw new UserNotFoundException(MessageConstant.USER_NOT_FOUND);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserAccount> findByEmailOrMobileNumber(String email, String mobileNumber) {
        return userAccountRepository.findByEmailOrMobileNumber(email, mobileNumber);
    }

    @Override
    @Transactional
    public UserAccount registerUserAccount(UserRegistrationModel userRegistrationModel) {
        if(findByEmailOrMobileNumber(userRegistrationModel.getEmail(), userRegistrationModel.getMobileNumber()).isPresent()) {
            throw new RuntimeException(MessageConstant.USER_EXIST);
        }

        UserAccount newUserAccount = userRegistrationModel.getUserAccount();
        newUserAccount.setIsPrivacyEnabled(AppConstant.YES);
        newUserAccount.setCreateDate(new Date());
        save(newUserAccount);

        return newUserAccount;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserAccount> findByEmailAndNotId(String email, Long id) {
        return userAccountRepository.findByEmailAndIdNot(email, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserAccount> findByMobileNumberAndNotId(String mobileNumber, Long id) {
        return userAccountRepository.findByMobileNumberAndIdNot(mobileNumber, id);
    }
}
