package HW2.domain;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDTO implements Serializable{

    private int id;
    private String full_name;
    private int age;
    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.full_name = employee.getName();
        this.age = employee.age;
    }
}
