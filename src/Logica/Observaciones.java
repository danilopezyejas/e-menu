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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author vanessa
 */
@Entity
@Table(name = "observaciones")
public class Observaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String observacion;
    
    @ManyToOne
    private Alimento alimento;
    @ManyToOne
    private Pedidos pedido;

    public Long getId() {
        return id;
    }
public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getObservacion() {
        return observacion;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public Pedidos getPedido() {
        return pedido;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
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
        if (!(object instanceof Observaciones)) {
            return false;
        }
        Observaciones other = (Observaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Observaciones[ id=" + id + " ]";
    }

    public Observaciones() {
    }
    
    
}
