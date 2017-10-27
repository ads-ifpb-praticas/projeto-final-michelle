
package br.edu.ifpb.avaliacao.validador;

import br.edu.ifpb.avaliacao.conversor.ConversorData;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 26/10/2017
 */

@FacesValidator("dataValidador")
public class ValidadorDataEncomenda implements Validator {
    
    @Inject
    private ConversorData conversor;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Date dataEncomenda = (Date) value;
        if (Period.between(LocalDate.now(), conversor.convert(dataEncomenda)).isNegative())
            throw new ValidatorException(new FacesMessage("Nao e permitido data retroativa"));
        
    }

}
