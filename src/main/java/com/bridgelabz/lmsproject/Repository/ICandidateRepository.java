package com.bridgelabz.lmsproject.Repository;

import com.bridgelabz.lmsproject.model.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICandidateRepository extends JpaRepository<CandidateModel, Long> {
    List<CandidateModel> findByStatus(String status);
}
