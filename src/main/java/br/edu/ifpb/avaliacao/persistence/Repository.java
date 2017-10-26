
package br.edu.ifpb.avaliacao.persistence;

import java.util.List;

/**
 *
 * @author miolivc
 * @param <T>
 * @mail miolivc@outlook.com
 * @since 26/10/2017
 */

public interface Repository<T> {
    
    void add(T t);
    void edit(T t);
    void remove(T t);
    T get(Object key);
    List<T> get();
    
}
