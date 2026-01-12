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
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("appsquadzjpa");
    EntityManager manager = factory.createEntityManager();
    EntityTransaction t = manager.getTransaction();
    t.begin();

    Student101 std1 = new Student101(1345, "yaday");
    Student101 std2 = new Student101(111, "yadav");
    System.out.println("persisting entitites...");

    manager.persist(std1);
    manager.persist(std2);
    t.commit();
    manager.close();
    factory.close();
    System.out.println("Successfully persisted.");
  }
}