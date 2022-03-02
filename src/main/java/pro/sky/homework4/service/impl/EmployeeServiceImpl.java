package pro.sky.homework4.service.impl;


import org.springframework.stereotype.Service;
import pro.sky.homework4.data.Employee;
import pro.sky.homework4.exceptions.EmployeeExistsException;
import pro.sky.homework4.exceptions.EmployeeNotFoundException;
import pro.sky.homework4.service.EmployeeService;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Map<String, Employee> employeeBook = new HashMap<>();

    public boolean getEmployeeInSet(String key) {
        return employeeBook.containsKey(key);
    }

    @Override
    public Employee addEmployee(String firstName, String secondName, Integer department, Float salary) {
        Employee addedEmployee = new Employee(firstName, secondName, department, salary);
        String key = firstName + ' ' + secondName;

        if (!getEmployeeInSet(key)) {
            employeeBook.put(key, addedEmployee);
            return addedEmployee;
        } else {
            throw new EmployeeExistsException("Сотрдник уже есть в списке");
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String secondName) {
        Employee removedEmployee = new Employee(firstName, secondName);
        String key = firstName + ' ' + secondName;

        if (!getEmployeeInSet(key)) {
            employeeBook.remove(key);
            return removedEmployee;
        } else {
            throw new EmployeeNotFoundException("Сотрудника нет в списке");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String secondName) {
        Employee foundEmployee = new Employee(firstName, secondName);
        String key = firstName + ' ' + secondName;

        if (getEmployeeInSet(key)) {
            return foundEmployee;
        } else {
            throw new EmployeeNotFoundException("Сотрудника нет в списке");
        }

    }

    @Override
    public Collection<Employee> getAllEmployee() {

        if (!employeeBook.isEmpty()) {
            return Collections.unmodifiableCollection(employeeBook.values());
        } else {
            throw new EmployeeNotFoundException("Список пуст");
        }
    }
}
