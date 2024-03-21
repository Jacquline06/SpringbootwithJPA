package Webservice;



import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import database.Employee;

//@Service
public class EmployeeView {
    public static void main(String[]args) {
    	EmployeeView employeeView = new EmployeeView();

        // Create an instance of Employee with required details
        Employee employee = new Employee();
        employee.setEmpid(1006L);
        employee.setEmpname("Arasi");
        employee.setEmpdep("Teacher");
        
        ResponseEntity<Object> responseEntity = employeeView.addEmployee(employee);

        // You can handle the response entity as needed
        System.out.println("Response Status: " + responseEntity.getStatusCode());
        

        // Call the addEmployee method
       
    }

	private ResponseEntity<Object> addEmployee(Employee employee) {
		String uri = "http://localhost:8081/addEmployee";
		RestTemplate restTemplate=new RestTemplate();
		HttpEntity<Employee> requestEntity = new HttpEntity<>(employee, null);
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(uri, requestEntity, Object.class);
        return responseEntity;
	}
}
	
