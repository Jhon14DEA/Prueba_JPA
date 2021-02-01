/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.excepciones.CedulaExcepcion;
import ec.edu.ups.excepciones.VacioExcepcion;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ec.edu.ups.modelo.Casa;


/**
 *
 * @author ASUS
 */
public class CasaDAO extends AbstractControlador<Casa> {
    
    public CasaDAO(EntityManager em) {
        super(Casa.class, em);
    }
    
    public boolean crear(String direccion, double avaluo, boolean estado) throws VacioExcepcion {
        Casa persona = new Casa(direccion, avaluo, estado);
        validarCampos(persona);
        return super.crear(persona);
    }
    
    public Casa buscar(int id) {
        return (Casa) super.buscar(id);
    }
    
    public boolean actualizar(int codigo, String direccion, double avaluo, boolean estado) throws VacioExcepcion {
        Casa casa = buscar(codigo);
        if (casa != null) {
            casa.setDireccion(direccion);
            casa.setAvaluo(avaluo);
            casa.setEstado(estado);
            validarCampos(casa);
            
            return super.actualizar(casa);
        }
        return false;
    }

    public void actualizarEstado(boolean estado, int codigo) {
        Casa casa = buscar(codigo);
        casa.setEstado(estado);
        boolean actualizar = super.actualizar(casa);
        
    }
    
    public static void validarCampos(Casa casa) throws VacioExcepcion {
        if (String.valueOf(casa.getAvaluo()).equals("") || casa.getDireccion().equals("")) {
            throw new VacioExcepcion();
        }
        
    }
    
    @Override
    public List<Casa> findAll() {
        return getEm().createNamedQuery("Casa.findAll").getResultList();
    }
    
}
