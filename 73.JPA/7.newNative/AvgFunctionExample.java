package mypack;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.Persistence;

public class AvgFunctionExample
{
  public static void main(String[] args)
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("appsquadzjpa");
    EntityManager em = emf.createEntityManager();
    
    try
    {
      EntityTransaction entr = em.getTransaction();
      entr.begin();
      Query query = em.createQuery("SELECT emp FROM Employee emp WHERE emp.empSalary > (SELECT AVG(emp1.empSalary) FROM Employee emp1)");

      List list = query.getResultList();
      Iterator iterator = list.iterator();
      while(iterator.hasNext())
      {
        Employee emp = (Employee)iterator.next();
        System.out.println("EmpName: " + emp.getEmpName());
        System.out.println("EmpSalary: " + emp.getEmpSalary());
      }
      entr.commit();
    }
    finally{
      em.close();
    }
  }
}