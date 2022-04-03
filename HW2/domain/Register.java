package HW2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="register")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eid")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    private Project project;

    public Register(Employee employee, Project project) {
        this.employee = employee;
        this.project = project;
    }

    @Override
    public String toString() {
        return "Employee_Project{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Register that = (Register) o;
        return id == (that.id) && employee.equals(that.employee) && project.equals(that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, project);
    }
}
