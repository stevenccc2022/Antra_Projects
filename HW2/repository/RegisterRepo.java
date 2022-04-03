package HW2.repository;

import HW2.domain.Register;
import HW2.repository.repo_interface.RegisterInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class RegisterRepo {

    private EmployeeRepo employeeRepo;
    private ProjectRepo projectRepo;

    @Autowired
    private RegisterInter registerInter;

    @Autowired
    public RegisterRepo(ProjectRepo projectRepo, EmployeeRepo employeeRepo) {
        this.projectRepo = projectRepo;
        this.employeeRepo = employeeRepo;
    }

    public Register saveRegister(int eid, int pid) {
        Register Register = new Register(
                employeeRepo.getEmployeeById(eid),
                projectRepo.getProjectById(pid)
        );
        registerInter.saveAndFlush(Register);
        return Register;
    }

    public Collection<Register> getAllProject_Employee() {
        return registerInter.findAll();
    }
}
