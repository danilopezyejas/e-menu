/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Alimento;
import Logica.Bebida;
import Logica.Categoria;
import Logica.Error;
import Logica.Mesa;
import Logica.Pago;
import Logica.Pedidos;
import Logica.Personal;
import Logica.Plato;
import Logica.Resenia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static org.hibernate.criterion.Expression.sql;

/**
 *
 * @author Danilo
 */
public class Conexion {
public Conexion() {
    }
    
    public static Conexion getInstance() {
        return ConexionHolder.INSTANCE;
    }
    
    private static class ConexionHolder {

        private static final Conexion INSTANCE = new Conexion();
        private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("eMenuPU");
        private static EntityManager em = emf.createEntityManager();
    }
    
    public EntityManager getEntity(){
        return ConexionHolder.em;
    }

    public void alta(Object object) {
        EntityManager em = Conexion.getInstance().getEntity();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void baja(Object object) {
        EntityManager em = Conexion.getInstance().getEntity();
        em.getTransaction().begin();
        try {
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } 
    }

    public void modificar(Object object) {
        EntityManager em = Conexion.getInstance().getEntity();
        em.getTransaction().begin();
        try {
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    public List<Personal> consultarPersonal() {
        String QUERY = "Select * From Personal where borrada != true";
        EntityManager em = Conexion.getInstance().getEntity();
        List<Personal> ret = em.createNativeQuery(QUERY, Personal.class).getResultList();
        return ret;
    }
    public List<Alimento> consultaAlimentos() {
        EntityManager em = Conexion.getInstance().getEntity();
        List<Alimento> ret = null;
        try{
            String QUERY = "Select * , 1 as clazz_, From Alimento ";
            em.getTransaction().begin();
            ret = em.createNativeQuery(QUERY, Alimento.class).getResultList();
            em.getTransaction().commit();
        }catch(Exception e ){
            em.getTransaction().rollback();
        }
        return ret;
    }
    
    public List<Plato> consultaPlato() {
        String QUERY = "Select a From Plato a";
        EntityManager em = Conexion.getInstance().getEntity();
        List<Plato> ret = em.createQuery(QUERY, Plato.class).getResultList();
        return ret;
    }
    public List<Resenia> consultaTodasResenia() {
        String QUERY = "Select a From Resenia a";
        EntityManager em = Conexion.getInstance().getEntity();
        List<Resenia> ret = em.createQuery(QUERY, Resenia.class).getResultList();
        return ret;
    }        
    public Plato consultaPlatoEspesifico(int id) {
        String QUERY = "SELECT * FROM Plato as c WHERE c.idAlimento=?";
        EntityManager em = Conexion.getInstance().getEntity();
        Query query = em.createNativeQuery(QUERY, Plato.class);
        query.setParameter(1, id);
        Plato ret;
        ret = (Plato)query.getSingleResult();
        return ret;
        
    }
     public List<Bebida> consultaBebida() {
        String QUERY = "Select a From Bebida a";
        EntityManager em = Conexion.getInstance().getEntity();
        List<Bebida> ret = em.createQuery(QUERY, Bebida.class).getResultList();
         return ret;
    }
    public List<Categoria> consultarCategoria() {
        String QUERY = "Select * From Categoria where borrada != true";
        EntityManager em = Conexion.getInstance().getEntity();
        List<Categoria> ret = em.createNativeQuery(QUERY, Categoria.class).getResultList();
        return ret;
    }
    public List<Mesa> consultaMesas(){
        String QUERY = "Select * From Mesa where borrada != true";
        EntityManager em = Conexion.getInstance().getEntity();
        List<Mesa> ret = em.createNativeQuery(QUERY, Mesa.class).getResultList();
        return ret;
    }
    public List<Pedidos> consultaPedidosMesa(int numMesa){
        String QUERY = "SELECT p.* FROM pedidos as p, mesa as m WHERE p.mesa_id=m.id AND p.estado = 1 AND m.numeroMesa=?";
        EntityManager em = Conexion.getInstance().getEntity();
        Query query = em.createNativeQuery(QUERY, Pedidos.class);
        query.setParameter(1, numMesa);
        List<Pedidos> ret = new ArrayList<>();
        ret = query.getResultList();
        return ret;
    }
    
    public Pedidos buscarPedidoId(Long id){
        String QUERY = "SELECT * FROM pedidos as p WHERE p.id=?";
        EntityManager em = Conexion.getInstance().getEntity();
        Query query = em.createNativeQuery(QUERY, Pedidos.class);
        query.setParameter(1, id);
        Pedidos ret;
        ret = (Pedidos)query.getSingleResult();
        return ret;
    }
     public List<Resenia> consultaResenia(int plato) {

        String QUERY = "SELECT * FROM resenia as c WHERE c.plato_idAlimento=?";
        EntityManager em = Conexion.getInstance().getEntity();
        Query query = em.createNativeQuery(QUERY, Resenia.class);
        query.setParameter(1, plato);
        List<Resenia> ret;
 
        ret = (List<Resenia>)query.getResultList();
        return ret;
  
    }
    public Categoria buscarCategoriaId(int id) throws Error{
        String QUERY = "SELECT * FROM categoria as c WHERE c.id=?";
        EntityManager em = Conexion.getInstance().getEntity();
        Query query = em.createNativeQuery(QUERY, Categoria.class);
        query.setParameter(1, id);
        Categoria ret;
        if(query.getResultList().size() != 1){
            throw new Logica.Error("Ha ocurrido un error con la categoria primaria.");
        }
        ret = (Categoria)query.getSingleResult();
        return ret;
    }
    
    public Pago buscarPago(Long idPedido){
        String QUERY = "SELECT * FROM pago as p WHERE p.pedido_id=?";
        EntityManager em = Conexion.getInstance().getEntity();
        Query query = em.createNativeQuery(QUERY, Pago.class);
        query.setParameter(1, idPedido);
        Pago ret;
        if(query.getResultList().size() != 1){
            ret = null;
        }
        ret = (Pago)query.getSingleResult();
        return ret;
    }
}
