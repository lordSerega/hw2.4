package pro.sky.homework4.service.impl;


import org.springframework.stereotype.Service;
import pro.sky.homework4.data.Employee;
import pro.sky.homework4.exceptions.EmployeeArrayFullException;
import pro.sky.homework4.exceptions.EmployeeExistsException;
import pro.sky.homework4.exceptions.EmployeeNotFoundException;
import pro.sky.homework4.service.EmployeeService;

import java.util.HashSet;
import java.util.Set;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Set<Employee> employeeBook = new HashSet<>();

    public boolean getEmployeeInSet(Employee employee) {
        return employeeBook.contains(employee);
    }

    @Override
    public Employee addEmployee(String firstName, String secondName) {
        Employee addedEmployee = new Employee(firstName, secondName);
        if (!getEmployeeInSet(addedEmployee)) {
            employeeBook.add(addedEmployee);
            return addedEmployee;
        } else {
            throw new EmployeeExistsException("Сотрдник уже есть в списке");
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String secondName) {
        Employee removedEmployee = new Employee(firstName, secondName);
        if (getEmployeeInSet(removedEmployee)) {
            employeeBook.remove(removedEmployee);
            return removedEmployee;
        } else {
            throw new EmployeeNotFoundException("Сотрудника нет в списке");
        }

    }

    @Override
    public Employee findEmployee(String firstName, String secondName) {
        Employee foundEmployee = new Employee(firstName, secondName);
        if (getEmployeeInSet(foundEmployee)) {
            return foundEmployee;
        } else {
            throw new EmployeeNotFoundException("Сотрудника нет в списке");
        }

    }

    @Override
    public Set<Employee> getAllEmployee() {
        if (!employeeBook.isEmpty()) {
            return employeeBook;
        } else {
            throw new EmployeeNotFoundException("Список пуст");
        }
    }
}
