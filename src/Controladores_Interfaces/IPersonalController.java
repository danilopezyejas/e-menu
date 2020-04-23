/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores_Interfaces;

import Logica.Personal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisg
 */
public interface IPersonalController {
    public abstract void altaPersonal(String nombre,String apellido,int cedula);
    public abstract List<Personal> listarPersonal();
    public abstract void seleccionarPersonal(int idPersonal);
    public abstract void modificarPersonal(Personal personal);
    public abstract void eliminarPersonal(Personal personal);
    public abstract void ingresarDatosPersonal(String nombre, String apellido, String ci);
}
