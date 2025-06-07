package net.prem.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//To transfer data between Client and Server
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
