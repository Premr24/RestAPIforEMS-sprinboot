package net.prem.ems.mapper;

import net.prem.ems.dto.EmployeeDto;
import net.prem.ems.entity.Employee;

public class EmployeeMapper {

    //To map employee JP entity into employeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
    //To map employee dto to employee JP entity
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
