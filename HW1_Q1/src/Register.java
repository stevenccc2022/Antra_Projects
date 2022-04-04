package src;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "register")
public class Register {
    // private String id;

    public Register() {
    }

    public Register(Employee emp, Project proj) {
        this.emp = emp;
        this.proj = proj;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public void setProj(Project proj) {
        this.proj = proj;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eid")
    private Employee emp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_id")
    private Project proj;

    @Override
    public String toString() {
        return "Register{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Register that = (Register) o;
        return Objects.equals(id, that.id) && Objects.equals(emp, that.emp) && Objects.equals(proj, that.proj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emp, proj);
    }

    public Object getId() {
        return id;
    }
}
