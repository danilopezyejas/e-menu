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
import javax.persistence.OneToOne;

/**
 *
 * @author vanessa
 */
@Entity
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long rut;
    private enum_Pago metodoPago;
    
    @OneToOne
    private Pedidos pedido;

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
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Pago[ id=" + id + " ]";
    }

    public Pago() {
    }

    public void setRut(Long rut) {
        this.rut = rut;
    }

    public void setMetodoPago(enum_Pago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getRut() {
        return rut;
    }

    public enum_Pago getMetodoPago() {
        return metodoPago;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public Pago(Long rut, enum_Pago metodoPago, Pedidos pedido) {
        this.rut = rut;
        this.metodoPago = metodoPago;
        this.pedido = pedido;
    }
    
    
}
