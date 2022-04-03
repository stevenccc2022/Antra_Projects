package HW2.repository;

import HW2.domain.Employee;
import HW2.domain.Project;
import HW2.repository.repo_interface.Project_Inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProjectRepo {
    @Autowired
    private Project_Inter project_inter;

    private Map<String, Project> projectMap = new HashMap<>();


    public Project getProjectById(int id) {
        return project_inter.findEmployeeById(id);
    }

    public Collection<Project> getAllProjects() {
        return project_inter.findAll();
    }

    public Project saveEmployee(Project project) {

        return project_inter.saveAndFlush(project);
    }

    public Project updateEmployee(int id, String newName) {
        Project sup = project_inter.findEmployeeById(id);
        sup.setName(newName);

        return project_inter.saveAndFlush(sup);
    }



}
