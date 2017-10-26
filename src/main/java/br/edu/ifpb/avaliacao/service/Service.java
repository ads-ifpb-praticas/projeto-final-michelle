
package br.edu.ifpb.avaliacao.service;

import java.util.List;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 26/10/2017
 */

public interface Service<T> {
    
    void cadastrar(T t);
    void editar(T t);
    void remover(T t);
    List<T> listar();
    long diasRestantes(T t);
    
}
