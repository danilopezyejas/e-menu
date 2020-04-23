/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Conexion;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author vanessa
 */
@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    
    @OneToMany(mappedBy = "categoria")
    List<Alimento> alimentos = obtenerAlimentos();

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
        String QUERY = "Select * From Alimento where categoria_id = ?n";
        EntityManager em = Conexion.getInstance().getEntity();
        List<Alimento> ret = em.createQuery(QUERY, Alimento.class).setParameter("n",nombre).getResultList();
        //System.out.println("num of personal:" + ret.size());
        return ret;
    }
    
}
