/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

//import com.mysql.jdbc.Blob;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Danilo
 */
@Entity
@Table(name = "mesa")
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numeroMesa;
    @Column
    @Lob
    private Blob foto;
    @OneToMany(mappedBy = "mesa")
    private List<Pedidos> pedidoss;
    private boolean borrada;
    
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
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Mesa[ id=" + id + " ]";
    }

    public Mesa() {
    }

    public Mesa(int numeroMesa, Blob foto) {
        this.numeroMesa = numeroMesa;
        this.foto = foto;
        this.borrada = false;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public List<Pedidos> getPedidoss() {
        return pedidoss;
    }

    public boolean isBorrada() {
        return borrada;
    }

    public void setPedidoss(List<Pedidos> pedidoss) {
        this.pedidoss = pedidoss;
    }

    public void setBorrada(boolean borrada) {
        this.borrada = borrada;
    }
    
    
}
