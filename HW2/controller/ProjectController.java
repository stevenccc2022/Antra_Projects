package HW2.controller;

import HW2.domain.Project;
import HW2.domain.ProjectDTO;
import HW2.exception.EmployeeNotFoundException;
import HW2.exception.ProjectNotFoundException;
import HW2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/project")
    public ResponseEntity<List<ProjectDTO>> getAllProject() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/project/{pid}")
    public ResponseEntity<ProjectDTO>getProjectById(@PathVariable int id) {
        return new ResponseEntity<>(projectService.getProjectId(id), HttpStatus.OK);
    }

    @PostMapping("/project/{name}")
    public ResponseEntity<ProjectDTO> saveProject(@PathVariable String name) {
        Project project = new Project();
        project.setName(name);
        return new ResponseEntity<>(projectService.saveProject(project), HttpStatus.CREATED);
    }

    @PutMapping("/project/{id}/{newName}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable int id, @PathVariable String newName) {
        return new ResponseEntity<>(projectService.updateProject(id, newName), HttpStatus.OK);
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<?> customizedExceptionHandler() {
        //get internal error
        return new ResponseEntity<>("Employee not found. You may get something wrong. ", HttpStatus.NOT_FOUND);
    }
}
