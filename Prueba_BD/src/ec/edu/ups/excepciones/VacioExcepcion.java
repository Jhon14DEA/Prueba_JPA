/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.excepciones;

/**
 *
 * @author ASUS
 */
public class VacioExcepcion extends  Exception{
    public static String mensaje = "Los datos no puueden ser vacios";
    public VacioExcepcion() {
        super(mensaje);
    }
    
}
