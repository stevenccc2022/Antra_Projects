package HW2.service.Impl;

import HW2.domain.Employee;
import HW2.domain.EmployeeDTO;
import HW2.domain.Project;
import HW2.domain.ProjectDTO;
import HW2.exception.EmployeeNotFoundException;
import HW2.exception.ProjectNotFoundException;
import HW2.repository.ProjectRepo;
import HW2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.ServerNotActiveException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepo projectRepo;

    @Autowired
    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public ProjectDTO getProjectId(int id) {
        Project project = projectRepo.getProjectById(id);
        if(project == null) {
            throw new ProjectNotFoundException("Cannot find this id " + id);
        }
        return new ProjectDTO(project);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<ProjectDTO> projects = projectRepo.getAllProjects().
                stream().map(s -> new ProjectDTO(s)).
                collect(Collectors.toList());

        return projects;
    }

    @Override
    public ProjectDTO saveProject(Project project) {
        if(projectRepo.getProjectById(project.getId()) != null) {
            throw new ProjectNotFoundException("Project already exists");
        }
        projectRepo.saveEmployee(project);
        System.out.println("Project id: " + project.getId() + ",Name: " + project.getName());
        return new ProjectDTO(project);
    }

    @Override
    public ProjectDTO updateProject(int id, String name) {
        Project project = projectRepo.getProjectById(id);
        if(project == null){
            throw new ProjectNotFoundException("Cannot find this id " + id);
        }
        return new ProjectDTO(projectRepo.updateEmployee(id, name));
    }
}
