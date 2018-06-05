package INSO2.peaje.controlador;

import INSO2.peaje.EJB.UsuarioFacadeLocal;
import INSO2.peaje.EJB.VehiculoFacadeLocal;
import INSO2.peaje.modelo.Usuario;
import INSO2.peaje.modelo.Vehiculo;
import java.io.Serializable; 
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class DataController implements Serializable {
    
    @EJB
    UsuarioFacadeLocal EJBUsuario;
    @EJB
    VehiculoFacadeLocal EJBVehiculos;
    
    private List<Usuario> usuarios;
    private List<Vehiculo> vehiculos;
    
    @PostConstruct
    public void init() {
        usuarios = EJBUsuario.findAll();
        vehiculos = EJBVehiculos.findAll();
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
    
    
    
}
