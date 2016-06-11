package main.java.hello;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration; 



public class Person { 

	public	String name;
	public	String addr;
	public	String age;
	public	String mob;
	public	String dob;
	   
	private static SessionFactory factory;
	 
	public static SessionFactory abc(){
	try{
        factory = new Configuration().configure().buildSessionFactory();
        return factory;
     }catch (Throwable ex) { 
        System.err.println("Failed to create sessionFactory object." + ex);
        throw new ExceptionInInitializerError(ex); 
     }
	}	
		public Person(Person employee){  
		       this.name=employee.name;  
			   this.addr=employee.addr;
			   this.age=employee.age;  
			   this.mob=employee.mob; 
			   this.dob=employee.dob; 
			  }		
		
		public Person()
		{
			
		}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getDob() {
		return dob;
	}

	
    public void setDob(String dob) {
		this.dob = dob;
	}


	public int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	public Integer addEmployee(Person employee){
		
		factory=abc();
		
		Session session = factory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      try{
	         tx = session.beginTransaction();
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return employeeID;
	   }
	
	/* Method to  READ all the employees */
	   public List listEmployees( ){
	      
		   factory=abc();
		   
		   Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	        List empList = (ArrayList<Person>) session.createQuery("FROM Person").list(); 
	         
	         tx.commit();

	         session.close(); 
		      return empList;
		      
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
		      
	      }
	    
	      return null;
	   }
	
	   
	   public int updateEmployee(Person employees) {
	           
		   factory=abc();
		   
		   Session session = factory.openSession();
		      Transaction tx = null;
		      try{ 
		         tx = session.beginTransaction();
		         Person newemployee = 
		                    (Person)session.get(Person.class, employees.id);
		         
		         newemployee.setName(employees.name);
		         newemployee.setAddr(employees.addr);
		         newemployee.setAge(employees.age);
		         newemployee.setDob(employees.dob);
		         newemployee.setMob(employees.mob);
		         
				 session.update(newemployee); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		
		return 0;
	}
	
	   public List search(String searchName) {
            factory=abc();
		   
		   Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	        
	         Query query = session.createQuery("FROM Person where name= :username"); 

             query.setString("username",searchName); 
	       
 
	         List employees = (ArrayList<Person>)query.list();
	         
	         employees = (ArrayList<Person>)query.list();
	         
	         session.close(); 	          
	         
		      return  employees; 
		      
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
		      
	      }
	    
	      return null;
	
		
	}
}

