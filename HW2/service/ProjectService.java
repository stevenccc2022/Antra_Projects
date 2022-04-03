package HW2.service;

import HW2.domain.Employee;
import HW2.domain.EmployeeDTO;
import HW2.domain.Project;
import HW2.domain.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    ProjectDTO getProjectId(int id);
    List<ProjectDTO> getAllProjects();
    //    List<Project_Employee> getProject_EmployeeId(int id);
    ProjectDTO saveProject(Project project);
    ProjectDTO updateProject(int id, String name);
}
