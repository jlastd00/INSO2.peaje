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
public class LoginController implements Serializable {
    
    @EJB
    private UsuarioFacadeLocal EJBUsuario;
    private Usuario usuario;
    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion() {
        
        Usuario us;
        String redireccion = null;
        try {
            us = EJBUsuario.iniciarSesion(usuario);
            if (us != null) {
                redireccion = "/private/menuAdmin";
            }
            else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas!"));
            }
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Credenciales incorrectas!"));
        }
        
        return redireccion;
    }
    
}
