/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Logica.Pedidos;
import Persistencia.Conexion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JButton;

/**
 *
 * @author vanessa
 */
public class ConsultaPedidos extends Thread {
    
    public void run (){
        //le puse un ciclo infinito para que desde que se abre la ventana de atención
        //quede consultando los pedidos, esto se termina cuando se cierra el hilo 
        //que sería antes de que se cierre la ventana atención
        while (true){
            String QUERY = "select pedidos.id, pedidos.alimentos_cantidad, pedidos.estado, pedidos.mesa_id"
                    + " from pedidos inner join mesa on mesa_id=mesa.id";
            EntityManager em = Conexion.getInstance().getEntity();
            List<Pedidos> ret = em.createQuery(QUERY, Pedidos.class).getResultList();

            //JButton boton = new JButton();
            for(int i=0; i<ret.size();i++){
                Pedidos p = (Pedidos) ret.get(i);
                System.out.println("pedido:" + p.getId());
            }
            
            try {
                //cada 30 segundos vuelve a consultar la base
                sleep(30*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsultaPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Pedidos> cargarPedidosPendientes(){
        String QUERY = "Select * from pedidos where estado=0";
        EntityManager em = Conexion.getInstance().getEntity();
        List<Pedidos> ret = em.createQuery(QUERY, Pedidos.class).getResultList();
        return ret;
    }
}
