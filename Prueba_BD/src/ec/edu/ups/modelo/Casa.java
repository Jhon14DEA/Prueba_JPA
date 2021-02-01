/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author ASUS
 * damed queries nos sirve para buscar las tablas
 */
@Entity
@Table(name = "casas")
@NamedQueries({
    @NamedQuery(name = "Casa.findAll", query = "SELECT c FROM Casa c"),
    @NamedQuery(name = "Casa.findByCodigo", query = "SELECT c FROM Casa c WHERE c.codigo = :codigo"),
})
public class Casa implements Serializable {

    @Id
    //se genera un codigo por defecto
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //creamos la columna 
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "avaluo")
    private double avaluo;
    @Column(name = "estado")
    private boolean estado;
    public Casa() {

    }

    public Casa(String direccion, double avaluo,boolean estado) {
        this.direccion = direccion;
        this.avaluo = avaluo;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getAvaluo() {
        return avaluo;
    }

    public void setAvaluo(double avaluo) {
        this.avaluo = avaluo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return " Direccion=" + direccion + "\n Avaluo=" + avaluo + '$';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codigo;
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
        final Casa other = (Casa) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

}
