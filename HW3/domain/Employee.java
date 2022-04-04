package HW2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(age = "age")
    private int age;
    /**
     * Due to without repo, I store the emp list here in employeeMap
     */
    private List<Employee> empList = new ArrayList<Employee>();
    /**
     * Two get functions: get all grouped by age, and get all employees based on age
     * */
    public Map<Integer, List> getGroupedEmployeeByAge(){
        Map<Integer, List> result
                = empList.stream().collect(
                Collectors.groupingBy(
                        empList::age);
        return result;
    }

    /**
     * get all employees by their age
     */
    public List<Employee> getEmployeeByAge(int age){
        List<Customer> res = empList
                .stream()
                .filter(e -> e.getAge == age)
                .collect(Collectors.toList());
        return res;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)


    public int getAge(){
        return this.age;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' + "age = "+ age + '\'
                '}' +;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == (employee.id) && name.equals(employee.name) && registers.equals(employee.registers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, registers);
    }

}
