/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication33;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 */
public class AccesoBBDD {

    /**
     * @param jcb
     * @param args the command line arguments
     */
    private static Connection devuelveConexion() {
        Connection con = null;
        //aqui tienes que realizar la conexion a tu bbdd
        return con;
    }

    public static void rellenaDepartamentos() {

        try {
            Connection con = devuelveConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from dep");
            StringBuilder sb = new StringBuilder();
            while (rs.next()){
                sb.append(rs.getObject("depno"));
                sb.append(" ");
                sb.append(rs.getObject("dnombre"));
                sb.append(" ");
                sb.append(rs.getObject("ciudad"));
                GUIPrincipal.listaDepartamentos.addItem(sb.toString());
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void rellenaEmpleados(String numDepartamento){
        try {
            Connection con = devuelveConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from emp where deptno = "+numDepartamento);
            StringBuilder sb = new StringBuilder();
            while (rs.next()){
                sb.append(rs.getObject("empno"));
                sb.append(" ");
                sb.append(rs.getObject("apellido"));
                sb.append(" ");
                sb.append(rs.getObject("fechalta"));
                GUIPrincipal.listaEmpleados.addItem(sb.toString());
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void rellenaTareas(String numEmpleado){
        try {
            Connection con = devuelveConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select mas complejo que devuelva los datos de este empleado "+numEmpleado);
            GUIPrincipal.jTextArea1.append("NUMERO      NOMBRE      HORAS\n");
            GUIPrincipal.jTextArea1.append("===============================\n");
            StringBuilder sb = new StringBuilder();
            while (rs.next()){
                /*
                Aqui hay que ir construyendo un String a partir de la consulta como 
                en los casos anteriores y meterselo con append
                al jTextArea1 de la interfaz grafica
                */
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
