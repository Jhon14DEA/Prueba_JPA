/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.excepciones.CedulaExcepcion;
import ec.edu.ups.excepciones.VacioExcepcion;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ec.edu.ups.modelo.Persona;

/**
 * 
 * @author ASUS
 */
public class PersonaDAO extends AbstractControlador<Persona> {

    public PersonaDAO(EntityManager em) {
        super(Persona.class, em);
    }

    public boolean crear(String cedula, String nombre, String apellido, String direccion, Calendar fechaNacimiento, double sueldo) throws VacioExcepcion, CedulaExcepcion {
        Persona persona = new Persona(cedula, nombre, apellido, direccion, fechaNacimiento, sueldo);
        validarCampos(persona);
        return super.crear(persona);
    }

    public Persona buscar(int id) {
        return (Persona) super.buscar(id);
    }

    public Persona buscar(String cedula) {
        Query query = getEm().createNamedQuery("Persona.findByCedula");
        return (Persona) query.setParameter("cedula", cedula).getSingleResult();
    }

    public boolean actualizar(int codigo, String cedula, String nombre, String apellido, String direccion, Calendar fechaNacimiento ,double sueldo) throws VacioExcepcion, CedulaExcepcion {
        Persona persona = buscar(codigo);
        if (persona != null) {
            persona.setCedula(cedula);
            persona.setDireccion(direccion);
            persona.setFechaNacimiento(fechaNacimiento);
            persona.setApellido(apellido);
            persona.setSueldo(sueldo);
            persona.setNombre(nombre);
            validarCampos(persona);

            return super.actualizar(persona);
        }
        return false;
    }

    public static void validarCampos(Persona persona) throws VacioExcepcion, CedulaExcepcion {
        if (persona.getCedula().equals("") || persona.getNombre().equals("") || persona.getApellido().equals("") || persona.getDireccion().equals("") || persona.getFechaNacimiento() == null) {
            throw new VacioExcepcion();
        }
        if (persona.getCedula().length() != 10 || validarCedula(persona.getCedula()) == false || persona.getCedula().contains("-") == true) {
            throw new CedulaExcepcion();
        }
    }

    public static boolean validarCedula(String cedula) {
        char digito[] = cedula.toCharArray();
        int total = 0;
        for (int i = 0; i < digito.length - 1; i++) {
            int dato = Integer.parseInt(digito[i] + "");
            if (i % 2 == 0) {
                if (dato * 2 > 9) {
                    dato = (dato * 2) - 9;
                } else {
                    dato = dato * 2;
                }
            }
            total += dato;
        }
        int ultimo = Integer.parseInt(digito[digito.length - 1] + "");
        if (total % 10 == 0 && 0 == ultimo) {
            return true;
        } else {
            total = 10 - total % 10;
            if (total == ultimo) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Persona> findAll() {
        return getEm().createNamedQuery("Persona.findAll").getResultList();
    }

}
