/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Danilo
 */
@Entity
@Table(name = "plato")
@PrimaryKeyJoinColumn(name="idAlimento")
public class Plato extends Alimento {

    private int calorias;
    @OneToMany(mappedBy = "plato")
    private List<Resenia> resenias;
    
    public Plato() {
    }

    public int getCalorias() {
        return calorias;
    }

   

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
  
}
