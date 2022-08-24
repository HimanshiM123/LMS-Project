package com.bridgelabz.lmsproject.Repository;

import com.bridgelabz.lmsproject.model.BankModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBankRepository extends JpaRepository<BankModel, Long> {
}
