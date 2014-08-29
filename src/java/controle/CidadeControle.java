package controle;

import converter.EstadoConverter;
import entidade.Cidade;
import entidade.Estado;
import facade.CidadeFacade;
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
public class CidadeControle implements Serializable {
    
    private Cidade cidade;
    @EJB
    private CidadeFacade cidadeFacade;
    @EJB
    private EstadoFacade estadoFacade;
    private EstadoConverter estadoConverter;

    public EstadoConverter getEstadoConverter() {
        if(estadoConverter == null){
            estadoConverter = new EstadoConverter(estadoFacade);
        }
        return estadoConverter;
    }

    public void setFornecedorConverter(EstadoConverter estadoConverter) {
        this.estadoConverter = estadoConverter;
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    public void salvar(){
        cidadeFacade.salvar(cidade);
    }
    
    public List<Cidade> listaTodos(){
        return cidadeFacade.listaTodos();
    }
    
    public void novo(){
        cidade = new Cidade();
    }
    public void editar(ActionEvent e){
        cidade = (Cidade)e.getComponent().getAttributes().get("cidade");
      
    }
    public void excluir(ActionEvent e){
        cidade = (Cidade)e.getComponent().getAttributes().get("cidade");
        cidadeFacade.remover(cidade);
      
    }
    
    public List<Estado> listaEstado(String filtro){
        return estadoFacade.listaFiltrando(filtro, "nome", "uf");
    }
}