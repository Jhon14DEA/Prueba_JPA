/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * 
 * @author ASUS
 */
@Entity
@Table(name ="hipotecas")
@NamedQueries({
    //query son como buscadors 
    @NamedQuery(name = "Hipoteca.findAll", query = "SELECT h FROM Hipoteca h"),
    @NamedQuery(name = "Hipoteca.findByCodigo", query = "SELECT h FROM Hipoteca h WHERE h.codigo = :codigo"),
})
public class Hipoteca  implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "monto")
    private double monto;
    @Column(name = "interes")
    private double interes;
    @Column(name = "fecha_Inicio")
   // es para poder ocupar una varibale de tipo DATE
   @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fechaInicio;
    @Column(name = "fecha_Fin")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fechaFin;
    @Column(name = "pago_mensualidad")
    private double pagoMensualidad;
    @OneToOne
    //Join sirve para relacionar un objeto con otro tecnicamente llamada una clave foraanea 
    @JoinColumn(name = "casa_id", nullable = false, referencedColumnName = "codigo")
    private Casa casa;
    @Column(name = "numero_pagos")
    private int numeroPagos;
    @Column(name = "pagos_Faltantes")
    private int pagosFaltantes;
    @OneToOne
    @JoinColumn(name = "deudor", nullable = false,referencedColumnName = "cedula" )
    private Persona deudor;
    @OneToOne
    @JoinColumn(name = "garante",referencedColumnName = "cedula")
    private Persona garante;
    @Column(name="Estado")
    //SON PARA LA CLASE ENUMhIPOTECA
    @Enumerated(EnumType.STRING)
    private EnumHipoteca enumHipoteca;
    //Es el papeo logico que sirve para las listas dentro de una clases 
    @ManyToOne
    @JoinColumn(name = "hipoteca_fk")
    private Banco banco;
    public Hipoteca() {

    }

    public Hipoteca(double monto, double interes, Calendar fechaInicio, Calendar fechaFin, double pagoMensualidad, Casa casa, int numeroPagos, Persona deudor, Persona garante, EnumHipoteca enumHipoteca, int pagosFaltantes) {
        this.monto = monto;
        this.interes = interes;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pagoMensualidad = pagoMensualidad;
        this.casa = casa;
        this.numeroPagos = numeroPagos;
        this.deudor = deudor;
        this.garante = garante;
        this.enumHipoteca = enumHipoteca;
        this.pagosFaltantes= pagosFaltantes;
    }

    public int getPagosFaltantes() {
        return pagosFaltantes;
    }

    public void setPagosFaltantes(int pagosFaltantes) {
        this.pagosFaltantes = pagosFaltantes;
    }

  
    

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

   

  

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    

    public double getPagoMensualidad() {
        return pagoMensualidad;
    }

    public void setPagoMensualidad(double pagoMensualidad) {
        this.pagoMensualidad = pagoMensualidad;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public int getNumeroPagos() {
        return numeroPagos;
    }

    public void setNumeroPagos(int numeroPagos) {
        this.numeroPagos = numeroPagos;
    }

    public Persona getDeudor() {
        return deudor;
    }

    public void setDeudor(Persona deudor) {
        this.deudor = deudor;
    }

    public Persona getGarante() {
        return garante;
    }

    public void setGarante(Persona garante) {
        this.garante = garante;
    }

    public EnumHipoteca getEnumHipoteca() {
        return enumHipoteca;
    }

    public void setEnumHipoteca(EnumHipoteca enumHipoteca) {
        this.enumHipoteca = enumHipoteca;
    }

    @Override
    public String toString() {
        return  "\ncodigo=" + codigo + "\n monto=" + monto + "\n interes=" + interes + "\n fechaInicio=" + fechaInicio + "\n fechaFin=" + fechaFin + "\n pagoMensualidad=" + pagoMensualidad + "\n casa=" + casa + "\n numeroPagos=" + numeroPagos + "\n pagosFaltantes=" + pagosFaltantes +  "\n garante=" + garante + "\n enumHipoteca=" + enumHipoteca ;
    }

    
  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hipoteca other = (Hipoteca) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

}
