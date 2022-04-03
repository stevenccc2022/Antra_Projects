package HW2.controller;

import HW2.domain.RegisterDTO;
import HW2.service.RegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegisterController {
    private final RegisterService regService;

    @Autowired
    public RegisterController(RegisterService regService) {
        this.regService = regService;
    }

    @GetMapping("/register")
    public ResponseEntity<List<RegisterDTO>> getRegister() {
        return new ResponseEntity<>(regService.getAllRegister(), HttpStatus.OK);
    }

    @PostMapping("/register/{eid}/{pid}")
    public ResponseEntity<RegisterDTO> saveRegister(@PathVariable int pid, @PathVariable int eid) {
        return new ResponseEntity<>(regService.saveRegister(pid, eid), HttpStatus.CREATED);
    }

}
