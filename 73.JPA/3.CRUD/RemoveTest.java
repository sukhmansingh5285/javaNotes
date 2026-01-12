package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RemoveTest {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("appsquadzjpa");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction t = manager.getTransaction();
        t.begin();

        System.out.println("Fetching record having 1");
        // Customer1 std = manager.find(Customer1.class, new Integer(3024)); // this method is deprecated.
        Customer1 std = manager.find(Customer1.class, 3024);
        
        System.out.println(std.getId());
        System.out.println(std.getFirstName());
        
        manager.remove(std);

        t.commit();
        manager.close();
        factory.close();

    }
}

// remove