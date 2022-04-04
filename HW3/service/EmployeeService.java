package HW3.service;

import HW3.domain.Employee;
import HW2.domain.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    //EmployeeaDTO getEmployeeId(int id);
    //List<EmployeeDTO> getAllEmployees();
    List<EmployeeDTO> getGroupedEmployeeByAge();
    List<EmployeeDTO> getEmployeeByAge(int age);
/*    EmployeeDTO saveEmployee(Employee employee);
    EmployeeDTO updateEmployee(int id, String name);*/
}
