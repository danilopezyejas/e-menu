/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Controladores_Interfaces.ctrl_Pedido;
import Controladores_Interfaces.ictrl_Pedido;
import Controladores_Interfaces.AlimentoController;
import Controladores_Interfaces.PersonalController;

/**
 *
 * @author Danilo
 */
public class Fabrica {
    
    private Fabrica(){}
    
    public static Fabrica getInstancia(){
        return FabricaHolder.INSTANCIA;
    }
    
    private static class FabricaHolder{
        private static final Fabrica INSTANCIA = new Fabrica();
    }
    
    public ictrl_Pedido getIUserController() {
        ictrl_Pedido interfacePedido = ctrl_Pedido.getInstancia();
        return interfacePedido;
    }
    public PersonalController getPersonaController() {
        PersonalController perController = PersonalController.getInstance();;
        return perController;
    }
    public AlimentoController getAlimentoController() {
        AlimentoController aliController = AlimentoController.getInstance();;
        return aliController;
    }
   
}
