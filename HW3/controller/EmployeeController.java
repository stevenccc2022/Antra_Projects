package HW3.controller;

import HW3.domain.Employee;
import HW3.domain.EmployeeDTO;
import HW3.exception.EmployeeNotFoundException;
import HW3.service.EmployeeService;
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

    /**
     * Create restTemplate
     */
    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "http://dummy.restapiexample.com/api/v1/employees";
    ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/age", String.class);
    Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    /**
     * Check Http Status code and response
     * */
    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(response.getBody());
    JsonNode name = root.path("name");
    Assertions.assertNotNull(name.asText());

    // get employees grouped by id
    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeDTO>> getGroupedEmployeeByAge(){
        return new ResponseEntity<>(employeeService.getGroupedEmployeeByAge(), HttpStatus.OK);
    }

    // get employees by age
    @GetMapping("/employee/{age}")
    public ResponseEntity<EmployeeDTO> getEmployeeByAge(@PathVariable int age) {
        return new ResponseEntity<>(employeeService.getEmployeeByAge(age), HttpStatus.OK);
    }


    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> customizedExceptionHandler() {
        //get internal error
        return new ResponseEntity<>("Employee can not be found", HttpStatus.NOT_FOUND);
    }


}
