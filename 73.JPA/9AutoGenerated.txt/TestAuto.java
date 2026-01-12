package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestAuto
{
    public static void main(String[] args)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("appsquadzjpa");

        EntityManager manger = factory.createEntityManager();
        EntityTransaction t = manger.getTransaction();
        t.begin();
        Person p1 = new Person("lalu24", "yadav24");

        Person p2 = new Person("rabar25", "yadav25");

        System.out.println("persisting entities...");
        manger.persist(p1);
        manger.persist(p2);
        t.commit();
        manger.close();
        factory.close();
        System.out.println("Successfully persisted.");
    }
}
