package com.bridgelabz.lmsproject.Repository;

import com.bridgelabz.lmsproject.model.TechStackModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechStackRepository extends JpaRepository<TechStackModel, Long> {
}
