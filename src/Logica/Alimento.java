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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Danilo
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Alimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAlimento;
    private String nombre;
    private float precio;
    @ManyToOne
    private Categoria categoria;
    @ManyToMany(mappedBy = "alimento")
    private List<Pedidos> pedidoss;
    @OneToMany(mappedBy = "alimento")
    private List<Observaciones> observacioness;
    private String ingredientes;   
    private int tiempoPreparacion;   
    private boolean activo;
    
    public Long getId() {
        return idAlimento;
    }

    public void setId(Long id) {
        this.idAlimento = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlimento != null ? idAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.idAlimento == null && other.idAlimento != null) || (this.idAlimento != null && !this.idAlimento.equals(other.idAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Alimento[ id=" + idAlimento + " ]";
    }

    public Alimento() {
    }

    public Alimento(String nombre, float precio, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public Alimento obtenerAlimentoPorId(int id) {
        String QUERY = "Select * From Alimento where idAlimento=?id ";
        EntityManager em = Conexion.getInstance().getEntity();
        Alimento ret = (Alimento) em.createQuery(QUERY, Alimento.class).setParameter("id", id).getResultList();
        //System.out.println("num of personal:" + ret.size());
        return ret;
    }
}
