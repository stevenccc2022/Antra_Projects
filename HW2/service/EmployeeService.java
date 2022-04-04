package HW2.service;

import HW2.domain.Employee;
import HW2.domain.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeaDTO getEmployeeId(int id);
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO saveEmployee(Employee employee);
    EmployeeDTO updateEmployee(int id, String name);
}
