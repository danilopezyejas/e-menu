/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Logica.Pedidos;
import Logica.enum_Estado;
import Persistencia.Conexion;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author vanessa
 */
public class ConsultaPedidos extends Thread {

    boolean cambiar = false;
    JButton[] arregloBotones;
    EntityManager em = Conexion.getInstance().getEntity();
    List<Pedidos> ret = null;
    //ConsultaPedidos hilo_auxiliar = null;

    @Override
    public void run() {
        boolean consulta = true;
        //le puse un ciclo infinito para que desde que se abre la ventana de atención
        //quede consultando los pedidos, esto se termina cuando se cierra el hilo
        //que sería antes de que se cierre la ventana atención
        while (consulta) {
            for (int j = 0; j < arregloBotones.length; j++) {
                JButton botonx = (JButton) arregloBotones[j];
                botonx.setText(botonx.getName().replace("btnMesa", ""));
                Font fuenteBotonx = new Font(botonx.getFont().getName(),botonx.getFont().getStyle(), (botonx.getHeight()/3));
                botonx.setFont(fuenteBotonx);
                botonx.setHorizontalAlignment(SwingConstants.CENTER);
                botonx.setHorizontalTextPosition(SwingConstants.CENTER);
                botonx.setVerticalAlignment(SwingConstants.CENTER);
                botonx.setVerticalTextPosition(SwingConstants.CENTER);
                ImageIcon icon = new ImageIcon (new ImageIcon("img/mesa_Libre.png").getImage().getScaledInstance(botonx.getHeight()-20, botonx.getHeight()-20, Image.SCALE_DEFAULT));
                botonx.setIcon(icon);
            }
            String QUERY = "SELECT p.* "
                    + "FROM pedidos  p, mesa where p.mesa_id=mesa.id";
            em.getTransaction().begin();
            try {
                ret = em.createNativeQuery(QUERY, Pedidos.class).getResultList();
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                em.getTransaction().rollback();
                break;
            }

            if (ret.size() > 0) {
                for (int j = 0; j < arregloBotones.length; j++) {
                    for (int i = 0; i < ret.size(); i++) {
                        Pedidos p = (Pedidos) ret.get(i);
                        em.refresh(p);
                        String nombreBoton = "btnMesa" + p.getMesa().getNumeroMesa();
                        if (nombreBoton.compareTo(arregloBotones[j].getName()) == 0) {
                            JButton botonx = (JButton) arregloBotones[j];
                            if (p.getEstado().equals(enum_Estado.Pendiente)) {
                                ImageIcon icon = new ImageIcon (new ImageIcon("img/mesa_ConPedido.gif").getImage().getScaledInstance(botonx.getHeight()-20, botonx.getHeight()-20, Image.SCALE_DEFAULT));
//                                 Image aux = new ImageIcon(fotoPerfil).getImage();
//            ImageIcon perfil = new ImageIcon(aux.getScaledInstance(150, 189, Image.SCALE_DEFAULT));
                                botonx.setIcon(icon);
                            } else if (p.getEstado().equals(enum_Estado.Activo)) {
                                //ImageIcon icon = new ImageIcon("img/mesa_Atendida.png");
                                ImageIcon icon = new ImageIcon (new ImageIcon("img/mesa_Atendida.png").getImage().getScaledInstance(botonx.getHeight()-20, botonx.getHeight()-20, Image.SCALE_DEFAULT));
                                botonx.setIcon(icon);
                                //hilo_auxiliar.stop();
                                //hilo_auxiliar.interrupt();
                                //terminarHilo(hilo_auxiliar);
                                //break;
                            }
                             else if (p.getEstado().equals(enum_Estado.Pagar)) {
                                ImageIcon icon = new ImageIcon (new ImageIcon("img/mesa_Pagar.png").getImage().getScaledInstance(botonx.getHeight()-20, botonx.getHeight()-20, Image.SCALE_DEFAULT));
                                botonx.setIcon(icon);
                            }else if (p.getEstado().equals(enum_Estado.Cancelado)) {
                                //hilo_auxiliar.stop();
                                //ImageIcon icon = new ImageIcon("img/mesa_Libre.png");
                                ImageIcon icon = new ImageIcon (new ImageIcon("img/mesa_Libre.png").getImage().getScaledInstance(botonx.getHeight()-20, botonx.getHeight()-20, Image.SCALE_DEFAULT));
                                botonx.setIcon(icon);
                                //hilo_auxiliar.interrupt();
                                //terminarHilo(hilo_auxiliar);
//                                break;
                            } else if (p.getEstado().equals(enum_Estado.Finalizado)) {
                                //hilo_auxiliar.stop();
                                //ImageIcon icon = new ImageIcon("img/mesa_Libre.png");
                                ImageIcon icon = new ImageIcon (new ImageIcon("img/mesa_Libre.png").getImage().getScaledInstance(botonx.getHeight()-20, botonx.getHeight()-20, Image.SCALE_DEFAULT));
                                botonx.setIcon(icon);
                                //hilo_auxiliar.interrupt();
                                //terminarHilo(hilo_auxiliar);
//                                break;
                            } else {
                                //hilo_auxiliar.stop();
                                //ImageIcon icon = new ImageIcon("img/mesa_Libre.png");
                                ImageIcon icon = new ImageIcon (new ImageIcon("img/mesa_Libre.png").getImage().getScaledInstance(botonx.getHeight()-20, botonx.getHeight()-20, Image.SCALE_DEFAULT));
                                botonx.setIcon(icon);
                                //hilo_auxiliar.interrupt();
                                //terminarHilo(hilo_auxiliar);
//                                break;
                            }
                        }
                    }
                }
            } else {
                System.out.println("No hay pedidos");
            }

            try {
                ConsultaPedidos.sleep(30000);
            } catch (InterruptedException ex) {
                consulta = false;
                System.out.println(ex.getMessage());
                Logger.getLogger(ConsultaPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void conocerBotones(JButton[] arreglo) {
        this.arregloBotones = arreglo;
    }
}//termina la clase
