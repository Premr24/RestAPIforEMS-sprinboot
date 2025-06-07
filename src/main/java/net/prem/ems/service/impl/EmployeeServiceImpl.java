package net.prem.ems.service.impl;

import lombok.AllArgsConstructor;
import net.prem.ems.dto.EmployeeDto;
import net.prem.ems.entity.Employee;
import net.prem.ems.exception.ResourceNotFoundException;
import net.prem.ems.mapper.EmployeeMapper;
import net.prem.ems.repository.EmployeeRepository;
import net.prem.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service            //To create spring bean for this class
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //Creating employee method
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);  //To convert employee entity to Employee JP entity
        Employee savedEmployee = employeeRepository.save(employee);     //To save employee JP entity to database

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);          //To return saved employee object back to the client
    }

    //Retrieving employee method
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id:" + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    //Retrieving all employee method
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    //Update employee method
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id:" + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    //Delete employee method
    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id:" + employeeId)
        );
        employeeRepository.deleteById(employeeId);
    }
}
