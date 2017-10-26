
package br.edu.ifpb.avaliacao.conversor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 26/10/2017
 */

public class ConversorData {

    public LocalDate convert(Date data) {
        return data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    public Date convert(LocalDate data) {
        return Date.from(data.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
    
}
