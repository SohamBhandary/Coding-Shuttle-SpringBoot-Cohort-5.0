package com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Servcie;

import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.Appoinment;
import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.Doctor;
import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.Patient;
import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories.AppoinmentRepository;
import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories.DoctorRepository;
import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppoinmentRepository appoinmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;


    @Transactional
    public Appoinment createAppoint(Appoinment appoinment,Long pid,Long did)
    {
        Patient patient= patientRepository.findById(pid).orElseThrow();
        Doctor doctor= doctorRepository.findById(did).orElseThrow();
        appoinment.setPatient(patient);
        appoinment.setDoctor((Set<Doctor>) doctor);

        appoinmentRepository.save(appoinment);

        return appoinment;



    }

    }
