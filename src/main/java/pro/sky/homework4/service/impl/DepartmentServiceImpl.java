package pro.sky.homework4.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.homework4.data.Employee;
import pro.sky.homework4.exceptions.EmployeeNotFoundException;
import pro.sky.homework4.service.DepartmentService;
import pro.sky.homework4.service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee findEmployeeWithMaxSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployee().stream().
                filter(d -> d.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    @Override
    public Employee findEmployeeWithMinSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployee().stream().
                filter(d -> d.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findAllEmployeeByDepartmentId(int departmentId) {
        return employeeService.getAllEmployee().stream().
                filter(d -> d.getDepartment() == departmentId).
                collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeeByDepartmentId() {
        Map<Integer, List<Employee>> result = new HashMap<>();
        employeeService.getAllEmployee().stream().
                    forEach(
                        e -> {
                            List<Employee> departmentEmployee = result.getOrDefault(e.getDepartment(), new ArrayList<Employee>());
                            departmentEmployee.add(e);
                            result.put(e.getDepartment(), departmentEmployee);
                        }
                );
        return result;

    }
}
