package com.doitgeek.oc.authserver.service;

import com.doitgeek.oc.authserver.constant.ErrorMessageConstant;
import com.doitgeek.oc.authserver.entity.UserAccount;
import com.doitgeek.oc.authserver.exception.UserAccountNotFoundException;
import com.doitgeek.oc.authserver.model.UserAccountDto;
import com.doitgeek.oc.authserver.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    @Override
    public Optional<UserAccount> findByUsername(String username) {
        return userAccountRepository.findByUsername(username);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<UserAccount> findByUsernameOrEmailOrMobileNumber(String username, String email, String mobileNumber) {
        return userAccountRepository.findByUsernameOrEmailOrMobileNumber(username, email, mobileNumber);
    }

    @Transactional
    @Override
    public UserAccount createUserAccount(UserAccountDto userAccountDto) {
        if (findByUsernameOrEmailOrMobileNumber(userAccountDto.getUsername(),
                                                userAccountDto.getEmail(),
                                                userAccountDto.getMobileNumber()).isPresent()) {
            throw new RuntimeException(ErrorMessageConstant.USER_ACCOUNT_EXIST);
        }

        UserAccount newUserAccount = userAccountDto.getUserAccount();

        return save(newUserAccount);
    }

    @Transactional
    @Override
    public UserAccount updateById(Long id, UserAccountDto userAccountDto) {
        Optional<UserAccount> optionalUserAccount = findById(id);

        if (optionalUserAccount.isPresent()) {
            UserAccount userAccountToUpdate = optionalUserAccount.get();

            // Check if given email id already in use by another user
            if (findByEmailAndIdNot(userAccountDto.getEmail(), id).isPresent()) {
                throw new RuntimeException(ErrorMessageConstant.DUPLICATE_EMAIL);
            }

            // Check if given mobile number already in use by another user
            if (findByMobileNumberAndIdNot(userAccountDto.getMobileNumber(), id).isPresent()) {
                throw new RuntimeException(ErrorMessageConstant.DUPLICATE_MOBILE_NUMBER);
            }

            userAccountToUpdate.setPassword(userAccountDto.getPassword());
            userAccountToUpdate.setEmail(userAccountDto.getEmail());
            userAccountToUpdate.setMobileNumber(userAccountDto.getMobileNumber());
            userAccountToUpdate.setEnabled(userAccountDto.isEnabled());
            userAccountToUpdate.setAccountNonExpired(userAccountDto.isAccountNonExpired());
            userAccountToUpdate.setCredentialsNonExpired(userAccountDto.isCredentialsNonExpired());
            userAccountToUpdate.setAccountNonLocked(userAccountDto.isAccountNonLocked());

            return save(userAccountToUpdate);
        }

        throw new UserAccountNotFoundException(String.format(ErrorMessageConstant.USER_ACCOUNT_DOES_NOT_EXIST, id));
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<UserAccount> findByEmailAndIdNot(String email, Long id) {
        return userAccountRepository.findByEmailAndIdNot(email, id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<UserAccount> findByMobileNumberAndIdNot(String mobileNumber, Long id) {
        return userAccountRepository.findByEmailAndIdNot(mobileNumber, id);
    }
}
