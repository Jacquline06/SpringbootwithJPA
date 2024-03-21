package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository; 
	  private static final Logger logger =  LoggerFactory.getLogger(EmployeeService.class);
	  
    
    public List<Employee> getEmp() 
    { 
    	List<Employee>emp=employeeRepository.findAll();
    	//List<Employee>emp1=employeeRepository.findAll(Sort.by(Sort.Direction.ASC));
    	if(emp.size()>0) {
    		logger.info("count:"+employeeRepository.count());
    		//logger.info("Sorting:"+emp1);
    		return emp;
    	}
    	return new ArrayList<Employee>();
    }


    public Optional<Employee> updateEmployee(Employee updatedEmployee, Long empid) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(empid);
        
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            // Update the existing employee with the information from updatedEmployee
            existingEmployee.setEmpname(updatedEmployee.getEmpname());
            existingEmployee.setEmpdep(updatedEmployee.getEmpdep());
            // Update other fields as needed

            // Save the updated employee back to the repository
            employeeRepository.save(existingEmployee);

            return Optional.of(existingEmployee); // Return the updated employee
        } else {
            // Handle the case where the employee with the given ID is not found
            logger.info("Employee with ID " + empid + " not found.");
            return Optional.empty();
        }
    }

	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		//logger.info("count:"+employeeRepository.count());
		return employeeRepository.save(employee);
	}


	public List<Employee> findAllSorted(String sortBy) {
        Sort sort = Sort.by(sortBy).ascending(); // or Sort.by(sortBy).descending() for descending order
        return employeeRepository.findAll(sort);
    } 
	 
}
