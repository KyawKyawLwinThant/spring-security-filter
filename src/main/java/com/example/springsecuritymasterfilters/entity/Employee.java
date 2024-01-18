package com.example.springsecuritymasterfilters.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "FirstName cannot be empty!")
    @Pattern(regexp = "[A-Za-z-']*"
            ,message = "FirstName cannot contains illegal characters.")
    private String firstName;
    @NotBlank(message = "LastName cannot be empty!")
    @Pattern(regexp = "[A-Za-z-']*"
            ,message = "LastName cannot contains illegal characters.")
    private String lastName;
    @NotBlank(message = "PhoneNumber cannot be empty!")
    @Pattern(regexp = "[0-9\\-+]*"
            ,message = "PhoneNumber cannot contain illegal characters.")
    private String phoneNumber;
    @NotBlank(message = "Address cannot bbe empty!")
    @Pattern(regexp = "[\\w .\\-/,]*",
    message = "Address cannot contain illegal characters.")
    private String address;
    @NotBlank(message = "CubicleNo cannot be empty!")
    @Pattern(regexp = "[A-Za-z0-9\\-]*",
    message = "CubicleNo cannot contain illegal characters.")
    private String cubicleNo;













}
