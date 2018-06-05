package INSO2.peaje.controlador;

import INSO2.peaje.EJB.UsuarioFacadeLocal;
import INSO2.peaje.EJB.VehiculoFacadeLocal;
import INSO2.peaje.modelo.Usuario;
import INSO2.peaje.modelo.Vehiculo;
import java.io.Serializable; 
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class DataController implements Serializable {
    
    @EJB
    UsuarioFacadeLocal EJBUsuario;
    @EJB
    VehiculoFacadeLocal EJBVehiculo;
    
    private List<Usuario> usuarios;
    private List<Vehiculo> vehiculos;
    private Usuario usuario;
    private Vehiculo vehiculo;
    
    private final String confirmU = "¿Seguro que quieres modificar los datos del usuario? " + 
                            "Una vez confirmado no se podrá deshacer la operación";
    private final String confirmV = "¿Seguro que quieres modificar los datos del vehículo? " + 
                            "Una vez confirmado no se podrá deshacer la operación";
            
    @PostConstruct
    public void init() {
        usuarios = EJBUsuario.findAll();
        vehiculos = EJBVehiculo.findAll();
    }
    
    public void getUsuarioSelect(Usuario us) {
        usuario = us;
    }
    
    public void getVehiculoSelect(Vehiculo ve) {
        vehiculo = ve;
    }
    
    public void modificarUsuario() {
        
        FacesMessage mensaje = null;
        
        try {
            EJBUsuario.edit(usuario);
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario modificado");
        }
        catch (Exception e) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", 
                "No se ha podido modificar el usuario (dni o nombre de usuario ya existan)");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void modificarVehiculo() {
        
        FacesMessage mensaje = null;
        
        try {
            EJBVehiculo.edit(vehiculo);
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Vehículo modificado");
        }
        catch (Exception e) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", 
                "No se ha podido modificar el vehículo (La matrícula ya existan)");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public String getConfirmU() {
        return confirmU;
    }

    public String getConfirmV() {
        return confirmV;
    }
    
}
