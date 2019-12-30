package com.doitgeek.oc.usermanagementservice.repository;

import com.doitgeek.oc.usermanagementservice.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
