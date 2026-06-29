package com.Soham.Module_11_Caching_Concurrent_Transactions.repositories;

import com.Soham.Module_11_Caching_Concurrent_Transactions.entities.SalaryAccount;
import jakarta.persistence.LockModeType;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Registered
public interface SalaryAccountRepository extends CrudRepository<SalaryAccount,Long> {

    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<SalaryAccount> findById(Long id);
}
