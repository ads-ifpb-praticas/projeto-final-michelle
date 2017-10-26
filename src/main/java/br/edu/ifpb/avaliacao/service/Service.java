
package br.edu.ifpb.avaliacao.service;

import br.edu.ifpb.avaliacao.domain.Encomenda;
import java.util.List;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 26/10/2017
 */

public interface Service {
    
    List<Encomenda> listar();
    void cadastrar(Encomenda encomenda);
    void editar(Encomenda encomenda);
    void remover(Encomenda encomenda);
    int diasRestantes(Encomenda encomenda);
    void entregar(Encomenda encomenda);
    
}
