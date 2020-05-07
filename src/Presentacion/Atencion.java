/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Controladores_Interfaces.ictrl_Pedido;
import Logica.Fabrica;
import Logica.Mesa;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Danilo
 */
public class Atencion extends javax.swing.JFrame {

    ictrl_Pedido controladorPedido = Fabrica.getInstancia().getPedidoController();
    static int velocidad = 1;
    static int cerrar = Atencion.DO_NOTHING_ON_CLOSE;;
    boolean cambiar = false;
    Pedido p = null;
    
    public Atencion() {

    }

    Atencion(e_menu menuPrincipal) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/e_menu.png")).getImage());
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);   //Para que se ejecute maximisado 
        Atencion atencion = this;
        cargarMesas();
        
        this.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        int result = JOptionPane.showConfirmDialog(
                                null, "Quiere salir del modo Atencion?");
                        if( result==JOptionPane.OK_OPTION){
                            // Cuando cambie se cierra DO_NOTHING_ON_CLOSE = 0 y DISPOSE_ON_CLOSE = 2
                             cerrar = Atencion.DISPOSE_ON_CLOSE;
                        }
                                if(cerrar != 0){
                                    menuPrincipal.desbloquearFondo();
                                    menuPrincipal.setVisible(true);
                                    atencion.dispose();
                                    atencion.setDefaultCloseOperation(cerrar);
                                }
                    }
                });
    }
    
    public void cargarMesas(){
        int anchoBoton = 100;
        int altoBoton = 100;
        int separacionVertical = 50;
        int separacionHorizontal;
        int anchoPanel = this.panel.getWidth();
        int altoPanel = this.panel.getHeight();
        int posicionHorizontal = 0;
        int posicionVertical = 0;
        int cantMesas = 0;
        List<Mesa> mesas = controladorPedido.listarMesas();
        
        double resultado = Math.sqrt(mesas.size()); //Con la raiz cuadrada se cuantas filas necesito si me da un numero redondo
        int filas = (int)Math.ceil(resultado);  //Redondeo el numero para arriba para tener el numero de filas que voy a necesitar
        
        separacionHorizontal = anchoPanel/filas;
        separacionVertical = altoPanel/filas;
        posicionHorizontal = separacionHorizontal;
        posicionVertical = separacionVertical;
        
        for(int j=0; j<filas; j++){
            for(int i=0; i<filas; i++){
                JButton botonNuevo = crearBotonMesa();  //Creo el boton con el icono
                if(i == 0){
                    botonNuevo.setBounds(posicionHorizontal, posicionVertical, anchoBoton, altoBoton);  //Le doy dimenciones y lo posiciono
                }else{
                    botonNuevo.setBounds(posicionHorizontal, posicionVertical += anchoBoton+separacionVertical, anchoBoton, altoBoton); //Le doy dimenciones y lo posiciono
                }
                
                if(cantMesas < mesas.size()){
                    this.panel.add(botonNuevo); //LO agrego al panel si no supere las cantidad de mesas que hay
                }
                cantMesas++;
            }
            
            posicionVertical = separacionVertical;
            posicionHorizontal += anchoBoton+separacionHorizontal;
        }
        

    }
    
    JButton crearBotonMesa(){
        
        JButton botonNuevo = new JButton();
        ImageIcon icon = new ImageIcon("img/Mesa Libre.png");
        botonNuevo.setIcon(icon);
        return botonNuevo;
    }
    
    void temporizador(int numMesa){
        Timer timer;
        TimerTask tarea;
        int parpadeo = velocidad*1000;
        
        tarea = new TimerTask(){
            @Override
            public void run() {
                 if(cambiar){
                    ImageIcon icon = new ImageIcon("img/Mesa con pedido 1.png");
//                    mesa3.setIcon(icon);
                    cambiar =false;
                }else{
                    ImageIcon icon = new ImageIcon("img/Mesa con pedido 2.png");
//                    mesa3.setIcon(icon);
                    cambiar =true;
                }
            }
        };
        timer = new Timer();
        
        timer.scheduleAtFixedRate(tarea, 0, parpadeo);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1327, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void ejecutarPanel(javax.swing.JInternalFrame obj){
        this.panel.add(obj);
        obj.setVisible(true);
        centrarInternal(obj);
        mandarAlFrente(obj);
    }
    
    void mandarAlFrente(javax.swing.JInternalFrame obj){
        Container parent = obj.getParent();
        synchronized (parent.getTreeLock()) {
        parent.setComponentZOrder(obj, 1);  //Para que se muestre por arriba de lo demas
  
    }
    }

    public void centrarInternal(javax.swing.JInternalFrame o) {
        int x = this.panel.getWidth() / 2 - o.getWidth() / 2;
        int y = this.panel.getHeight() / 2 - o.getHeight() / 2;
        if (this.panel.isShowing()) {
            o.setLocation(x, y);
        }
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Atencion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
