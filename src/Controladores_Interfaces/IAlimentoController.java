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
import java.sql.Blob;
import java.util.List;

/**
 *
 * @author luisg
 */
public interface IAlimentoController {
    public List<Alimento> listarTodo();
    public void altaBebida(String nom,float pre,String ingred,int cant,enum_Bebida tipo,int tiempoPreparacion, Categoria categoria); //falta tipo
    public abstract void altaPlato(String nom,float pre,String ingred,int cal,int tiempoPreparacion, Categoria categoria);
    public abstract void altaAlimento(Alimento a);
    public abstract void altaCategoria(String nombre, Blob imagen, String id, String cant)throws Logica.Error;
    public abstract Categoria agregarAdicional(String id, String cant)throws Logica.Error;
    public abstract List<Alimento> listarAlimentos();
    public abstract void modificarAlimento(Alimento a);
    public abstract void eliminarAlimento(Alimento id);
    public abstract Alimento buscarAlimentoPorId(int id);
    public abstract List<Plato> buscarPlatoPorId(int id);
    public abstract List<Alimento> elegirCategoria(Categoria categoria);
    public abstract Alimento verDetalles(int idAlimento);
    public abstract void seleccionarAlimento(int idAlimento, int cantidad, String observacion);
    public abstract void ingresarComentario(String comentario);
    public abstract void ingresarFoto(Blob imagen);
    public abstract void ingresarPuntaje (int puntaje);
    public abstract void ingresarDatos(String nombre, String comentario);
    public abstract List<Plato> listarPlatos();
    public abstract List<Bebida> listarBebidas();
    public abstract List<Categoria> listarCategoria();
}
