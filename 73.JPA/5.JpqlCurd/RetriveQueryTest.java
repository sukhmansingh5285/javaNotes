package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

public class RetriveQueryTest {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("appsquadzjpa");
		EntityManager manger = factory.createEntityManager();
		EntityTransaction t = manger.getTransaction();
		t.begin();

		//Query query = manger.createQuery("SELECT e FROM Student e");
		//Query query = manger.createQuery("SELECT e FROM Student e WHERE e.id=8990");
		//Query query = manger.createQuery("SELECT e FROM Student e WHERE e.email LIKE '%@%'");
		Query query = manger.createQuery("SELECT e FROM Student e WHERE e.id BETWEEN 1000 AND 10000");

		List<Student> list = (List<Student>) query.getResultList();
		Iterator i = list.iterator();
		while(i.hasNext()) {
			Student std = (Student) i.next();
			System.out.println(std.getId());
			System.out.println(std.getFirstname());
		}

		t.commit();
		manger.close();
		factory.close();
	}
}
