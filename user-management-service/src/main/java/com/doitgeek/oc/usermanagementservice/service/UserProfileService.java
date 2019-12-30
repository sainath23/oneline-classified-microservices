package com.doitgeek.oc.usermanagementservice.service;

import com.doitgeek.oc.usermanagementservice.entity.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserProfileService {
    Optional<UserProfile> findById(Long id);
    List<UserProfile> findAll();
    UserProfile save(UserProfile userProfile);
    void deleteById(Long id);
}
