/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.controlador.PersonaDAO;
import ec.edu.ups.excepciones.CedulaExcepcion;
import ec.edu.ups.excepciones.GaranteExepcion;
import ec.edu.ups.excepciones.HipotecaExcepcion;
import ec.edu.ups.excepciones.VacioExcepcion;
import java.util.Calendar;
import java.util.Date;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Casa;
import ec.edu.ups.modelo.Hipoteca;
import ec.edu.ups.modelo.Banco;

import javax.persistence.EntityManager;
import ec.edu.ups.modelo.EnumHipoteca;
import ec.edu.ups.utils.JPAUtils;

/**
 *
 * @author ASUS
 */
public class ControladorPrincipal {

    private PersonaDAO personaDAO;
    private CasaDAO casaDAO;
    private HipotecaDAO hipotecaDAO;
    private BancoControlador bancoControlador;
    private EntityManager em;

    public ControladorPrincipal() {
        em = JPAUtils.getEntityManager();
        personaDAO = new PersonaDAO(em);
        casaDAO = new CasaDAO(em);
        hipotecaDAO = new HipotecaDAO(em);
        bancoControlador = new BancoControlador(em);

    }
    //--------------------------PERSONA-----------------------------------------//
    public String crearPersona(String cedula, String nombre, String apellido, String direccion, Calendar fechaNacimiento,double sueldo) throws VacioExcepcion, CedulaExcepcion {
        return personaDAO.crear(cedula, nombre, apellido, direccion, fechaNacimiento, sueldo) == true ? "Exitoso" : "Error";
    }

    public String actualizarPersona(int codigo, String cedula, String nombre, String apellido, String direccion, Calendar fechaNacimiento,double sueldo) throws VacioExcepcion, CedulaExcepcion {
        return personaDAO.actualizar(codigo, cedula, nombre, apellido, direccion, fechaNacimiento, sueldo) == true ? "Exitoso" : "Error";
    }

    public Persona BuscarPersona(int codigo) {
        Persona persona = personaDAO.buscar(codigo);
        return persona;
    }
    //-----------------------------------------------------------------------//
    
    
    
    //--------------------------CASA-----------------------------------------//
     public String crearCasa(String direccion, double avaluo, boolean estado) throws VacioExcepcion {
        return casaDAO.crear(direccion, avaluo,estado) == true ? "Exitoso" : "Error";
    }

    public String actualizarCasa(int codigo,String direccion, double avaluo,boolean estado) throws VacioExcepcion {
        return casaDAO.actualizar(codigo, direccion, avaluo,estado) == true ? "Exitoso" : "Error";
    }

    public Casa BuscarCasa(int codigo) {
        Casa casa = casaDAO.buscar(codigo);
        return casa;
    }
     
    public void actualizarEstado(boolean estado, int casa){
        casaDAO.actualizarEstado(estado, casa);
    }
    
    //-----------------------------------------------------------------------//
    
    
     //--------------------------HIPOTECA-----------------------------------------//
     public String crearHipoteca(double monto, double interes, Calendar fechaInicio, Calendar fechaFin, double pagoMensualidad, Casa casa, int numeroPagos, Persona deudor, Persona garante, EnumHipoteca enumHipoteca, int pagosFantantes) throws VacioExcepcion,GaranteExepcion ,HipotecaExcepcion {
        return hipotecaDAO.crear(monto, interes, fechaInicio, fechaFin, pagoMensualidad, casa, numeroPagos, deudor, garante, enumHipoteca,pagosFantantes) == true ? "Exitoso" : "Error";
    }

    public String actualizarHipoteca(int codigo,double monto, double interes, Calendar fechaInicio, Calendar fechaFin, double pagoMensualidad, Casa casa, int numeroPagos, Persona deudor, Persona garante, EnumHipoteca enumHipoteca) throws VacioExcepcion,GaranteExepcion {
        return hipotecaDAO.actualizar(codigo, monto, interes, fechaInicio, fechaFin, pagoMensualidad, casa, numeroPagos, deudor, garante, enumHipoteca) == true ? "Exitoso" : "Error";
    }

    public Hipoteca BuscarHipoteca(int codigo) {
        Hipoteca hipoteca = hipotecaDAO.buscar(codigo);
        return hipoteca;
    }
    
    //-----------------------------------------------------------------------//
    public Persona BuscarPersona(String cedula) {
        Persona persona = personaDAO.buscar(cedula);
        return persona;
    }

    public PersonaDAO getPersonaDAO() {
        return personaDAO;
    }

    public void setPersonaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public CasaDAO getCasaDAO() {
        return casaDAO;
    }

    public void setCasaDAO(CasaDAO casaDAO) {
        this.casaDAO = casaDAO;
    }

    public HipotecaDAO getHipotecaDAO() {
        return hipotecaDAO;
    }

    public void setHipotecaDAO(HipotecaDAO hipotecaDAO) {
        this.hipotecaDAO = hipotecaDAO;
    }

    public BancoControlador getBancoControlador() {
        return bancoControlador;
    }

    public void setBancoControlador(BancoControlador bancoControlador) {
        this.bancoControlador = bancoControlador;
    }

}
