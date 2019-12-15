package com.doitgeek.oc.usermanagementservice.service;

import com.doitgeek.oc.usermanagementservice.entity.UserAccount;
import com.doitgeek.oc.usermanagementservice.repository.UserAccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserAccountServiceImplTest {

    private UserAccountServiceImpl userAccountService;

    @Mock
    private UserAccountRepository userAccountRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.userAccountService = new UserAccountServiceImpl(userAccountRepository);
    }

    @Test
    public void testFindById() {
        Optional<UserAccount> optionalUserAccount = userAccountService.findById(10L);
        Assert.assertTrue(optionalUserAccount.isPresent());
    }

    @Test
    public void testFindAll() {
        List<UserAccount> userAccounts = userAccountService.findAll();
        Assert.assertEquals(10, userAccounts.size());
    }

    @Test
    public void testSave() {
        UserAccount userAccount = new UserAccount();
        userAccount.setFirstName("Sainath");
        userAccount.setLastName("Parkar");
        userAccount.setEmail("saiparkar4@gmail.com");
        userAccount.setPassword("sainath");
        userAccount.setMobileNumber("9869631289");
        userAccount.setIsPrivacyEnabled('Y');
        userAccount.setProfilePicturePath(null);
        userAccount.setCreateDate(new Date());

        Assert.assertEquals(userAccount, userAccountService.save(userAccount));
    }
}