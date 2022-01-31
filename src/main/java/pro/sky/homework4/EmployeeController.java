package pro.sky.homework4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(path = "/")
    public String greetEmployee() {
        return "Домашняя страница.";
    }

    @RequestMapping(path = "/add")
    public Employee addEmployee(@RequestParam(value = "firstName") String firstName,
                              @RequestParam(value = "secondName") String secondName) {
        Employee addedEmployee = employeeService.addEmployee(firstName, secondName);
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

}
