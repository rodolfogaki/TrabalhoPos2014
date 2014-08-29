/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.Cidade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Rodolfo
 */
@Stateless
public class CidadeFacade extends AbstractFacade<Cidade> {
    
    @PersistenceContext(unitName="TrabalhoPos2014JaimePU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CidadeFacade() {
        super(Cidade.class);
    }
    
}
