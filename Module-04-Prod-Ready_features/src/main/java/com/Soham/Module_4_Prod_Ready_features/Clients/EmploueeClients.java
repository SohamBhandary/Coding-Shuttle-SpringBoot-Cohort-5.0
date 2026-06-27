//package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.clients.impl;
//
//
//import lombok.RequiredArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestClient;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class EmployeeClientImpl {
//
//    private final RestClient restClient;
//
//    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);
//
//
//    public List<EmployeeDTO> getAllEmployees() {
//        log.trace("Trying to retrieve all employees in getAllEmployees");
//        try {
//            log.info("Attempting to call the restClient Method in getAllEmployees");
//            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()
//                    .uri("employees")
//                    .retrieve()
//                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
//                        log.error(new String(res.getBody().readAllBytes()));
//                        throw new ResourceNotFoundException("could not create the employee");
//                    })
//                    .body(new ParameterizedTypeReference<>() {
//                    });
//            log.debug("Successfully retrieved the employees in getAllEmployees");
//            log.trace("Retrieved employees list in getAllEmployees : {}, {}, {}", employeeDTOList.getData(), "Hello", 5);
//            return employeeDTOList.getData();
//        } catch (Exception e) {
//            log.error("Exception occurred in getAllEmployees", e);
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public EmployeeDTO getEmployeeById(Long employeeId) {
//        log.trace("Trying to get Employee By Id in getEmployeeById with id: {}", employeeId);
//        try {
//            ApiResponse<EmployeeDTO> employeeResponse = restClient.get()
//                    .uri("employees/{employeeId}", employeeId)
//                    .retrieve()
//                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
//                        log.error(new String(res.getBody().readAllBytes()));
//                        throw new ResourceNotFoundException("could not create the employee");
//                    })
//                    .body(new ParameterizedTypeReference<>() {
//                    });
//            return employeeResponse.getData();
//        } catch (Exception e) {
//            log.error("Exception occurred in getAllEmployees", e);
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
//        log.trace("Trying to create Employee with information {}", employeeDTO);
//        try {
//            ResponseEntity<ApiResponse<EmployeeDTO>> employeeDTOApiResponse = restClient.post()
//                    .uri("employees")
//                    .body(employeeDTO)
//                    .retrieve()
//                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
//                        log.debug("4xxClient error occurred during createNewEmployee");
//                        log.error(new String(res.getBody().readAllBytes()));
//                        throw new ResourceNotFoundException("could not create the employee");
//                    })
//                    .toEntity(new ParameterizedTypeReference<>() {
//                    });
//            log.trace("Successfully created a new employee : {}", employeeDTOApiResponse.getBody());
//            return employeeDTOApiResponse.getBody().getData();
//        }
//        catch (Exception e) {
//            log.error("Exception occurred in createNewEmployee", e);
//            throw new RuntimeException(e);
//        }
//    }
//
//}
