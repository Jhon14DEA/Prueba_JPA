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
public class HipotecaExcepcion extends Exception{
    public static String mensaje = "La casa se encuentra Hipotecada o Embargada";
    
    public HipotecaExcepcion() {
        super(mensaje);
    } 
    
}
