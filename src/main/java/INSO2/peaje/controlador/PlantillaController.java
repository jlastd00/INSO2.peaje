
package INSO2.peaje.controlador;

import INSO2.peaje.modelo.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author Juan Ramón Lastra Díaz
 */
@Named
@SessionScoped
public class PlantillaController implements Serializable {
    
    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            if (us == null) {
                context.getExternalContext().redirect("./../permisos.xhtml");
            }
        }
        catch (Exception e) {
            // Error
        }
    }
    
}
