/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INSO2.peaje.EJB;

import INSO2.peaje.modelo.Vehiculo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juanra
 */
@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {
    @PersistenceContext(unitName = "bdpeajePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }
    
}
