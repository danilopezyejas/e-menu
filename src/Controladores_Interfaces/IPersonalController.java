/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores_Interfaces;

import Logica.Personal;
import java.util.List;
import Logica.Error;

/**
 *
 * @author luisg
 */
public interface IPersonalController {
    public abstract void altaPersonal(String nombre,String apellido,String cedula);
    public abstract List<Personal> listarPersonal();
    public abstract Personal buscarPersonal(String idPersonal);
    public abstract void modificarPersonal(Personal personal);
    public abstract void bajaPersonal(String personal);
    public abstract void ingresarDatosPersonal(String nombre, String apellido, String ci);
    public abstract void ComprobarDatos(String nombre,String apellido,String cedula) throws Error;
}
