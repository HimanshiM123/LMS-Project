package com.bridgelabz.lmsproject.Repository;

import com.bridgelabz.lmsproject.model.MentorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMentorRepository extends JpaRepository<MentorModel, Long> {
}
