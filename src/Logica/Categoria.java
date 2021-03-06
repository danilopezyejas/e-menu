/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Conexion;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author vanessa
 */
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private Blob imagen;
    private int cantAdicionales;
    private boolean mostrar;
    private boolean borrada;
    
    @OneToOne
    private Categoria secundaria;
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    List<Alimento> alimentos; //= obtenerAlimentos();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Blob getImagen(){
        return this.imagen;
    }
    public void setImagen(Blob imagen){
        this.imagen = imagen;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
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
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Categoria[ id=" + id + " ]";
    }
    
    public List<Alimento> obtenerAlimentos() {
        EntityManager em = Conexion.getInstance().getEntity();
        List<Alimento> lista = null;
        em.getTransaction().begin();
        try {
            lista = em.createNativeQuery("SELECT * FROM Alimento WHERE categoria_id =" + id, Categoria.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    }

    public Categoria() {
    }

    public Categoria(String nombre, Blob imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.mostrar =  true;
        this.borrada = false;
    }

    public void setSecundaria(Categoria secundaria) {
        this.secundaria = secundaria;
    }

    public Categoria getSecundaria() {
        return secundaria;
    }

    public void setCantAdicionales(int cantAdicionales) {
        this.cantAdicionales = cantAdicionales;
    }

    public int getCantAdicionales() {
        return cantAdicionales;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public void setBorrada(boolean borrada) {
        this.borrada = borrada;
    }

    public boolean isBorrada() {
        return borrada;
    }
    
}
