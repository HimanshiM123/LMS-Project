package com.bridgelabz.lmsproject.Repository;

import com.bridgelabz.lmsproject.model.HiringCandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHiringCandidateRepository extends JpaRepository<HiringCandidateModel, Long> {
}
