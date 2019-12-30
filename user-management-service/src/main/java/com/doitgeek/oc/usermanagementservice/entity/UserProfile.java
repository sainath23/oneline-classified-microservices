package com.doitgeek.oc.usermanagementservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable {

    private static final long serialVersionUID = -6652802419764198152L;

    @Id
    private Long userAccountId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_privacy_enabled")
    private boolean isPrivacyEnabled;

    @Column(name = "profile_picture_path")
    private String profilePicturePath;

    public UserProfile() {
    }

    public UserProfile(Long userAccountId, String firstName, String lastName, boolean isPrivacyEnabled, String profilePicturePath) {
        this.userAccountId = userAccountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isPrivacyEnabled = isPrivacyEnabled;
        this.profilePicturePath = profilePicturePath;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

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

    public boolean isPrivacyEnabled() {
        return isPrivacyEnabled;
    }

    public void setPrivacyEnabled(boolean privacyEnabled) {
        isPrivacyEnabled = privacyEnabled;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }
}
