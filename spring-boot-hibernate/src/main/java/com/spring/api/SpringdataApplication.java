package com.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class SpringdataApplication {
	@Autowired
	private EmployeeRepository repository;
	
	 @PostMapping("/saveEmployee")
	public Employee saveBook(@RequestBody Employee employee) {
        return repository.save(employee);
    }
	 @PutMapping("/update/{id}/{salary}")
	    public String updateEmployee(@PathVariable int id, @PathVariable int salary) {
	        Employee employee = repository.findById(id).get();
	        employee.setSalary(salary);
	        repository.save(employee);
	        return "employee updated";
	    }
	 @DeleteMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable int id) {
	        repository.deleteById(id);
	        return "employee deleted";
	    }
	 @GetMapping("/getInfo/{id}")
	    public void getInfo(@PathVariable  int id){
	        System.out.println(repository.findLastChangeRevision(id));
	    }
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringdataApplication.class, args);
	}

}
