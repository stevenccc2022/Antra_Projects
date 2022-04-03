package HW2.repository.repo_interface;

import HW2.domain.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterRepo_Inter extends JpaRepository<Register, Integer> {

    List<Register> findAll();

    Register saveAndFlush(Register _projectEmployee);


}
