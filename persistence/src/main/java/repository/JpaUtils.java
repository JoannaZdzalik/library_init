package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
    private static EntityManager entityManager = null;


    public static EntityManager get() {
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
}
