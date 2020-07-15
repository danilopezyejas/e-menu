/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores_Interfaces;

import Logica.Personal;
import Persistencia.Conexion;
import java.util.ArrayList;
import java.util.List;
import Logica.Error;
import javax.persistence.EntityManager;

/**
 *
 * @author luisg
 */
public class PersonalController implements IPersonalController{
    ArrayList<Personal> personal = new ArrayList<Personal>();
    //singleton
    private PersonalController() {
    } 
    public static PersonalController getInstance() {
        return PersonalControllerHolder.INSTANCE;
    } 

    @Override
    public Personal buscarPersonal(String ci) {
        EntityManager em = Conexion.getInstance().getEntity();
        Personal p = null;
        em.getTransaction().begin();
        try {
            p = (Personal) em.createNativeQuery("SELECT * FROM personal WHERE cedula=" + ci, Personal.class).getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return p;
    }

    @Override
    public void modificarPersonal(Personal personal) {
        Conexion.getInstance().modificar(personal);
    }

    @Override
    public void bajaPersonal(String ci) {
        Personal personal = buscarPersonal(ci);
        personal.setBorrada(true);
        Conexion.getInstance().modificar(personal);
    }

    @Override
    public void ingresarDatosPersonal(String nombre, String apellido, String ci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static class PersonalControllerHolder {
        private static final PersonalController INSTANCE = new PersonalController();
    }
    //fin singleton
    
    //funcion de la interface
    @Override
    public void altaPersonal(String nombre,String apellido,String cedula){
        Personal per=new Personal(nombre, apellido, cedula);
        personal.add(per);
        Conexion.getInstance().alta(per);
    }
    @Override
    public List<Personal> listarPersonal(){
        List<Personal> ret = Conexion.getInstance().consultarPersonal();
        return ret;
    }
    
        public boolean isValid(final String ci) {
        final int MINIMO_DIGITOS = 7;
        final String ciFixed;
        if (ci.length() <= MINIMO_DIGITOS) {
          //El algoritmo esta hecho para 8 dígitos, se completa con 0 las cédulas de 7 dígitos o menos
          final String DEFAULT_DIGITOS_FORMAT = "%08d";
          ciFixed = String.format(DEFAULT_DIGITOS_FORMAT, Integer.parseInt(ci));
        } else {
          ciFixed = ci;
        }
        final int ciNumeric[] = new int[ciFixed.length()];
        for (int i = 0; i < 8; i++) {
          ciNumeric[i] = Character.getNumericValue(ciFixed.charAt(i));
        }
        final int digitoOriginal = ciNumeric[ciNumeric.length - 1];
        final int[] COEFICIENTES_ALGORITMO = {2, 9, 8, 7, 6, 3, 4};
        int suma = 0;
        for (int i = 0; i < 7; i++) {
          suma += ciNumeric[i] * COEFICIENTES_ALGORITMO[i] % 10;
        }
        final int digitoCalculado;
        if (suma % 10 == 0) {
          digitoCalculado = 0;
        } else {
          digitoCalculado = 10 - suma % 10;
        }
    return digitoOriginal == digitoCalculado;
    }
  
    @Override
    public void ComprobarDatos(String nombre,String apellido,String cedula) throws Error{
        if(nombre.equals("")){
            throw new Error("No ingreso el nombre.");
        }
        if(apellido.equals("")){
            throw new Error("No ingreso el apellido.");
        }
        if(!isValid(cedula)){
            throw new Error("La cedula no es valida.");
        }
        StackTraceElement[] elemento = Thread.currentThread().getStackTrace();
        String accion = elemento[2].getMethodName();
        if(accion.equals("aceptarActionPerformed")){
            if(buscarPersonal(cedula) != null){
                throw new Error("Ya se a registrado una persona con el mismo numero de cedula.");
            }
        }
    }
    
    public Personal buscarPersonalPorId(int id) {
        EntityManager em = Conexion.getInstance().getEntity();
        Personal p = null;
        em.getTransaction().begin();
        try {
            p = (Personal) em.createNativeQuery("SELECT * FROM personal WHERE id=" + id, Personal.class).getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return p;
    }
}
