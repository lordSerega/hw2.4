package pro.sky.homework4.service.impl;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.homework4.data.Employee;
import pro.sky.homework4.exceptions.EmployeeExistsException;
import pro.sky.homework4.exceptions.EmployeeNotFoundException;
import pro.sky.homework4.service.EmployeeService;

import pro.sky.homework4.exceptions.InvalidNameException;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Map<String, Employee> employeeBook = new HashMap<>();

    public boolean getEmployeeInSet(String key) {
        return employeeBook.containsKey(key);
    }

    private void checkName(String... names) {
        Arrays.stream(names).forEach(
                name -> {
                    if (!StringUtils.isAlpha(name)) {
                        throw new InvalidNameException("Имя некорректно");
                    }
                });
    }

    private String capitalizeName(String name) {
        return StringUtils.capitalize(name.toLowerCase());
    }

    @Override
    public Employee addEmployee(String firstName, String secondName, Integer department, Float salary) {
        checkName(firstName,secondName);
        firstName = capitalizeName(firstName);
        secondName = capitalizeName(secondName);

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
        checkName(firstName,secondName);
        firstName = capitalizeName(firstName);
        secondName = capitalizeName(secondName);

        Employee removedEmployee = new Employee(firstName, secondName);
        String key = firstName + ' ' + secondName;

        if (getEmployeeInSet(key)) {
            employeeBook.remove(key);
            return removedEmployee;
        } else {
            throw new EmployeeNotFoundException("Сотрудника нет в списке");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String secondName) {
        checkName(firstName,secondName);
        firstName = capitalizeName(firstName);
        secondName = capitalizeName(secondName);

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
