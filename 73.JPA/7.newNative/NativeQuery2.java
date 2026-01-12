package mypack;

import java.util.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.*;

public class NativeQuery2
{
  public static void main(String[] args)
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("appsquadzjpa");
    EntityManager em = emf.createEntityManager();
    try{
      EntityTransaction entr = em.getTransaction();
      entr.begin();
      Query query = em.createNativeQuery("SELECT * FROM Employeenative ", Employee.class);
      List list = query.getResultList();
      //System.out.println(list);
      Iterator itr = list.iterator();
      while(itr.hasNext())
      {
        Employee str = (Employee)itr.next();
        System.out.println("Emp salary: "+str.getEmpSalary());
        System.out.println(str);
        //System.out.println(str.getClass().getName());
      }
      entr.commit();
    }
    finally{
      em.close();
    }
  }
}