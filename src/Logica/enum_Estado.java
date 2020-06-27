/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author vanessa
 */
public enum enum_Estado {
    Pendiente, Activo, Pagar,Finalizado, Cancelado
}
//Cuando el cliente realiza un pedido y el mozo no lo a aceptado esta en PENDIENTE
//Cuando el mozo acepto el pedido y el cliente esta esperando que le lleven la comida esta en ACTIVO
//Cuando el mozo le llevo el pedido al cliente el estado es FINALIZADO