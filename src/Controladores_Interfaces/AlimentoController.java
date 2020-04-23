/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores_Interfaces;

import Logica.Alimento;
import Logica.Categoria;
import Logica.Personal;
import Logica.Plato;
import Logica.enum_Categoria;
import Persistencia.Conexion;
import com.mysql.jdbc.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luisg
 */
public class AlimentoController implements IAlimentoController{
    private ArrayList<Plato> platos = new ArrayList<Plato>();
    private int idCategoria;
    private int idAlimento;
    private int puntaje;
    private String comentario;
    private String nombre;
    private HashMap<Integer, Integer> alimentos_cantidad;

    //singleton
    private AlimentoController() {
    } 
    public static AlimentoController getInstance() {
        return PersonalControllerHolder.INSTANCE;
    } 

    @Override
    public void altaAlimento(Alimento a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alimento> listarAlimentos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarAlimento(Alimento a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarAlimento(Alimento a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionarAlimento(int idAlimento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alimento> elegirCategoria(Categoria categoria) {
        
        List<Alimento> l = categoria.getAlimentos();
        return l;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alimento verDetalles(int idAlimento) {
        Alimento a = new Alimento();
        
        a = a.obtenerAlimentoPorId(idAlimento);
        return a;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionarAlimento(int idAlimento, int cantidad) {
        alimentos_cantidad = new HashMap<>();
        alimentos_cantidad.put(idAlimento,cantidad);
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
    public void altaPlato(String nom,float pre,String ingred,String desc,int cal){
        Plato plato=new Plato(); 
        plato.setNombre(nom);
        plato.setIngredientes(ingred);
        plato.setCalorias(cal);
        plato.setPrecio(pre);
        platos.add(plato);
        Conexion.getInstance().alta(plato);
        System.out.print("se dio de alta plato nombre"+nom);
    }
}
