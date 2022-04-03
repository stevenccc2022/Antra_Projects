package HW2.service;

import HW2.domain.RegisterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegisterService {
    List<RegisterDTO> getAllRegister();
    RegisterDTO saveRegister(int pid, int eid);
}
