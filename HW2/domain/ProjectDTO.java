package HW2.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectDTO {

    private int id;
    private String full_name;
    private Date date;

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.full_name = project.getName();
        this.date = new Date();
    }
}
