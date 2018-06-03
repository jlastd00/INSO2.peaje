package INSO2.peaje.controlador;

import INSO2.peaje.EJB.UsuarioFacadeLocal;
import INSO2.peaje.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
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
                // Almacenar en la sesion de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                if (us.getRol().equals("A")) {
                    redireccion = "/private/menuAdmin?faces-redirect=true";
                }
                if (us.getRol().equals("E")) {
                    redireccion = "/private/menuEmpleado?faces-redirect=true";
                }
                if (us.getRol().equals("S")) {
                    redireccion = "/private/menuSupervisor?faces-redirect=true";
                }
            }
            else {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso: ", "Usuario o Contraseña incorrectos!");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
        }
        catch (Exception e) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error: ", "No se ha podido iniciar sesion");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        
        return redireccion;
    }
    
    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("./../index.xhtml");
        } 
        catch (IOException ex) {
            // Error
        }
    }
    
}
