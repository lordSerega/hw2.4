package pro.sky.homework4.service;

import pro.sky.homework4.data.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String secondName);
    Employee removeEmployee(String firstName, String secondName);
    Employee findEmployee(String firstName, String secondName);
    Collection<Employee> getAllEmployee();

}
