/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores_Interfaces;

import Logica.Alimento;
import Logica.Bebida;
import Logica.Categoria;
import Logica.Plato;
import Logica.enum_Bebida;
import com.mysql.jdbc.Blob;
import java.util.List;

/**
 *
 * @author luisg
 */
public interface IAlimentoController {

    public void altaBebida(String nom,float pre,String ingred,String desc,int cant,enum_Bebida tipo,int tiempoPreparacion); //falta tipo

    public abstract void altaPlato(String nom,float pre,String ingred,String desc,int cal,int tiempoPreparacion);
    public abstract void altaAlimento(Alimento a);
    public abstract List<Alimento> listarAlimentos();
    public abstract void modificarAlimento(Alimento a);
    public abstract void eliminarAlimento(Alimento a);
    public abstract void seleccionarAlimento(int idAlimento);
    public abstract List<Alimento> elegirCategoria(Categoria categoria);
    public abstract Alimento verDetalles(int idAlimento);
    public abstract void seleccionarAlimento(int idAlimento, int cantidad, String observacion);
    public abstract void ingresarComentario(String comentario);
    public abstract void ingresarFoto(Blob imagen);
    public abstract void ingresarPuntaje (int puntaje);
    public abstract void ingresarDatos(String nombre, String comentario);

    public abstract List<Plato> listarPlatos();
    public abstract List<Bebida> listarBebidas();
}
