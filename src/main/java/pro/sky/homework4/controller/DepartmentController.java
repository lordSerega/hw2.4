package pro.sky.homework4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework4.data.Employee;
import pro.sky.homework4.service.DepartmentService;
import pro.sky.homework4.service.impl.DepartmentServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("departments")
public class DepartmentController{

    private final DepartmentService departmentService;

        public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartmentId(@RequestParam int departmentId) {
        return this.departmentService.findEmployeeWithMaxSalaryByDepartmentId(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryByDepartmentId(@RequestParam int departmentId) {
        return this.departmentService.findEmployeeWithMinSalaryByDepartmentId(departmentId);
    }

    @GetMapping(path ="/all", params = {"departmentId"})
    public Collection<Employee> findAllEmployeeByDepartmentId(@RequestParam int departmentId) {
        return this.departmentService.findAllEmployeeByDepartmentId(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findAllEmployeeByDepartmentId() {
        return this.departmentService.findAllEmployeeByDepartmentId();
    }

}
