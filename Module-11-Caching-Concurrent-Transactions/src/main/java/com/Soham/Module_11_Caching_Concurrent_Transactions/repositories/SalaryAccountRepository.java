package com.Soham.Module_11_Caching_Concurrent_Transactions.repositories;

import com.Soham.Module_11_Caching_Concurrent_Transactions.entities.SalaryAccount;
import jdk.jfr.Registered;
import org.springframework.data.repository.CrudRepository;

@Registered
public interface SalaryAccountRepository extends CrudRepository<SalaryAccount,Long> {
}
