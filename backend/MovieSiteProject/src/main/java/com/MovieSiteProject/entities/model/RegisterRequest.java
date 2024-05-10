package com.MovieSiteProject.entities.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank
    @Email(message = "Please enter a valid email address")
    private String email;

    @NotBlank
    @Size(min = 7 , message = "Password must contain at least 8 characters")

    private String password;
}
