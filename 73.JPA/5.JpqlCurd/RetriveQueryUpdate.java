package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RetriveQueryUpdate {

    public static void main(String[] args) {

        // 1. Load the configuration from persistence.xml
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("appsquadzjpa");
        
        // 2. Create the EntityManager
        EntityManager manger = factory.createEntityManager();
        
        // 3. Begin the transaction
        EntityTransaction t = manger.getTransaction();
        t.begin();

        // 4. Create and execute the UPDATE query
        Query query = manger.createQuery("UPDATE Student e SET e.firstname = 'Hathi123' WHERE e.id=54211");
        query.executeUpdate();

        // 5. Commit and close resources
        t.commit();
        manger.close();
        factory.close();
    }
}