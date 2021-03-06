
package INSO2.peaje.controlador;

import INSO2.peaje.EJB.VehiculoFacadeLocal;
import INSO2.peaje.modelo.Usuario;
import INSO2.peaje.modelo.Vehiculo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    private List<Vehiculo> vehiculos;
        
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public void registrar() {
        
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage mensaje = null;
        Usuario usuario = (Usuario) fc.getExternalContext().getSessionMap().get("usuario");
        vehiculo.setUsuario(usuario);
        Date fechaHoy = new Date();
        vehiculo.setFechaRegistro(fechaHoy);
        
        try {
            EJBVehiculo.create(vehiculo);
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha registrado el vehiculo");
        }
        catch (Exception ex) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", 
                "No se ha registrado el vehiculo (Es posible que la matricula ya exista)");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminarVehiculo(Vehiculo ve) {
        FacesMessage mensaje = null;
        
        try {
            EJBVehiculo.remove(ve);
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "El vehículo se ha eliminado");
        }
        catch (Exception e) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", 
                "No se ha podido eliminar el vehículo");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    /* METODO UTILIZADO PARA LA PRUEBA DE CAJA NEGRA
    
    public boolean VehiculoPeaje(String matricula) {
        this.licensePl = matricula;
	boolean correcto = true;
		
	Pattern pattern = Pattern.compile("^[0-9]{4}[A-Z]{3}$");
        Matcher matcher = pattern.matcher(licensePl);
		
	while (!matcher.matches()) {
            correcto = false;
            break;
	}
	return correcto;
    }
    */
    
}
