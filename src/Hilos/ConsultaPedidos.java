/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Logica.Pedidos;
import Persistencia.Conexion;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author vanessa
 */
public class ConsultaPedidos extends Thread {
        boolean cambiar = false;
        JButton[] arregloBotones;
        
        @Override
    public void run (){
        //le puse un ciclo infinito para que desde que se abre la ventana de atención
        //quede consultando los pedidos, esto se termina cuando se cierra el hilo
        //que sería antes de que se cierre la ventana atención
        while (true){
            String QUERY = "SELECT p.* "
                    + "FROM pedidos  p, mesa where p.mesa_id=mesa.id";
            EntityManager em = Conexion.getInstance().getEntity();
            List<Pedidos> ret = new ArrayList<Pedidos>();
            em.getTransaction().begin();
            try {
                ret = em.createNativeQuery(QUERY, Pedidos.class).getResultList();
                em.getTransaction().commit();
            
            } catch (Exception e) {
                System.out.println(e.getMessage());
                em.getTransaction().rollback();
            }
            if (ret.size()>0){
                //System.out.println("hay pedidos");
//                for (int j=0; j<ret.size(); j++){
//                    Pedidos p = (Pedidos) ret.get(j);
//                    
//                    System.out.println("id: "+p.getId());
//                }

                for(int i=0; i<ret.size();i++){
                    Pedidos p = (Pedidos) ret.get(i);
                    for(int j=0; j<arregloBotones.length;j++){
                        String nombreBoton = "btnMesa" + p.getMesa().getNumeroMesa();
                        if (nombreBoton.compareTo(arregloBotones[j].getName()) == 0){
                            JButton botonx = (JButton) arregloBotones[j];
                            //botonx.setBackground(Color.green);
                            System.out.println("Datos "+j);
                            System.out.println("en el arreglo "+arregloBotones[j].getName());
                            System.out.println("nombrebtn "+nombreBoton);
                            ConsultaPedidos hilo_auxiliar = new ConsultaPedidos();
                            hilo_auxiliar.temporizador(botonx);
                            //temporizador(botonx);
                        }
                    }
                }
            }else{
                System.out.println("No hay pedidos pendientes");
            }
            
            try {
                sleep(30 * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsultaPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void conocerBotones(JButton[] arreglo){
        this.arregloBotones = arreglo;
    }
    
    public void temporizador(JButton b){
        Timer timer;
        TimerTask tarea;
        int parpadeo = 1000;
        
        tarea = new TimerTask(){
            @Override
            public void run() {
                 if(cambiar){
                    ImageIcon icon = new ImageIcon("img/Mesa con pedido 1.png");
                    b.setIcon(icon);
                    cambiar =false;
                }else{
                    ImageIcon icon = new ImageIcon("img/Mesa con pedido 2.png");
                    b.setIcon(icon);
                    cambiar =true;
                }
            }
        };
        timer = new Timer();
        
        timer.scheduleAtFixedRate(tarea, 0, parpadeo);
    }//termina la funcion temporizador
}//termina la clase
