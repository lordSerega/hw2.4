package pro.sky.homework4.service;

import pro.sky.homework4.data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee findEmployeeWithMaxSalaryByDepartmentId(int departmentId);
    Employee findEmployeeWithMinSalaryByDepartmentId(int departmentId);
    Collection<Employee> findAllEmployeeByDepartmentId(int departmentId);
    Map<Integer, List<Employee>> findAllEmployeeByDepartmentId();

}
