package database;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
@Autowired
EmployeeService employeeService;

@GetMapping("/employee") 
public ResponseEntity<List<Employee>> getEmployee() throws InterruptedException{ 
	List<Employee>list=employeeService.getEmp();
    return new ResponseEntity<List<Employee>>(list,HttpStatus.OK); 
}
@PutMapping("/employee/{empid}") 
public Optional<Employee> updateDepartment(@RequestBody Employee employee,@PathVariable("empid") Long empid) 
{ 
	Optional opt= employeeService.updateEmployee(employee, empid);
	
	return opt;
} 
@PostMapping("/addEmployee")
public Employee addEmployee(@RequestBody Employee employee) {
    return employeeService.saveEmployee(employee);
}
@GetMapping("/entities")
public List<Employee> getSortedEntities(@RequestParam(defaultValue = "empname") String sortBy) {
    return employeeService.findAllSorted(sortBy);
}
}
