/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Controladores_Interfaces.ictrl_Pedido;
import Logica.Fabrica;
import Logica.Mesa;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danilo
 */
public class AltaMesa extends javax.swing.JInternalFrame {

    private static final int qrTamAncho = 4000;
    private static final int qrTamAlto = 4000;
    private static final String formato = "png";
    private static final String ruta = "../qr/CodigoQR_Mesa_";
    private static final String pagina = "www.e-menu.com.uy/";
    DefaultTableModel md; 
    ictrl_Pedido controladorPedido = Fabrica.getInstancia().getPedidoController();
    List<Mesa> mesas;
    
    public AltaMesa() {
        initComponents();
        cargarTabla();
    }
    
    void cargarTabla(){
        String data[][]={};
        String columnas[]={"Id","Numero"};
        md = new DefaultTableModel(data,columnas);
        tabla.setModel(md);
        this.mesas = this.controladorPedido.listarMesas();

        for(Mesa aux : this.mesas){
            String datos[]={
                String.valueOf(aux.getId()),
                String.valueOf(aux.getNumeroMesa())
            };
            md.addRow(datos);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        mesa = new javax.swing.JComboBox<>();
        generar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();

        setTitle("Alta mesa");

        jLabel1.setText("Seleccione la mesa:");

        mesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        generar.setText("Agregar");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Numero"
            }
        ));
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(1).setResizable(false);
        }

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(103, 103, 103)
                        .addComponent(mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64)
                            .addComponent(btnEliminar)
                            .addGap(64, 64, 64)
                            .addComponent(generar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salir)
                    .addComponent(generar)
                    .addComponent(btnEliminar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed

        boolean existe = false;
//GENERO EL CODIGO QR
        BitMatrix matriz = null;
        Writer writer = new QRCodeWriter();
        String numMesa = mesa.getSelectedItem().toString();
        for(Mesa aux : this.mesas){
            if(aux.getNumeroMesa() == Integer.parseInt(numMesa)){
                existe = true;
                break;
            }
        }
        if(!existe){
            try{
                matriz = writer.encode(pagina + numMesa, BarcodeFormat.QR_CODE, qrTamAlto, qrTamAlto);
            }catch(WriterException e){
                e.printStackTrace();
            }
            BufferedImage imagen = new BufferedImage(qrTamAlto,qrTamAlto,BufferedImage.TYPE_INT_RGB);
            for(int x = 0; x < qrTamAlto; x++){
                for(int y = 0; y < qrTamAncho; y++){
                    int valor = (matriz.get(x,y) ? 0 : 1) & 0xff;
                    imagen.setRGB(x, y, (valor == 0 ? 0 : 0xFF0000));
                }
            }

    //CREO EL ARCHIVO DEL CODIGO Y LO GUARDO EN LA ruta
            FileOutputStream codigo;
            try {
                codigo = new FileOutputStream(ruta+numMesa+"."+formato);
                ImageIO.write(imagen, formato, codigo);
                codigo.close();
                
                mesa.setSelectedIndex(0);
            } catch (IOException ex) {
                Logger.getLogger(AltaMesa.class.getName()).log(Level.SEVERE, null, ex);
            }

    //GUARDO LA IMAGEN Y EL NUMERO DE MESA EN LA BASE DE DATOS
        byte[] imagenEnByte = null;
        try{		
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write( imagen, formato, baos );
            baos.flush();
            imagenEnByte = baos.toByteArray();
            baos.close();

            }catch(IOException e){
                    System.out.println(e.getMessage());
            }

            Blob blobData = null;
            try {
                blobData = new SerialBlob(imagenEnByte);
            } catch (SQLException ex) {
                Logger.getLogger(AltaMesa.class.getName()).log(Level.SEVERE, null, ex);
            }
            Mesa mesa = new Mesa(Integer.parseInt(numMesa),blobData);
            controladorPedido.altaMesa(mesa);
            JOptionPane.showMessageDialog(null, "Mesa " + numMesa + " creada correctamente.");
            cargarTabla();
        }else{
            JOptionPane.showMessageDialog(null, "La mesa que quiere crear ya existe.");
        }
    }//GEN-LAST:event_generarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        salir();
    }//GEN-LAST:event_salirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int[] seleccionadas = this.tabla.getSelectedRows();
        
        if(seleccionadas.length > 0){
            for(int i = 0; i < seleccionadas.length; i++ ){
                int id = Integer.parseInt(this.tabla.getValueAt(seleccionadas[i], 0).toString());
                controladorPedido.bajaMesa(id);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una mesa.");
        }
        cargarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    void salir(){
        e_menu m = (e_menu) this.getTopLevelAncestor();
        m.desbloquearFondo();
        this.dispose();
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton generar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> mesa;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
