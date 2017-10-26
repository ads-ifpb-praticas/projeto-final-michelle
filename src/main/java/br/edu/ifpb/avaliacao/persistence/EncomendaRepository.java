
package br.edu.ifpb.avaliacao.persistence;

import br.edu.ifpb.avaliacao.domain.Encomenda;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 26/10/2017
 */

public class EncomendaRepository implements Repository<Encomenda> {

    @Inject
    private EntityManager manager;
    
    @Override
    public void add(Encomenda encomenda) {
        manager.getTransaction().begin();
        manager.persist(encomenda);
        manager.getTransaction().commit();
    }

    @Override
    public void edit(Encomenda encomenda) {
        manager.getTransaction().begin();
        manager.merge(encomenda);
        manager.getTransaction().commit();
    }

    @Override
    public void remove(Encomenda encomenda) {
        manager.getTransaction().begin();
        manager.remove(encomenda);
        manager.getTransaction().commit();
    }

    @Override
    public Encomenda get(Object id) {
        return manager.find(Encomenda.class, id);
    }

    @Override
    public List<Encomenda> get() {
        return manager.createQuery("FROM Encomenda e").getResultList();
    }

}
