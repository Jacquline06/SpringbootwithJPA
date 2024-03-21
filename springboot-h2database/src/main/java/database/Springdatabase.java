package database;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
@SpringBootApplication
@ComponentScan(basePackages= {"database","Webservice"})
public class Springdatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SpringApplication.run(Springdatabase.class, args);
	}

}
