package pro.sky.homework4;

public interface EmployeeService {

    Employee addEmployee(String firstName, String secondName);
    Employee removeEmployee(String firstName, String secondName);
    Employee findEmployee(String firstName, String secondName);

}
