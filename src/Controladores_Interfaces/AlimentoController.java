/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores_Interfaces;

import Logica.Bebida;

import Logica.Alimento;
import Logica.Categoria;
import Logica.Observaciones;
import Logica.Plato;
import Logica.enum_Bebida;
import Persistencia.Conexion;
import com.mysql.jdbc.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author luisg
 */
public class AlimentoController implements IAlimentoController{
    private ArrayList<Plato> platos = new ArrayList<Plato>();
    private ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
    private int idCategoria;
    private int idAlimento;
    private int puntaje;
    private String comentario;
    private String nombre;
    private HashMap<Integer, Integer> alimentos_cantidad;
    private List<Observaciones> observaciones;

    //singleton
    private AlimentoController() {
    } 
    public static AlimentoController getInstance() {
        return PersonalControllerHolder.INSTANCE;
    } 

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<Integer, Integer> getAlimentos_cantidad() {
        return alimentos_cantidad;
    }

    public List<Observaciones> getObservaciones() {
        return observaciones;
    }

    public void setPlatos(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlimentos_cantidad(HashMap<Integer, Integer> alimentos_cantidad) {
        this.alimentos_cantidad = alimentos_cantidad;
    }

    public void setObservaciones(List<Observaciones> observaciones) {
        this.observaciones = observaciones;
    }
    
    @Override
    public void altaAlimento(Alimento a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alimento> listarAlimentos() {
        List<Alimento> ret = Conexion.getInstance().consultaAlimentos();
        return ret;
    }

    @Override
    public void modificarAlimento(Alimento a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarAlimento(Alimento a) {
        if(a.isActivo()){
            a.setActivo(false);
            Conexion.getInstance().modificar(a);
        }else{
            Conexion.getInstance().baja(a);
        }
    }


    @Override
    public List<Alimento> elegirCategoria(Categoria categoria) {
        List<Alimento> l = categoria.getAlimentos();
        return l;
    }

    @Override
    public Alimento verDetalles(int idAlimento) {
        Alimento a = new Alimento();
        
        a = a.obtenerAlimentoPorId(idAlimento);
        return a;
    }

    @Override
    public void seleccionarAlimento(int idAlimento, int cantidad, String observacion) {
        //alimentos_cantidad = new HashMap<>();
        alimentos_cantidad.put(idAlimento,cantidad);
        
        Observaciones o = new Observaciones();
        
        o.setAlimento(buscarAlimentoPorId(idAlimento));
        o.setObservacion(observacion);
        
        observaciones.add(o);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarComentario(String comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarFoto(Blob imagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarPuntaje(int puntaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarDatos(String nombre, String comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static class PersonalControllerHolder {
        private static final AlimentoController INSTANCE = new AlimentoController();
    }
    //fin singleton
    
    //funcion de la interface
    @Override
    public void altaPlato(String nom,float pre,String ingred,int cal,int tiempoPreparacion, Categoria categoria){
        Plato plato=new Plato(); 

        plato.setNombre(nom);
        plato.setIngredientes(ingred);
        plato.setCalorias(cal);
        plato.setPrecio(pre);
        plato.setTiempoPreparacion(tiempoPreparacion);
        plato.setActivo(true);
        plato.setCategoria(categoria);
        
        platos.add(plato);
        Conexion.getInstance().alta(plato);
    }
    @Override
    public void altaBebida(String nom,float pre,String ingred,int cant,enum_Bebida tipo,int tiempoPreparacion, Categoria categoria){
        Bebida bebida=new Bebida(); 

        bebida.setNombre(nom);
        bebida.setIngredientes(ingred);
        bebida.setCantidad(cant);
        bebida.setPrecio(pre);
        bebida.setTiempoPreparacion(tiempoPreparacion);
        bebida.setTipo(tipo);
        bebida.setActivo(true);
        bebida.setCategoria(categoria);
        
        bebidas.add(bebida);
        Conexion.getInstance().alta(bebida);
    }
    @Override
    public Alimento buscarAlimentoPorId(int id) {
        EntityManager em = Conexion.getInstance().getEntity();
        Alimento a = null;
        em.getTransaction().begin();
        try {
            a = (Alimento) em.createNativeQuery("SELECT * FROM Alimento WHERE idAlimento=" + id, Alimento.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return a;
    }
    @Override
    public List<Plato> buscarPlatoPorId(int id) {
        EntityManager em = Conexion.getInstance().getEntity();
        List<Plato> p = null;
        em.getTransaction().begin();
        try {
            String QUERY = "Select a From Plato WHERE idAlimento=" + id;
            p = em.createQuery(QUERY, Plato.class).getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return p;
    }
    @Override
    public List<Plato> listarPlatos(){
        List<Plato> ret = Conexion.getInstance().consultaPlato();
        return ret;
    }
    @Override
    public List<Bebida> listarBebidas(){
        List<Bebida> ret = Conexion.getInstance().consultaBebida();
        return ret;
    }
    @Override
    public List<Categoria> listarCategoria(){
        List<Categoria> ret = Conexion.getInstance().consultarCategoria();
        return ret;
    }
}
