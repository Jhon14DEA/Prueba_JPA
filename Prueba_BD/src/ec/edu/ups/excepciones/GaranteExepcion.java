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
public class GaranteExepcion extends Exception{
    public static String mensaje = "El garante es el mismo que el deudor";
    
    public GaranteExepcion() {
        super(mensaje);
    } 
    
}
