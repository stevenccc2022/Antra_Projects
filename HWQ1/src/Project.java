package src;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    @OneToMany(mappedBy = "proj", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Register> register = new ArrayList<>();
    public List<Register> get_Register() {
        return register;
    }

    public void addRegister(Register rg){this.register.add(rg);}
    @Override
    public String toString() {
        return "Project' s{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project proj = (Project) o;
        return Objects.equals(id, proj.id);
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
