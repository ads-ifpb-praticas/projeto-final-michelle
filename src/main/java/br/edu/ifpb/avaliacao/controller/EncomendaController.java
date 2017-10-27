
package br.edu.ifpb.avaliacao.controller;

import br.edu.ifpb.avaliacao.domain.Encomenda;
import br.edu.ifpb.avaliacao.qualifier.ServicoEncomenda;
import br.edu.ifpb.avaliacao.service.Service;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 26/10/2017
 */

@Named
@RequestScoped
public class EncomendaController {

    @Inject
    @ServicoEncomenda
    private Service service;
    @Inject
    private Encomenda encomenda;

    public String adicionarEncomenda() {
        service.cadastrar(encomenda);
        return "index?faces-redirect=true";
    }
    
    public List<Encomenda> cadastrados() {
        return service.listar();
    }
    
    public String removeEncomenda(Encomenda encomenda) {
        service.remover(encomenda);
        return "index?faces-redirect=true";
    }
    
    public String diasRestantes(Encomenda encomenda) {
        int dias = service.diasRestantes(encomenda);
        System.out.print("Number" + dias);
        if(dias > 5) {
            return "row-green";
        } else if (dias > 2) {
            return "row-yellow";
        }
        return "row-red";
    }
    
    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }
}
