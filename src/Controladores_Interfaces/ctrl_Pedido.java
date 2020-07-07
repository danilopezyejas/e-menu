/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores_Interfaces;

import Logica.Alimento;
import Logica.Categoria;
import Logica.Mesa;
import Logica.Observaciones;
import Logica.Pago;
import Logica.Pedidos;
import Logica.enum_Estado;
import Logica.enum_Pago;
import Persistencia.Conexion;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Danilo
 */
public class ctrl_Pedido implements ictrl_Pedido {

    private static ctrl_Pedido instancia;
    private int cant;
    private int idMesa;

    Conexion c = new Conexion();
    AlimentoController ca = AlimentoController.getInstance();

    public static ctrl_Pedido getInstancia() {
        if (instancia == null) {
            instancia = new ctrl_Pedido();
        }
        return instancia;
    }

    @Override
    public void confirmarPedido(String contraseña) {
        Date fecha_hora = new Date();//se crea con la fecha y hora del sistema
        Mesa m = buscarMesaPorId(idMesa);
        List<Alimento> listAlimentos = new ArrayList<>();
        List<Observaciones> o = ca.getObservaciones();//las observaciones que se ingresaron previamente en el controlador de alimento
        int precio_total = 0;
        
//se crea el objeto pedido con todos los datos vacios
        Pedidos p = new Pedidos();
        //se setean los datos 
        p.setContrasenia(contraseña);
        p.setEstado(enum_Estado.Activo);
        p.setFecha_hora(fecha_hora);
        //p.setPrecio_total(cant);
        p.setMesa(m);
        p.setAlimentos_cantidad(ca.getAlimentos_cantidad());
        
        //Se cargan los alimentos del pedido
        for (Map.Entry<Integer,Integer> entry : p.getAlimentos_cantidad().entrySet()) {
            Integer idAlimento = entry.getKey();
            Alimento a = new Alimento();
            a = ca.buscarAlimentoPorId(idAlimento);
            listAlimentos.add(a);
        }
        p.setAlimento(listAlimentos);
        
        //A cada objeto observaciones se le setea el atributo pedido
        for (int i = 0; i < o.size(); i++) {
            Observaciones aux = (Observaciones) o.get(i);
            aux.setPedido(p);
        }
        p.setObservacioness(ca.getObservaciones());
        
        //recorro todos los alimentos para saber el precio total del pedido
        
        for (int i = 0; i < listAlimentos.size(); i++) {
            Alimento aux = (Alimento) listAlimentos.get(i);
            precio_total += aux.getPrecio();
        }
        p.setPrecio_total(precio_total);
    }

    @Override
    public boolean escanearCodigo(int idMesa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void solicitarPago(Long id, String tipoPago) {
        enum_Pago metodoPago;
        metodoPago = (tipoPago.equals("tarjeta"))?enum_Pago.tarjeta:enum_Pago.efectivo;
        Pedidos pedido = Conexion.getInstance().buscarPedidoId(id);
        Pago pago = Conexion.getInstance().buscarPago(id);
        pago.setMetodoPago(metodoPago);
        Conexion.getInstance().modificar(pago);
        pedido.setEstado(enum_Estado.Pagar);
        Conexion.getInstance().modificar(pedido);
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
        Conexion.getInstance().baja(buscarMesaPorId(idMesa));
    }

    @Override
    public void altaMesa(Mesa mesa) {
        Conexion.getInstance().alta(mesa);
    }
    
    @Override
    public List<Mesa> listarMesas(){
        return Conexion.getInstance().consultaMesas();
    }

    @Override
    public List<Pedidos> consultaPedidosMesa(int numMesa) {
        return Conexion.getInstance().consultaPedidosMesa(numMesa);
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

    @Override
    public Mesa buscarMesaPorId(int id) {
        long idMesa = id;
        EntityManager em = Conexion.getInstance().getEntity();
        Mesa m = null;
        em.getTransaction().begin();
        try {
            m = (Mesa) em.createNativeQuery("SELECT * FROM Mesa WHERE id=" + idMesa, Mesa.class).getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return m;
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
    

    @Override
    public Mesa buscarMesaPorNum(int numMesa) {
        long mesa = numMesa;
        EntityManager em = Conexion.getInstance().getEntity();
        Mesa m = null;
        em.getTransaction().begin();
        try {
            m = (Mesa) em.createNativeQuery("SELECT * FROM Mesa WHERE numeroMesa=" + mesa, Mesa.class).getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return m;
    }

    @Override
    public void solicitarPagarTodo(int numMesa, String tipoPago) {
        List<Pedidos> pedidos = new ArrayList<>();
        pedidos = consultaPedidosMesa(numMesa);
        for(Pedidos p : pedidos){
            solicitarPago(p.getId(), tipoPago);
        }
    }

    public Pedidos obtenerUltimoPedidoPendientePorMesa(int nromesa){
        String QUERY = "SELECT * FROM e_menu.pedidos p inner join mesa m on p.mesa_id=m.id "
                + "where numeroMesa=? and estado = 0 order by fecha_hora desc limit 1;";
        EntityManager em = Conexion.getInstance().getEntity();
        Query query = em.createNativeQuery(QUERY, Pedidos.class);
        query.setParameter(1, nromesa);
        Pedidos ret;
        
        try {
            ret = (Pedidos)query.getSingleResult();
        } catch (Exception e) {
            ret = null;
        }
         return ret;
    }
    
    public Pedidos obtenerUltimoPedidoSinPagarPorMesa(int nromesa){
        String QUERY = "SELECT * FROM e_menu.pedidos p inner join mesa m on p.mesa_id=m.id "
                + "where numeroMesa=? and estado = 2 order by fecha_hora desc limit 1;";
        EntityManager em = Conexion.getInstance().getEntity();
        Query query = em.createNativeQuery(QUERY, Pedidos.class);
        query.setParameter(1, nromesa);
        Pedidos ret;
        
        try {
            ret = (Pedidos)query.getSingleResult();
        } catch (Exception e) {
            ret = null;
        }
         return ret;
    }

    @Override
    public List<Observaciones> obtenerObservacionesPorPedido(int id) {
        String QUERY = "SELECT * FROM observaciones WHERE pedido_id=" + id;
        EntityManager em = Conexion.getInstance().getEntity();
        Query query = em.createNativeQuery(QUERY, Observaciones.class);
        //query.setParameter(0, id);
        List<Observaciones> ret = new ArrayList<>();
        ret = query.getResultList();
        return ret;
    }
    
    public List<Pedidos> obtenerListaPedidosPendientesPorMesa(int nromesa){
        EntityManager em = Conexion.getInstance().getEntity();
        List<Pedidos> lista = null;
        String query = "SELECT * FROM e_menu.pedidos p inner join mesa m on p.mesa_id=m.id "
                + "where numeroMesa="+nromesa+" and estado = 0 order by fecha_hora desc";
        em.getTransaction().begin();
        try {
            lista = em.createNativeQuery(query, Pedidos.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    }
}
