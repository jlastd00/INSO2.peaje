 
package INSO2.peaje.controlador;

import INSO2.peaje.EJB.UsuarioFacadeLocal;
import INSO2.peaje.modelo.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
    
    @EJB
    UsuarioFacadeLocal EJBUsuario;
    private Usuario usuario;
    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void registrar() {
        
        FacesMessage mensaje = null;
        
        try {
            EJBUsuario.create(usuario);
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha registrado el usuario");
        }
        catch (Exception e) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", 
                "No se ha registrado el usuario (Es posible que el dni o el nombre de usuario ya existan)");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
}
