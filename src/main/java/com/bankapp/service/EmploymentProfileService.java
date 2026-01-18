package com.bankapp.service;

import com.bankapp.model.EmploymentProfile;

import java.util.List;
import java.util.Optional;

public interface EmploymentProfileService {

    Long createEmploymentProfile(EmploymentProfile employmentProfile);

    Optional<EmploymentProfile> getEmploymentProfileById(Long id);
    Optional<EmploymentProfile> getEmploymentProfileByUserId(Long userId);
    List<EmploymentProfile> getAllEmploymentProfiles();

    boolean updateEmploymentProfile(EmploymentProfile employmentProfile);

    boolean deleteEmploymentProfile(Long employmentProfileId);

    boolean employmentProfileExists(Long employmentProfileId);
}
