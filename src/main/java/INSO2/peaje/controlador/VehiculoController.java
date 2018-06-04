
package INSO2.peaje.controlador;

import INSO2.peaje.EJB.VehiculoFacadeLocal;
import INSO2.peaje.modelo.Usuario;
import INSO2.peaje.modelo.Vehiculo;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class VehiculoController implements Serializable {
    
    @EJB
    VehiculoFacadeLocal EJBVehiculo;    
    private Vehiculo vehiculo;
    
    @PostConstruct
    public void init() {
        vehiculo = new Vehiculo();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public void registrar() {
        
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            Usuario usuario = (Usuario) fc.getExternalContext().getSessionMap().get("usuario");
            vehiculo.setUsuario(usuario);
            EJBVehiculo.create(vehiculo);
            
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha registrado el vehiculo");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        catch (Exception ex) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al registrar el vehiculo");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }
    
}
