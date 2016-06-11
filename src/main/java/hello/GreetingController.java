package main.java.hello;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	public ArrayList<Person> details= new ArrayList<Person>();	
	
    @RequestMapping(value="/all", method =RequestMethod.GET)
    public ArrayList<Person> greeting1() {
    
    Person masti=new Person();	
    	
    details=(ArrayList<Person>) masti.listEmployees();	
    
	 System.out.println("here in GETTT"); 	

    	
   	return details;
    }
    
    @RequestMapping(value="/{name}", method =RequestMethod.GET)
    public ArrayList<Person> search(@PathVariable String name) {
    	
    	 ArrayList<Person> searchObj= new ArrayList<Person>(); 
    	 
    	 Person check=new Person();
    	 
    	 searchObj=(ArrayList<Person>) check.search(name);
    	 
          return searchObj;
    	
    }
    
    @RequestMapping(method =RequestMethod.POST)
    public void greeting(@RequestBody Person employees) {
    	    	
    	int id= employees.addEmployee(employees);
    	     	     	
    }
    
    @RequestMapping(method =RequestMethod.PUT)
    public void greeting2(@RequestBody Person employees) {    	
    	
    	int id= employees.updateEmployee(employees);     	 
    	
    }
    
}