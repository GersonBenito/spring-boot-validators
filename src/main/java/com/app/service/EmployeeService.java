package com.app.service;

import com.app.controller.dto.EmployeeDTO;
import com.app.entity.Department;
import com.app.entity.Employee;
import com.app.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //public EmployeeService(EmployeeRepository employeeRepository){
    //    this.employeeRepository = employeeRepository;
    //}

    public Employee saveEmployee(EmployeeDTO employeeDTO){
        Employee employee = Employee.builder()
                .name(employeeDTO.getName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .phone(employeeDTO.getPhone())
                .age(employeeDTO.getAge())
                .height(employeeDTO.getHeight())
                .married(employeeDTO.isMarried())
                .dateOfBirth(employeeDTO.getDateOfBirth())
                .department(Department.builder()
                        .name(employeeDTO.getDepartmentDTO().getName())
                        .city(employeeDTO.getDepartmentDTO().getCity())
                        .build()
                )
                .build();
        return this.employeeRepository.save(employee);
    }
}
