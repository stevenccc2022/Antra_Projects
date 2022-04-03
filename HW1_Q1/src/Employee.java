package src;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    @OneToMany(mappedBy = "emp", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Register> register = new ArrayList<>();
    public List<Register> get_Register() {
        return register;
    }

    public void addRegister(Register rg){this.register.add(rg);}
    @Override
    public String toString() {
        return "Employee' s{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee emp = (Employee) o;
        return Objects.equals(id, emp.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName(){return name;}

    public void setName(String name) {
        this.name = name;
    }
}
