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
public class Bebida extends Alimento {

    private int cantidad;
    private enum_Bebida tipo;

    public Bebida() {
    }

    public Bebida(int cantidad, enum_Bebida tipo) {
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

//    public Bebida(Long id, int idAlimento, String nombre, float precio, enum_Categoria categoria) {
//        super(id, idAlimento, nombre, precio, categoria);
//    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public enum_Bebida getTipo() {
        return tipo;
    }

    public void setTipo(enum_Bebida tipo) {
        this.tipo = tipo;
    }

    
}
