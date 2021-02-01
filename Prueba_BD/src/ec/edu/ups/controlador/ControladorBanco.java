/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import ec.edu.ups.modelo.Banco;

/**
 *
 * @author ASUS
 */
public class ControladorBanco extends AbstractControlador<Banco>{
      public ControladorBanco(EntityManager em){
      super(Banco.class, em);
}    

    @Override
    public List<Banco> findAll() {
       return getEm().createNamedQuery("Banco.findAll").getResultList();
    }
}
