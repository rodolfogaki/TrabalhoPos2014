/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import entidade.Estado;
import facade.EstadoFacade;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Rodolfo
 */
public class EstadoConverter implements Converter, Serializable{
    
    private EstadoFacade facade;

    public EstadoConverter(EstadoFacade facade) {
        this.facade = facade;
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return facade.recupera(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Estado)value).toString();
    }  
}
