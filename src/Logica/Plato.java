/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Danilo
 */
@Entity
@PrimaryKeyJoinColumn(name="idAlimento")
public class Plato extends Alimento {

    private int calorias;

    
    public Plato() {
    }

    public int getCalorias() {
        return calorias;
    }

   

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
  
}
