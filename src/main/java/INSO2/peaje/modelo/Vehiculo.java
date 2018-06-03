/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INSO2.peaje.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author juanra
 */

@Entity
@Table(name="vehiculos")
public class Vehiculo implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idVehiculo;
    
    @Column(name="matricula")
    private String matricula;
    
    @Column(name="tipoVehiculo")
    private String tipoVehiculo;
    
    @Column(name="marca")
    private String marca;
    
    @Column(name="modelo")
    private String modelo;
    
    @Column(name="color")
    private String color;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaRegistro")
    private Date fechaRegistro;
    
    @ManyToOne
    @JoinColumn(name="idUsuario", nullable=false)
    private Usuario usuario;

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idVehiculo;
        hash = 67 * hash + Objects.hashCode(this.matricula);
        hash = 67 * hash + Objects.hashCode(this.tipoVehiculo);
        hash = 67 * hash + Objects.hashCode(this.marca);
        hash = 67 * hash + Objects.hashCode(this.modelo);
        hash = 67 * hash + Objects.hashCode(this.color);
        hash = 67 * hash + Objects.hashCode(this.fechaRegistro);
        hash = 67 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (this.idVehiculo != other.idVehiculo) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.tipoVehiculo, other.tipoVehiculo)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.fechaRegistro, other.fechaRegistro)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", matricula=" + matricula + ", tipoVehiculo=" + tipoVehiculo + 
                ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + 
                ", fechaRegistro=" + fechaRegistro + ", usuario=" + usuario + '}';
    }
    
    
}
