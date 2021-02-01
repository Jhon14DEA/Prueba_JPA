/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.excepciones.GaranteExepcion;
import ec.edu.ups.excepciones.HipotecaExcepcion;
import ec.edu.ups.excepciones.VacioExcepcion;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import ec.edu.ups.modelo.Casa;
import ec.edu.ups.modelo.EnumHipoteca;
import ec.edu.ups.modelo.Hipoteca;
import ec.edu.ups.modelo.Persona;

/**
 *
 * @author ASUS
 */
public class HipotecaDAO extends AbstractControlador<Hipoteca> {

    public HipotecaDAO(EntityManager em) {

        super(Hipoteca.class, em);
    }

    public boolean crear(double monto, double interes, Calendar fechaInicio, Calendar fechaFin, double pagoMensualidad, Casa casa, int numeroPagos, Persona deudor, Persona garante, EnumHipoteca enumHipoteca, int pagosFantantes) throws VacioExcepcion, GaranteExepcion, HipotecaExcepcion {
        Hipoteca hipoteca = new Hipoteca(monto, interes, fechaInicio, fechaFin, pagoMensualidad, casa, numeroPagos, deudor, garante, enumHipoteca, pagosFantantes);
        validarCampos(hipoteca);
        return super.crear(hipoteca);
    }

    public Hipoteca buscar(int id) {
        return (Hipoteca) super.buscar(id);
    }

    public boolean actualizar(int codigo, double monto, double interes, Calendar fechaInicio, Calendar fechaFin, double pagoMensualidad, Casa casa, int numeroPagos, Persona deudor, Persona garante, EnumHipoteca enumHipoteca) throws VacioExcepcion, GaranteExepcion {
        Hipoteca hipoteca = buscar(codigo);
        if (hipoteca != null) {
            hipoteca.setCasa(casa);
            hipoteca.setDeudor(deudor);
            hipoteca.setFechaFin(fechaFin);
            hipoteca.setFechaInicio(fechaInicio);
            hipoteca.setGarante(garante);
            hipoteca.setInteres(interes);
            hipoteca.setMonto(monto);
            hipoteca.setNumeroPagos(numeroPagos);
            hipoteca.setPagoMensualidad(pagoMensualidad);
            hipoteca.setEnumHipoteca(enumHipoteca);

            validarCampos1(hipoteca);

            return super.actualizar(hipoteca);
        }
        return false;
    }

    public void actualizarPago(Hipoteca hipoteca) {
        if (hipoteca != null) {
            if (hipoteca.getPagosFaltantes()>0) {
                int numero = hipoteca.getPagosFaltantes() - 1;
                hipoteca.setPagosFaltantes(numero);
                
                if (hipoteca.getPagosFaltantes()==0) {
                    hipoteca.setEnumHipoteca(EnumHipoteca.PAGADO);
                }
            }
            super.actualizar(hipoteca);

        }

    }

    public static void validarCampos(Hipoteca hipoteca) throws VacioExcepcion, GaranteExepcion, HipotecaExcepcion {
        if (hipoteca.getCasa() == null || hipoteca.getDeudor() == null || hipoteca.getFechaInicio() == null || hipoteca.getFechaFin() == null) {
            throw new VacioExcepcion();
        }
        if (hipoteca.getDeudor() == hipoteca.getGarante()) {
            throw new GaranteExepcion();
        }
        if (hipoteca.getCasa().getEstado() == true) {
            throw new HipotecaExcepcion();
        }

    }

    public static void validarCampos1(Hipoteca hipoteca) throws VacioExcepcion, GaranteExepcion {
        if (hipoteca.getCasa() == null || hipoteca.getDeudor() == null || hipoteca.getFechaInicio() == null || hipoteca.getFechaFin() == null) {
            throw new VacioExcepcion();
        }
        if (hipoteca.getDeudor() == hipoteca.getGarante()) {
            throw new GaranteExepcion();
        }

    }

    @Override
    public List<Hipoteca> findAll() {
        return getEm().createNamedQuery("Hipoteca.findAll").getResultList();
    }
}
