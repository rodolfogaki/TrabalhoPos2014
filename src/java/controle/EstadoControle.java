package controle;

import entidade.Estado;
import facade.EstadoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Rodolfo
 */
@ManagedBean
@SessionScoped
public class EstadoControle implements Serializable {
    
    private Estado estado;
    @EJB
    private EstadoFacade estadoFacade;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public void salvar(){
        estadoFacade.salvar(estado);
    }
    
    public List<Estado> listaTodos(){
        return estadoFacade.listaTodos();
    }
    
    public void novo(){
        estado = new Estado();
    }
    public void editar(ActionEvent e){
        estado = (Estado)e.getComponent().getAttributes().get("estado");
      
    }
    public void excluir(ActionEvent e){
        estado = (Estado)e.getComponent().getAttributes().get("estado");
        estadoFacade.remover(estado);
    }
    
}

