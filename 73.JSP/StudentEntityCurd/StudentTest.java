package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentTest 
{

public static void main(String[] args) 
{
EntityManagerFactory  factory = Persistence.createEntityManagerFactory("JPA");
//EntityManagerFactory  factory = Persistence.createEntityManagerFactory("DucatJPA1");
EntityManager manger=factory.createEntityManager();
EntityTransaction  t=manger.getTransaction();
t.begin();
Student std1=new Student(2022,"salman420","khan","salman420@gmail.com");
Student std2=new Student(420,"aamir420","khan","aamir420@gmail.com");
System.out.println("persisting entities....");		
manger.persist(std1);
manger.persist(std2);
t.commit();
manger.close();
factory.close();
System.out.println("Successfully persisted.");
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