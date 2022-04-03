package HW2.controller;

import HW2.domain.Employee;
import HW2.domain.EmployeeDTO;
import HW2.exception.EmployeeNotFoundException;
import HW2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employee/{eid}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<>(employeeService.getEmployeeId(id), HttpStatus.OK);
    }

    @PostMapping("/employee/{name}")
    public ResponseEntity<EmployeeDTO> saveEmployee(@PathVariable String name) {
        Employee employee = new Employee();
        employee.setName(name);
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("employee/{id}/{newName}")
    public ResponseEntity<EmployeeDTO> updateProject(@PathVariable int id, @PathVariable String newName) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, newName), HttpStatus.OK);
    }


    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> customizedExceptionHandler() {
        //get internal error
        return new ResponseEntity<>("Employee can not be found", HttpStatus.NOT_FOUND);
    }


}
