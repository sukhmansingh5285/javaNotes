package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CountFunction
{
  public static void main(String[] args)
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("appsquadz");
    EntityManager em = emf.createEntityManager();

    try{
      EntityTransaction entr = em.getTransaction();
      entr.begin();
      Query query = em.createQuery("SELECT COUNT(emp.empName) FROM Employee emp");
      Number cResults = (Number)query.getSingleResult();
      System.out.println("Total Count Result = " + cResults);
    }
    finally{
      em.close();
    }
  }
}