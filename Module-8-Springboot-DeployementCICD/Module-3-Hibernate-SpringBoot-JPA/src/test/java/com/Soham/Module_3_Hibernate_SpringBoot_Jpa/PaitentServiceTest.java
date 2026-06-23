package com.Soham.Module_3_Hibernate_SpringBoot_Jpa;

import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PaitentServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public  void testPatient(){

        List<PatientInfo> patientList= patientRepository.getAllPatientInfo();
        patientList.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getEmail());
        });

    }


}
