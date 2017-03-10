package ovh.ddou.business.management.arc.producer;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProducer {

    private final static String PERSISTENT_UNIT = "ddou-bm";

    @Produces
    public EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory(PERSISTENT_UNIT);
    }

    public void close(@Disposes EntityManagerFactory entityManagerFactory) {
        entityManagerFactory.close();
    }

    @Produces
    public EntityManager createEntityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    public void close(@Disposes EntityManager entityManager) {
        entityManager.close();
    }

}
