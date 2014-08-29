/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.Estado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rodolfo
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> {
 
    @PersistenceContext(unitName="TrabalhoPos2014JaimePU")
    private EntityManager em;

    
    public EstadoFacade() {
        super(Estado.class);
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
