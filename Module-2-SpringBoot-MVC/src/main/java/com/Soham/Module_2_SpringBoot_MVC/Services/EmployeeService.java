package com.Soham.Module_2_SpringBoot_MVC.Services;

import com.Soham.Module_2_SpringBoot_MVC.DTOs.EmployeeDTO;
import com.Soham.Module_2_SpringBoot_MVC.Entities.EmployeeEntity;
import com.Soham.Module_2_SpringBoot_MVC.Repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeDTO getEmpById(Long id) {
    EmployeeEntity employeeEntity=  employeeRepository.findById(id).orElseThrow();
//        ModelMapper modelMapper= new ModelMapper();
     return    modelMapper.map(employeeEntity,EmployeeDTO.class);
    }

    public List<EmployeeDTO> findAllEmployee() {
      List<EmployeeEntity> employeeEntities=  employeeRepository.findAll();
    return   employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class)).collect(Collectors.toUnmodifiableList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity toSave=modelMapper.map(employeeDTO,EmployeeEntity.class);
        EmployeeEntity employeeEntity= employeeRepository.save(toSave);
        return  modelMapper.map(employeeEntity,EmployeeDTO.class);
    }
}
