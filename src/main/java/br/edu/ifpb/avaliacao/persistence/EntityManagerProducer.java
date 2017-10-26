
package br.edu.ifpb.avaliacao.persistence;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 26/10/2017
 */

public class EntityManagerProducer {
    
    private static EntityManager manager;
    
    @Produces
    public static EntityManager getEntityManager() {
        manager = Persistence.createEntityManagerFactory("avaliacao-final")
                             .createEntityManager();
        return manager;
    }
    
}
