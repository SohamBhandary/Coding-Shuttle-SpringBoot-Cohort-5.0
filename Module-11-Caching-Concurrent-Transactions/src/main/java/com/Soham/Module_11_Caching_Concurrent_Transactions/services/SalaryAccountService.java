package com.Soham.Module_11_Caching_Concurrent_Transactions.services;

import com.Soham.Module_11_Caching_Concurrent_Transactions.entities.Employee;
import com.Soham.Module_11_Caching_Concurrent_Transactions.entities.SalaryAccount;

public interface SalaryAccountService {
    void   createAccount(Employee employee);
    SalaryAccount incrementBalance(Long accountId);
}
