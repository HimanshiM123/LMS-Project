package com.bridgelabz.lmsproject.Repository;

import com.bridgelabz.lmsproject.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAdminRepository extends JpaRepository<AdminModel, Long> {
    Optional<AdminModel> findAdminByEmailId(String email);
}
