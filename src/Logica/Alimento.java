/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Danilo
 */
@Entity
public abstract class Alimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int idAlimento;
    private String nombre;
    private float precio;
    private enum_Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Alimento[ id=" + id + " ]";
    }

    public Alimento() {
    }

    public Alimento(Long id, int idAlimento, String nombre, float precio, enum_Categoria categoria) {
        this.id = id;
        this.idAlimento = idAlimento;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public enum_Categoria getCategoria() {
        return categoria;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCategoria(enum_Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
