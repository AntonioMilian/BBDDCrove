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

        } catch (SQLException ex) {
            Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
