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
                sb.append(rs.getString("depno"));
                sb.append(" ");
                sb.append(rs.getString("dnombre"));
                sb.append(" ");
                sb.append(rs.getString("ciudad"));
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
                sb.append(rs.getString("empno"));
                sb.append(" ");
                sb.append(rs.getString("apellido"));
                sb.append(" ");
                sb.append(rs.getString("fechalta"));
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
            ResultSet rs = st.executeQuery("select P.proyeno, P.nombre, T.horas "
                    + "from proyecto P, trabaja T "
                    + "where P.proyecno=T.proyecno and T.empno = "+numEmpleado);
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
