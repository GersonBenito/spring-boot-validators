package com.app.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotBlank // valida que no sea null y que no este en blanco
    private String name;
    @NotBlank
    @Size(min = 5, max = 10)
    private String lastName;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Un correo valido debe de incluir @ y .")
    private String email;
    private Long phone;
    @Min(18)
    @Max(30)
    private byte age;
    @Digits(integer = 1, fraction = 2, message = "Ingresa un numero entero y dos decimales")
    private double height;
    private boolean married;
    @Past(message = "Ingresa una fecha menor a la actual")
    private LocalDate dateOfBirth;
    @Valid
    private DepartmentDTO departmentDTO;
}
