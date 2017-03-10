package ovh.ddou.business.management.arc.producer;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

class CdiConfig {

    @Produces
    @Dependent
    public EntityManager entityManager;

}
