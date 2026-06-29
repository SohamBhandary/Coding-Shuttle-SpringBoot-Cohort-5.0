package com.Soham.Module_11_Caching_Concurrent_Transactions.services.impl;

import com.Soham.Module_11_Caching_Concurrent_Transactions.entities.Employee;
import com.Soham.Module_11_Caching_Concurrent_Transactions.entities.SalaryAccount;
import com.Soham.Module_11_Caching_Concurrent_Transactions.repositories.SalaryAccountRepository;
import com.Soham.Module_11_Caching_Concurrent_Transactions.services.SalaryAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SalaryAccountServiceImple implements SalaryAccountService {

    private final SalaryAccountRepository salaryAccountRepository;

    @Override
    public void createAccount(Employee employee) {

//        if(employee.getName().equals("Anuj")) throw new RuntimeException("Anuj is not allowed");

        SalaryAccount salaryAccount = SalaryAccount.builder()
                .employee(employee)
                .balance(BigDecimal.ZERO)
                .build();

        salaryAccountRepository.save(salaryAccount);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public SalaryAccount incrementBalance(Long accountId) {

        SalaryAccount salaryAccount = salaryAccountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        BigDecimal prevBalance = salaryAccount.getBalance();
        BigDecimal newBalance = prevBalance.add(BigDecimal.valueOf(1L));

        salaryAccount.setBalance(newBalance);

        return salaryAccountRepository.save(salaryAccount);
    }
}
