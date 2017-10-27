
package br.edu.ifpb.avaliacao.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 26/10/2017
 */

@FacesValidator("textoValidador")
public class ValidadorTextoEncomenda implements Validator {
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String encomendaText = (String) value;
        if (encomendaText == null || encomendaText.isEmpty())
            throw new ValidatorException(new FacesMessage("Nao e permitido data retroativa"));
    }

}
