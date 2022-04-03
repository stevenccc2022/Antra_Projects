package HW2.service.Impl;

import HW2.domain.RegisterDTO;
import HW2.repository.RegisterRepo;
import HW2.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegisterImpl implements RegisterService {
    private RegisterRepo Register;

    @Autowired
    public RegisterImpl(RegisterRepo Register) {
        this.Register = Register;
    }

    @Override
    public List<RegisterDTO> getAllRegister() {
        return Register.getAllProject_Employee().
                stream().map(es -> new RegisterDTO(es)).
                collect(Collectors.toList());
    }

    @Override
    public RegisterDTO saveRegister(int pid, int eid) {
        return new RegisterDTO(Register.saveRegister(pid, eid));
    }


}
