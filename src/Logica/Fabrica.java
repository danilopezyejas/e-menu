/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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
    
    
}
