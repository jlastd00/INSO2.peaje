 
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
        try {
            EJBUsuario.create(usuario);
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha registrado el usuario");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        catch (Exception ex) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al registrar el usuario");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }
    
}
