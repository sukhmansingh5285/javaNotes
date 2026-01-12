package mypack;

import java.util.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.*;

public class NativeQuery1
{
  public static void main(String[] args)
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("appsquadzjpa");
    EntityManager em = emf.createEntityManager();

    try{
      EntityTransaction entr = em.getTransaction();
      entr.begin();
      Query query = em.createNativeQuery("SELECT empSalary FROM Employeenative order by empSalary desc");
      List list = query.getResultList();
      Iterator<BigDecimal> itr = list.iterator();

      while(itr.hasNext())
      {
        BigDecimal str = itr.next();
        System.out.print("Emp salary: "+str);
        System.out.println();
      }
      entr.commit();
    }
    finally{
      em.close();
    }
  }
}