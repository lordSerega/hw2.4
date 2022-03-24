package pro.sky.homework4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework4.exceptions.EmployeeNotFoundException;
import pro.sky.homework4.service.EmployeeService;
import pro.sky.homework4.service.impl.DepartmentServiceImpl;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.homework4.Data.*;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void findEmployeeWithMaxSalaryByDepartmentId() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE2, out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT));
    }

    @Test
    public void findEmployeeWithMaxSalaryByDepartmentIdWithNotFoundException() {
        when(employeeService.getAllEmployee()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT));
    }

    @Test
    public void findEmployeeWithMaxSalaryByDepartmentIdWithNotFoundExceptionWithBadDepartment() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT2));
    }

    @Test
    public void findEmployeeWithMinSalaryByDepartmentId() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE, out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT));
    }

    @Test
    public void findEmployeeWithMinSalaryByDepartmentIdWithNotFoundException() {
        when(employeeService.getAllEmployee()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT));
    }

    @Test
    public void findEmployeeWithMinSalaryByDepartmentIdWithNotFoundExceptionWithBadDepartment() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT2));
    }

    @Test
    public void findAllEmployeeByDepartmentId() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES2);
        assertEquals(DEPARTMENTS_MAP, out.findAllEmployeeByDepartmentId());
    }


}
