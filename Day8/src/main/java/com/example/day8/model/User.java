package com.example.day8.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotEmpty(message = "NAME CAN'T BE EMPTY")
    @Size(min = 4 , message = "NAME MUST BE LONGER THAN 4")
    private String name;

    @NotEmpty(message = "USERNAME CAN'T BE EMPTY")
    @Size(min = 4 , message = "USERNAME MUST BE LONGER THAN 4")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "PASSWORD CAN'T BE EMPTY")
    private String password;

    @NotEmpty(message = "EMAIL CAN'T BE EMPTY")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" , message = "WRONG EMAIL FORMAT")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "ROLE CAN'T BE EMPTY")
    @Pattern(regexp = "(user|admin)" , message = "ROLE MUST BE 'user' OR 'admin'")
    private String role;

    @NotNull(message = "AGE CAN'T BE NULL")
    private Integer age;
}
