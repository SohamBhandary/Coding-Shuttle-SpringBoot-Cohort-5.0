package com.Soham.Module_2_SpringBoot_MVC.Services;

import com.Soham.Module_2_SpringBoot_MVC.DTOs.EmployeeDTO;
import com.Soham.Module_2_SpringBoot_MVC.Entities.EmployeeEntity;
import com.Soham.Module_2_SpringBoot_MVC.Repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public Optional<EmployeeDTO> getEmpById(Long id) {
//    Optional <EmployeeEntity> employeeEntity=  employeeRepository.findById(id).orElseThrow();
////        ModelMapper modelMapper= new ModelMapper();
//     return    modelMapper.map(employeeEntity->modelMapper.map(employeeEntity,EmployeeDTO.class));
        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class));
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

    public EmployeeDTO updateEmpById(EmployeeDTO employeeDTO, Long id) {
        EmployeeEntity employeeEntity= modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity employeeEntity1= employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntity1,EmployeeDTO.class);

    }

    public void deleteByid(Long id) {

        employeeRepository.deleteById(id);
    }

    public EmployeeDTO updatePartialEmployeeId(Map<String, Object> updates, Long id) {

        boolean exists = employeeRepository.existsById(id);

        if (!exists) return null;

        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow();

        updates.forEach((key, value) -> {

            Field field = ReflectionUtils.findField(EmployeeEntity.class, key);

            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, employeeEntity, value);
            }
        });

        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);

        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }
}
