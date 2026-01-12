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
    System.out.println("hello");

    Customer1 std1 = new Customer1(3024, "viresh3", "gupta3");
    Customer1 std2 = new Customer1(3025, "dinesh24", "chawala5");
    Customer1 std3 = new Customer1(4026, "viresh3", "gupta3");
    Customer1 std4 = new Customer1(4027, "dinesh24", "chawala55");
    System.out.println("persisting entities...");

    manager.persist(std1);
    manager.persist(std2);
    manager.persist(std3);
    manager.persist(std4);

    t.commit();
    manager.close();
    factory.close();
    System.out.println("Successfully persisted...");

  }
}

// new Object -> persist -> commit