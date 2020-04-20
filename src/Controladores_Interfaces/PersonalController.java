/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores_Interfaces;

import Logica.Personal;
import Persistencia.Conexion;
import java.util.ArrayList;

/**
 *
 * @author luisg
 */
public class PersonalController implements IPersonalController{
    ArrayList<Personal> personal = new ArrayList<Personal>();
    //singleton
    private PersonalController() {
    } 
    public static PersonalController getInstance() {
        return PersonalControllerHolder.INSTANCE;
    } 
    private static class PersonalControllerHolder {
        private static final PersonalController INSTANCE = new PersonalController();
    }
    //fin singleton
    
    //funcion de la interface
    @Override
    public void altaPersonal(String nombre,String apellido,int cedula){
        Personal per=new Personal(nombre,apellido,cedula);
        personal.add(per);
        Conexion.getInstance().alta(per);
        System.out.print("se dio de alta personal nombre"+nombre);
    }
}
