package mypack;

import java.util.List;
import java.util.Iterator;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LowerFunctionExample
{
  public static void main(String[] args)
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("appsquadzjpa");
    EntityManager em = emf.createEntityManager();

    try{
      EntityTransaction entr = em.getTransaction();
      entr.begin();

      Query query = em.createQuery ("SELECT emp FROM Employee emp");
      List list = query.getResultList();
      Iterator iterator = list.iterator();
      // List<Employee> list = query.getResultList(); // these 2 are the bettern/newer versions
      // Iterator<Employee> iterator = list.iterator();

      while(iterator.hasNext())
      {
        Employee emp = (Employee)iterator.next();
        System.out.print("Emp Name: " + emp.getEmpName());
        System.out.println();
      }

      //Query updateQuery = em.createQuery("UPDATE Employee emp SET emp.empName = LOWER(emp.empName)");
      Query updateQuery = em.createQuery("UPDATE Employee emp SET emp.empName=UPPER(emp.empName)");
      int updateData = updateQuery.executeUpdate();
      System.out.println(updateData + " record(s) are updated!");

      entr.commit();
    }
    finally{
      em.close();
    }
  }
}