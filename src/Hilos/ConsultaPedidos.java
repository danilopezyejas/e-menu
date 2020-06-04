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
            String QUERY = "SELECT * FROM pedidos INNER JOIN Mesa on pedidos.mesa_id=Mesa.id";
            EntityManager em = Conexion.getInstance().getEntity();
            List<Pedidos> ret = em.createQuery(QUERY, Pedidos.class).getResultList();

            for(int i=0; i<arregloBotones.length;i=i+2){
                Pedidos p = new Pedidos();//(Pedidos) ret.get(i);
                p.setFecha_hora(new Date());
                JButton botonx = (JButton) arregloBotones[i];
                temporizador(botonx);
            }
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsultaPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void conocerBotones(JButton[] arreglo){
        this.arregloBotones = arreglo;
    }
    
    void temporizador(JButton b){
        Timer timer;
        TimerTask tarea;
        int parpadeo = 5000;
        
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
