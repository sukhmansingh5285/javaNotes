package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateTest {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("appsquadzjpa");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction t = manager.getTransaction();
        t.begin();

        System.out.println("Fetching record having 1");
        // Customer1 std = manager.find(Customer1.class, new Integer(3024)); // deprecated
        Customer1 std = manager.find(Customer1.class, 3024);

        System.out.println(std.getId());
        System.out.println(std.getFirstName());
        
        std.setFirstName("maya123");
        manager.persist(std);
        
        t.commit();
        manager.close();
        factory.close();
    }
}

// use set method and than persist -> commit to update.