package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RemoveTest {

	public static void main(String[] args) {
	
		EntityManagerFactory  factory = Persistence.createEntityManagerFactory("JPA");
		EntityManager manger=factory.createEntityManager();
		
		
		EntityTransaction t=manger.getTransaction();
		t.begin();
		
		
System.out.println("Fetching record having 420");
Student std=manger.find(Student.class,new Long(420));		
System.out.println(std.getId());
System.out.println(std.getFirstname());	
manger.remove(std);	

		t.commit();
		manger.close();
		factory.close();
		
		
	}	
		
}		
		
		/*System.out.println("Fetching record having id:3102");
		Student std=manger.find(Student.class, 3102);
		System.out.println("Changing state of entity....");
	
		std.setCourse("grails");
		std.setFee(13000);
		manger.persist(std);
		
		//manger.remove(std);
		
		
		
	}

}*/