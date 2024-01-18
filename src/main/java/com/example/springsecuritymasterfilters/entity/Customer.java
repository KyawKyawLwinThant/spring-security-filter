package com.example.springsecuritymasterfilters.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(min = 2,max = 5,
            message = "code must have length 2 - 5 characters.")
    @Pattern(regexp = "[A-Za-z]*",
            message = "Code contains illegal characters.")
    private String code;
    @NotBlank(message = "FirstName cannot be empty!")
    @Pattern(regexp = "[A-Za-z-']*"
            ,message = "FirstName cannot contains illegal characters.")
    private String firstName;
    @NotBlank(message = "LastName cannot be empty!")
    @Pattern(regexp = "[A-Za-z-']*"
            ,message = "LastName cannot contains illegal characters.")
    private String lastName;
    @NotBlank(message = "Address cannot bbe empty!")
    @Pattern(regexp = "[\\w .\\-/,]*",
            message = "Address cannot contain illegal characters.")
    private String address;
}
