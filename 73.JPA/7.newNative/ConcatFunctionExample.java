
package mypack;


import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ConcatFunctionExample
{
  public static void main (String[] args)
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("appsquadz");
    EntityManager em = emf.createEntityManager();
    try{

      EntityTransaction entr = em.getTransaction();
      entr.begin();


      Query query = em.createQuery("SELECT emp FROM Employee emp");
      List list = query.getResultList();
      Iterator iterator = list.iterator();

      while(iterator.hasNext())
      {
        Employee emp = (Employee) iterator.next();
        System.out.print("Emp Name: "+emp.getEmpName());
        System.out.println();
      }

      query = em.createQuery("UPDATE Employee emp SET emp.empName=CONCAT(emp.empName, 'fog')");
      int updatedRecords = query.executeUpdate();
      System.out.println(updatedRecords+" records are affected");
      entr.commit();
    }
    finally{
      em.close();
    }
  }
}