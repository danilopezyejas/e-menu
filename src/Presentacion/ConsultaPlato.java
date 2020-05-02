/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Controladores_Interfaces.IAlimentoController;
import Logica.Bebida;
import Logica.Fabrica;
import Logica.Plato;
import java.awt.Container;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Danilo
 */
public class ConsultaPlato extends javax.swing.JInternalFrame {
    boolean comida=true;
    IAlimentoController platoController;
    DefaultTableModel md; 
    String data[][]={};
    
    public ConsultaPlato() {
        initComponents();
        platoController = Fabrica.getInstancia().getAlimentoController();
        cargarPlatos();
        
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
        jToggleButton1 = new javax.swing.JToggleButton();
        eliminar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        modificar = new javax.swing.JButton();
        Platos = new javax.swing.JButton();
        Bebidas = new javax.swing.JButton();

        button1.setLabel("button1");

        jFormattedTextField1.setText("jFormattedTextField1");

        button2.setLabel("button2");

        jToggleButton1.setText("jToggleButton1");

        setResizable(true);
        setTitle("Lista del Alimentos");

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

        Platos.setText("Platos");
        Platos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlatosActionPerformed(evt);
            }
        });

        Bebidas.setText("Bebidas");
        Bebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BebidasActionPerformed(evt);
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
                        .addComponent(Platos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bebidas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Platos)
                    .addComponent(Bebidas))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salir)
                    .addComponent(eliminar)
                    .addComponent(modificar))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cargarPlatos(){
        String columnas[]={"Id","Nombre","Precio","TiempoPrep","Activo","Ingredientes","Calorias"};
        md=new DefaultTableModel(data,columnas);
        Table.setModel(md);
        //lleno la tabla
        List<Plato> per = platoController.listarPlatos();
        for(Plato aux : per){ 
            String datos[]={String.valueOf(aux.getId()),
                aux.getNombre(),
                String.valueOf(aux.getPrecio()),
                String.valueOf(aux.getTiempoPreparacion()),
                String.valueOf(aux.isActivo()),
                aux.getIngredientes(),
                String.valueOf(aux.getCalorias())
            };
            md.addRow(datos);
        }
        //
    }
    private void cargarBebidas(){ 
        String columnas[]={"Id","Nombre","Precio","TiempoPrep","Activo","Ingredientes","Contenido","Tipo"};
        md=new DefaultTableModel(data,columnas);
        Table.setModel(md);
        //lleno la tabla
        List<Bebida> per = platoController.listarBebidas();
        for(Bebida aux : per){ 
            String datos[]={String.valueOf(aux.getId()),
                aux.getNombre(),
                String.valueOf(aux.getPrecio()),
                String.valueOf(aux.getTiempoPreparacion()),
                String.valueOf(aux.isActivo()),
                aux.getIngredientes(),
                String.valueOf(aux.getCantidad()),
                String.valueOf(aux.getTipo())
            };
            md.addRow(datos);
        }
        //
    }
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
        e_menu menu = (e_menu) this.getTopLevelAncestor();
        
        if(comida){
            int[] seleccionados = this.Table.getSelectedRows();
           
            if(seleccionados.length == 1){
                String nombre = (String) this.Table.getValueAt(0, 1);
                String precio = (String) this.Table.getValueAt(0, 2);
                String demora = (String) this.Table.getValueAt(0, 3);
                String ingredientes = (String) this.Table.getValueAt(0, 4);
                String calorias = (String) this.Table.getValueAt(0, 5);
                String[] datos = {nombre,precio,demora,ingredientes,calorias};
//                AltaAlimento aa = new AltaAlimento(comida);
//                menu.add(aa);
//                this.setVisible(false);
//                aa.setVisible(true);
//                mandarAlFrente(aa);
//                menu.centrarInternal(aa);
            }else{
                
            }
        }else{
            
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void BebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BebidasActionPerformed
        this.comida=false;
        cargarBebidas();
    }//GEN-LAST:event_BebidasActionPerformed

    private void PlatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlatosActionPerformed
         this.comida=true;
         cargarPlatos();
    }//GEN-LAST:event_PlatosActionPerformed

    void salir(){
        e_menu m = (e_menu) this.getTopLevelAncestor();
        m.desbloquearFondo();
        this.dispose();
    }
    
    void mandarAlFrente(javax.swing.JInternalFrame obj){
        Container parent = obj.getParent();
        synchronized (parent.getTreeLock()) {
            parent.setComponentZOrder(obj, 0);  //Para que se muestre por arriba de lo demas
        }
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bebidas;
    private javax.swing.JButton Platos;
    private javax.swing.JTable Table;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JButton eliminar;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton modificar;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
