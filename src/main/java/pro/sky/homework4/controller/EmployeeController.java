package pro.sky.homework4.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.homework4.service.EmployeeService;
import pro.sky.homework4.data.Employee;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String greetEmployee() {
        return "Домашняя страница.";
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(value = "firstName") String firstName,
                                @RequestParam(value = "secondName") String secondName,
                                @RequestParam(value = "department") Integer department,
                                @RequestParam(value = "salary") Float salary) {
        Employee addedEmployee = employeeService.addEmployee(firstName, secondName, department, salary);
        return addedEmployee;

    }


    @RequestMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName") String firstName,
                                   @RequestParam(value = "secondName") String secondName) {
        Employee removedEmployee = employeeService.removeEmployee(firstName, secondName);
        return removedEmployee;
    }

    @RequestMapping(path = "/find")
    public Employee findEmployee(@RequestParam(value = "firstName") String firstName,
                                 @RequestParam(value = "secondName") String secondName) {
        Employee findedEmployee = employeeService.findEmployee(firstName, secondName);
        return findedEmployee;
    }

    @RequestMapping(path = "/getAll")
    public Collection<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
}
