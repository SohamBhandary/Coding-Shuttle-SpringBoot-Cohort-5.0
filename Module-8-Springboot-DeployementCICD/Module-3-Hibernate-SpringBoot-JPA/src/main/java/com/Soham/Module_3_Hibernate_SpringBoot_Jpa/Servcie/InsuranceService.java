package com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Servcie;

import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.Insurance;
import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.Patient;
import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories.InsuranceRepository;
import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private InsuranceRepository insuranceRepository;
    private PatientRepository patientRepository;

    @Transactional
    public void assginInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient= patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);
        insurance.setPatient(patient);


    }

    @Transactional
    public void remove( Long patientId){
        Patient patient= patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(null);



    }

    @Transactional
    public void deletePatient(Long patientId){
        Patient patient= patientRepository.findById(patientId).orElseThrow();
        patientRepository.deleteById(patientId);

    }

}
