
package INSO2.peaje.controlador;

import INSO2.peaje.modelo.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * @author Juan Ramon Lastra Diaz
 */
@Named
@SessionScoped
public class PlantillaController implements Serializable {
    
    private Usuario usLog;
    
    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            if (us == null) {
                context.getExternalContext().redirect("./../permisos.xhtml");
            }
            usLog = us;
        }
        catch (Exception e) {
            // Error
        }
        
    }

    public Usuario getUsLog() {
        return usLog;
    }
    
}
