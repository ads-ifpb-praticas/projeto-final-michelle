
package br.edu.ifpb.avaliacao.service;

import br.edu.ifpb.avaliacao.domain.Encomenda;
import br.edu.ifpb.avaliacao.persistence.Repository;
import br.edu.ifpb.avaliacao.qualifier.RepositorioEncomenda;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 26/10/2017
 */

public class EncomendaService implements Service<Encomenda> {

    @Inject
    @RepositorioEncomenda
    private Repository<Encomenda> repository;
    
    @Override
    public void cadastrar(Encomenda encomenda) {
        repository.add(encomenda);
    }

    @Override
    public void editar(Encomenda encomenda) {
        repository.edit(encomenda);
    }

    @Override
    public void remover(Encomenda encomenda) {
        repository.remove(encomenda);
    }

    @Override
    public List<Encomenda> listar() {
        return repository.get();
    }
    
    
    @Override
    public long diasRestantes(Encomenda encomenda) {
        return Duration.between(LocalDate.now(), encomenda.getEntrega())
                       .toDays();
    }
}
