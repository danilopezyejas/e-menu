/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Component;

/**
 *
 * @author Danilo
 */
public class e_menu extends javax.swing.JFrame {

    AltaMesa am = null;
    AltaPersonal ap = null;
    
    public e_menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void centrarInternal(javax.swing.JInternalFrame o) {
        int x = this.panel.getWidth() / 2 - o.getWidth() / 2;
        int y = this.panel.getHeight() / 2 - o.getHeight() / 2;
        if (this.panel.isShowing()) {
            o.setLocation(x, y);
        }
    }
    
    public void bloquearFondo() {
        personal.setEnabled(false);
        alimentos.setEnabled(false);
        mesa.setEnabled(false);
    }
    
    public void desbloquearFondo() {
        personal.setEnabled(true);
        alimentos.setEnabled(true);
        mesa.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        personal = new javax.swing.JMenu();
        alta_personal = new javax.swing.JMenuItem();
        consulta_personal = new javax.swing.JMenuItem();
        modificacion_personal = new javax.swing.JMenuItem();
        baja_personal = new javax.swing.JMenuItem();
        alimentos = new javax.swing.JMenu();
        alta_alimento = new javax.swing.JMenuItem();
        consulta_alimento = new javax.swing.JMenuItem();
        modificacion_alimento = new javax.swing.JMenuItem();
        baja_alimento = new javax.swing.JMenuItem();
        mesa = new javax.swing.JMenu();
        alta_mesa = new javax.swing.JMenuItem();
        consulta_mesa = new javax.swing.JMenuItem();
        baja_mesa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );

        personal.setText("Personal");

        alta_personal.setText("Alta");
        alta_personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alta_personalActionPerformed(evt);
            }
        });
        personal.add(alta_personal);

        consulta_personal.setText("Consulta");
        personal.add(consulta_personal);

        modificacion_personal.setText("Modificacion");
        personal.add(modificacion_personal);

        baja_personal.setText("Baja");
        personal.add(baja_personal);

        jMenuBar1.add(personal);

        alimentos.setText("Alimentos");

        alta_alimento.setText("Alta");
        alimentos.add(alta_alimento);

        consulta_alimento.setText("Consulta");
        alimentos.add(consulta_alimento);

        modificacion_alimento.setText("Modificacion");
        alimentos.add(modificacion_alimento);

        baja_alimento.setText("Baja");
        alimentos.add(baja_alimento);

        jMenuBar1.add(alimentos);

        mesa.setText("Mesa");

        alta_mesa.setText("Alta");
        alta_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alta_mesaActionPerformed(evt);
            }
        });
        mesa.add(alta_mesa);

        consulta_mesa.setText("Consulta");
        mesa.add(consulta_mesa);

        baja_mesa.setText("Baja");
        mesa.add(baja_mesa);

        jMenuBar1.add(mesa);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alta_personalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alta_personalActionPerformed
        AltaPersonal ap = new AltaPersonal();
        this.ap = ap;
        panel.add(ap);
        ap.setVisible(true);
        bloquearFondo();
        centrarInternal(ap);
    }//GEN-LAST:event_alta_personalActionPerformed

    private void alta_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alta_mesaActionPerformed
        AltaMesa am = new AltaMesa();
        this.am = am;
        panel.add(am);
        am.setVisible(true);
        bloquearFondo();
        centrarInternal(am);
    }//GEN-LAST:event_alta_mesaActionPerformed

    
    void ejecutarPanel(javax.swing.JInternalFrame o){
        
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
            java.util.logging.Logger.getLogger(e_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(e_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(e_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(e_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new e_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu alimentos;
    private javax.swing.JMenuItem alta_alimento;
    private javax.swing.JMenuItem alta_mesa;
    private javax.swing.JMenuItem alta_personal;
    private javax.swing.JMenuItem baja_alimento;
    private javax.swing.JMenuItem baja_mesa;
    private javax.swing.JMenuItem baja_personal;
    private javax.swing.JMenuItem consulta_alimento;
    private javax.swing.JMenuItem consulta_mesa;
    private javax.swing.JMenuItem consulta_personal;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mesa;
    private javax.swing.JMenuItem modificacion_alimento;
    private javax.swing.JMenuItem modificacion_personal;
    private javax.swing.JDesktopPane panel;
    private javax.swing.JMenu personal;
    // End of variables declaration//GEN-END:variables
}
