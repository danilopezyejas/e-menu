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
import Logica.Pedidos;
import Logica.enum_Estado;
import Persistencia.Conexion;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Pedidos getUltimoInsertado(){
        EntityManager em = Conexion.getInstance().getEntity();
        Pedidos pedido = null;
        em.getTransaction().begin();
        try {
            pedido = (Pedidos)em.createNativeQuery("SELECT * FROM `pedidos` WHERE id=(SELECT MAX(id) FROM pedidos)", Pedidos.class).getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return pedido;
    }
}
