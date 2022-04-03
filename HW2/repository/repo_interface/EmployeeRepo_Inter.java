package HW2.repository.repo_interface;

import HW2.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo_Inter extends JpaRepository<Employee, Integer> {

    List<Employee> findAll();

    Employee findEmployeeById(int id);

    List<RegisterInter> findEmployee_ProjectById(int id);

    Employee saveAndFlush(Employee employee);
}
