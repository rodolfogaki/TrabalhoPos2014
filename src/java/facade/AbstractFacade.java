package facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Rodolfo
 */
public abstract class AbstractFacade<entidade> {
       
    private Class<entidade> entityClass;
    protected abstract EntityManager getEntityManager();

    public AbstractFacade(Class<entidade> entityClass) {
        this.entityClass = entityClass;
    }
    public void salvar(entidade e){
        getEntityManager().merge(e);     
    }
    public void remover(entidade e){
        getEntityManager().remove(getEntityManager().merge(e));
    }
    public List<entidade> listaTodos(){
        return getEntityManager().createQuery("from " +entityClass.getSimpleName()).getResultList();
    }
    public entidade recupera(Object id){
        return getEntityManager().find(entityClass, id);
    }
    public List<entidade> listaFiltrando (String f,String ... atributos){
        String hql = "from "+entityClass.getSimpleName()+ " obj where ";
        for(String atributo : atributos){
            hql += "lower(obj."+atributo+") like :filtro OR ";
        }
        hql = hql.substring(0,hql.length() - 3);
        Query q = getEntityManager().createQuery(hql);
        q.setParameter("filtro", "%"+f.toLowerCase()+"%");
        return q.getResultList();
    }
    
}
