package HW2.service.Impl;


import HW2.domain.Employee;
import HW2.domain.EmployeeDTO;
import HW2.exception.EmployeeNotFoundException;
import HW2.repository.EmployeeRepo;
import HW2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Employee employee;

    /***
     *  Implementation without Repo
     */
    @Autowired
    public EmployeeServiceImpl(Employee employee) {
        this.employee = employee;
    }

    /***
     *  Grouped by id and retrieve emp by id Services With Retry annotation
     */
    @Override
    @Retryable(maxAttempts=5, value = RuntimeException.class,
            backoff = @Backoff(delay = 15000, multiplier = 2))

    @Retryable(maxAttempts=5, value = RuntimeException.class,
            backoff = @Backoff(delay = 15000, multiplier = 2))
    @Override
    public List<EmployeeDTO> getEmployeeByAge(int age) {
        Employee employee = employee.getEmployeeByAge(age);
        if(employee == null) {
            throw new EmployeeNotFoundException("Cannot find this age: " + age);
        }
        return new return employees.stream().map(s -> new EmployeeDTO(s)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getGroupedEmployeeByAge() {
        Collection<Employee> employees = employee.getGroupedEmployeeByAge();
        return employees.stream().map(s -> new EmployeeDTO(s)).collect(Collectors.toList());
    }


}
