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

    private String ingredientes;
    private int calorias;

    
    public Plato() {
    }

//    public Plato(Long id, int idAlimento, String nombre, float precio, enum_Categoria categoria) {
//        super(id, idAlimento, nombre, precio, categoria);
//    }

    public String getIngredientes() {
        return ingredientes;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
  
}
