package HW2.repository.repo_interface;

import HW2.domain.Employee;
import HW2.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepo_Inter extends JpaRepository<Project, Integer> {

    List<Project> findAll();

    Project findEmployeeById(int id);



    Project saveAndFlush(Project employee);
}
