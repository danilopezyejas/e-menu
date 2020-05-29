/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Danilo
 */
@Entity
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_hora;
    private int precio_total;
    private String contrasenia;
    private enum_Estado estado;
    
    @ManyToOne
    private Personal personal; //Este sería el mozo que atiende el pedido
    @ManyToOne
    private Mesa mesa;//Esta es la mesa en la que hacen el pedido
    @ManyToMany
    private List<Alimento> alimento;
    @OneToMany(mappedBy = "pedido")
    private List<Observaciones> observacioness;
    @OneToOne(mappedBy = "pedido",cascade = CascadeType.PERSIST)
    private Pago pago;
    private HashMap<Integer, Integer> alimentos_cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public int getPrecio_total() {
        return precio_total;
    }

    public String getContraseña() {
        return contrasenia;
    }

    public enum_Estado getEstado() {
        return estado;
    }

    public Personal getPersonal() {
        return personal;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public List<Alimento> getAlimento() {
        return alimento;
    }

    public List<Observaciones> getObservacioness() {
        return observacioness;
    }

    public Pago getPago() {
        return pago;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public HashMap<Integer, Integer> getAlimentos_cantidad() {
        return alimentos_cantidad;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public void setPrecio_total(int precio_total) {
        this.precio_total = precio_total;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setEstado(enum_Estado estado) {
        this.estado = estado;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void setAlimento(List<Alimento> alimento) {
        this.alimento = alimento;
    }

    public void setObservacioness(List<Observaciones> observacioness) {
        this.observacioness = observacioness;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public void setAlimentos_cantidad(HashMap<Integer, Integer> alimentos_cantidad) {
        this.alimentos_cantidad = alimentos_cantidad;
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
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Pedidos[ id=" + id + " ]";
    }

    public Pedidos() {
    }

    public Pedidos(Date fecha_hora, int precio_total, String contrasenia, enum_Estado estado, Mesa mesa, List<Alimento> alimento, List<Observaciones> observacioness, Pago pago, HashMap<Integer, Integer> alimentos_cantidad) {
        this.fecha_hora = fecha_hora;
        this.precio_total = precio_total;
        this.contrasenia = contrasenia;
        this.estado = estado;
        this.mesa = mesa;
        this.alimento = alimento;
        this.observacioness = observacioness;
        this.pago = pago;
        this.alimentos_cantidad = alimentos_cantidad;
    }
    
    
}
