/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores_Interfaces;

import Logica.Categoria;
import Logica.Mesa;
import Logica.Pedidos;
import Logica.enum_Estado;
import Persistencia.Conexion;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Danilo
 */
public class ctrl_Pedido implements ictrl_Pedido {

    private static ctrl_Pedido instancia;
    private int cant;
    private int idMesa;

    Conexion c = new Conexion();

    public static ctrl_Pedido getInstancia() {
        if (instancia == null) {
            instancia = new ctrl_Pedido();
        }
        return instancia;
    }

    @Override
    public void confirmarPedido() {
        Pedidos p = new Pedidos();
        p.setContraseña("123456");
        p.setEstado(enum_Estado.Activo);
        Date fecha_hora = new Date();//se crea con la fecha y hora del sistema
        p.setFecha_hora(fecha_hora);
        p.setPrecio_total(cant);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean escanearCodigo(int idMesa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float solicitarPago(int idMesa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, String> listarCategorias() {
        HashMap<String, String> lista = new HashMap<>();
        List<Categoria> categorias = new ArrayList<>();
        categorias = c.consultarCategoria();

        for (Categoria c : categorias) {
            lista.put(c.getNombre(),c.getNombre());
        }
        System.out.println("Map is " + lista);
        return lista;

    }

    @Override
    public void confirmarPedido(int tipo_pago) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean pagar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean realizarReclamo(String reclamo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bajaMesa(int idMesa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altaMesa(int idMesa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pedidos consultaPedidoMesa(int idMesa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarObservacion(String observacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCant() {
        return cant;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public List<Mesa> buscarMesaPorId(int id) {
        EntityManager em = Conexion.getInstance().getEntity();
        List<Mesa> lista = null;
        em.getTransaction().begin();
        try {
            lista = em.createNativeQuery("SELECT * FROM Mesa WHERE numeroMesa=" + id, Mesa.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    }

    public List<Mesa> buscarMesas() {
        EntityManager em = Conexion.getInstance().getEntity();
        List<Mesa> lista = null;
        em.getTransaction().begin();
        try {
            lista = em.createNativeQuery("SELECT * FROM Mesa ", Mesa.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    }
}
