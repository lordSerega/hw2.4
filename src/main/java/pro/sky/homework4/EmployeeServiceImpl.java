package pro.sky.homework4;


import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Employee[] employees = new Employee[3];
    int size;

    private int getEmployeeIndex(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employee.equals(employees[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Employee addEmployee(String firstName, String secondName) {

        if (employees.length == size) {
            throw new EmployeeArrayFullException("Список сотрудников полон!");
        }

        Employee employee = new Employee(firstName, secondName);
        int addIndex = getEmployeeIndex(employee);

        if (addIndex != -1) {
            throw new EmployeeExistsException("Такой сотрудник уже есть в базе");
        }
        employees[size++] = employee;
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        int removeIndex = getEmployeeIndex(employee);

        if (removeIndex == -1) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }

        Employee removedEmployee = employees[removeIndex];
        System.arraycopy(employees, removeIndex + 1, employees, removeIndex, size - removeIndex);
        size--;
        return removedEmployee;
    }

    @Override
    public Employee findEmployee(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        int findIndex = getEmployeeIndex(employee);

        if (findIndex == -1) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }

        Employee findedEmployee = employees[findIndex];
        return findedEmployee;
    }
}
