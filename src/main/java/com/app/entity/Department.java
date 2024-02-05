package com.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    @OneToMany(targetEntity = Employee.class, fetch = FetchType.LAZY, mappedBy = "department")
    List<Employee> employeeList;
}
