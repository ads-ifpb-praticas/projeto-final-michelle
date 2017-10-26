
package br.edu.ifpb.avaliacao.service;

import br.edu.ifpb.avaliacao.conversor.ConversorData;
import br.edu.ifpb.avaliacao.domain.Encomenda;
import br.edu.ifpb.avaliacao.persistence.Repository;
import br.edu.ifpb.avaliacao.qualifier.RepositorioEncomenda;
import br.edu.ifpb.avaliacao.qualifier.ServicoEncomenda;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 26/10/2017
 */

@ServicoEncomenda
public class EncomendaService implements Service {

    @Inject
    @RepositorioEncomenda
    private Repository<Encomenda> repository;
    
    @Inject
    private ConversorData conversor;
    
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
    public int diasRestantes(Encomenda encomenda) {
        LocalDate data = conversor.convert(encomenda.getEntrega());
        return Period.between(LocalDate.now(), data).getDays();
    }
    
    @Override
    public void entregar(Encomenda encomenda) {
        encomenda.setEntregue(true);
        repository.edit(encomenda);
    }

}
