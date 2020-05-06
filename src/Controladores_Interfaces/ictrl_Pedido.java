/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores_Interfaces;

import Logica.Mesa;
import Logica.Pedidos;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface ictrl_Pedido {
    public abstract void confirmarPedido(String contra);
    public abstract boolean escanearCodigo(int idMesa);
    public abstract float solicitarPago(int idMesa);
    public abstract HashMap<String, String> listarCategorias();
    public abstract void confirmarPedido(int tipo_pago);
    public abstract boolean pagar();
    public abstract boolean realizarReclamo(String reclamo);
    public abstract void bajaMesa(int idMesa);
    public abstract List<Mesa> listarMesas();
    public abstract void altaMesa(Mesa mesa);
    public abstract Pedidos consultaPedidoMesa(int idMesa);
    public abstract void agregarObservacion(String observacion);
}