/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores_Interfaces;

/**
 *
 * @author luisg
 */
public interface IAlimentoController {
    public void altaPlato(String nom,float pre,String ingred,String desc,int cal);
    public void altaBebida(String nom,float pre,String ingred,String desc,int cant); //falta tipo
}
