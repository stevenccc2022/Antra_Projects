package HW2.service;

import HW2.domain.Employee;
import HW2.domain.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeDTO getEmployeeId(int id);
    List<EmployeeDTO> getAllEmployees();
//    List<Project_Employee> getProject_EmployeeId(int id);
    EmployeeDTO saveEmployee(Employee employee);
    EmployeeDTO updateEmployee(int id, String name);
}
