/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luisg
 */
@Entity
@Table(name = "personal")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    @OneToMany(mappedBy = "personal")
    private List<Pedidos> pedidoss;
    private boolean borrada;
    
    public Personal(){}
    
    public Personal(String nombre,String apellido,String cedula){
        this.borrada = false;
        this.nombre=nombre;
        this.apellido=apellido;
        this.cedula=cedula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setPedidoss(List<Pedidos> pedidoss) {
        this.pedidoss = pedidoss;
    }

    public void setBorrada(boolean borrada) {
        this.borrada = borrada;
    }

    public List<Pedidos> getPedidoss() {
        return pedidoss;
    }

    public boolean isBorrada() {
        return borrada;
    }
}
