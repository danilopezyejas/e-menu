/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores_Interfaces;

import Logica.Personal;
import Logica.Plato;
import Logica.enum_Categoria;

/**
 *
 * @author luisg
 */
public class AlimentoController implements IAlimentoController{
    //singleton
    private AlimentoController() {
    } 
    public static AlimentoController getInstance() {
        return PersonalControllerHolder.INSTANCE;
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
        //plato.getPrecio(pre);
        System.out.print("se dio de alta plato nombre"+nom);
    }
}
