package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentTest
{
  public static void main (String [] args)
  {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("appsquadzjpa");
    EntityManager manager = factory.createEntityManager();
    EntityTransaction t = manager.getTransaction();
    t.begin();

    Student std1 = new Student(54211, "neeta", "ambani", "neeta@gmail.com");
    Student std2 = new Student(7990, "esha", "ambani", "esha@gmail.com");
    System.out.println("persisting entities...");

    manager.persist(std1);
    manager.persist(std2);
    t.commit();
    manager.close();
    factory.close();
    System.out.println("Successfully persisted");
  }
}