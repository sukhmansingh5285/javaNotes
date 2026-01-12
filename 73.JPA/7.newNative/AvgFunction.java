package mypack;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AvgFunction
{
  public static void main (String[] args)
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("appsquadzjpa");
    EntityManager em = emf.createEntityManager();
    
    try{
      EntityTransaction entr = em.getTransaction();
      entr.begin();
  
      Query query = em.createQuery("SELECT AVG(emp.empSalary) FROM Employee emp");
      Number cResults = (Number) query.getSingleResult();
      System.out.println("Total Cound result = "+cResults);
      entr.commit();
    } finally{
      em.close();
      //emf.close();
    }
  }
}