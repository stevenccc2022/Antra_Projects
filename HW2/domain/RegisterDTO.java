package HW2.domain;

import lombok.Data;

@Data
public class Register {

    private int id;
    private String employeeName;
    private String projectName;

    public Register(Register reg) {
        this.id = reg.getId();
        this.employeeName = reg.getEmployee().getName();
        this.projectName = reg.getProject().getName();
    }
}
