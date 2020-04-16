/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Controladores_Interfaces.IPersonalController;
import Controladores_Interfaces.PersonalController;
import Logica.Fabrica;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Danilo
 */
public class ConsultaPersonal extends javax.swing.JInternalFrame {
    IPersonalController personaContoler;
    DefaultTableModel md; 
    String data[][]={};
    String columnas[]={"Nombre","Apellido","Cedula"};
    public ConsultaPersonal() {
        initComponents();
        personaContoler = Fabrica.getInstancia().getPersonaController();
        
        md=new DefaultTableModel(data,columnas);
        Table.setModel(md);
        //placeholder
        String datos[]={"Luis","Guariglia","52628206"};
        md.addRow(datos);
        //
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        jColorChooser1 = new javax.swing.JColorChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        button2 = new java.awt.Button();
        eliminar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        modificar = new javax.swing.JButton();

        button1.setLabel("button1");

        jFormattedTextField1.setText("jFormattedTextField1");

        button2.setLabel("button2");

        setResizable(true);
        setTitle("Lista del Personal");

        eliminar.setBackground(new java.awt.Color(216, 30, 30));
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(Table);

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salir)
                    .addComponent(eliminar)
                    .addComponent(modificar))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        /*String nombre = jNombre.getText();
        String apellido = jApellido.getText();
        String ciString = jCedula.getText();
        int ci;
        if(ciString.equals("")||nombre.equals("")||apellido.equals("")){
             JOptionPane.showMessageDialog(null,"Datos Incorrectos");
        }else{
            ci=Integer.parseInt(ciString);
            personaContoler.altaPersonal(nombre, apellido, ci);           
        }*/
                
    }//GEN-LAST:event_eliminarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        salir();
    }//GEN-LAST:event_salirActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarActionPerformed

    void salir(){
        e_menu m = (e_menu) this.getTopLevelAncestor();
        m.desbloquearFondo();
        this.dispose();
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JButton eliminar;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
