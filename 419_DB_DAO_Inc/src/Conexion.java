import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando
 */

public class Conexion {
    
    /*  La idea es tener una única clase que maneje la conexión a la base de
        datos a utilizar, esto nos facilita el trabajo a la hora de cambiar la
        la persistencia de nuestros datos, solo tendriamos que modificar esta
        clase para apuntar a la memoria ram, a un archivo o a otro gestor de
        bases de datos (Microsoft SQL Server, PostgreSQL etc).
    */
    //Atributo para gestionar la conexión a la base de datos:
    private Connection cnn;
    //Constructor:
    public Conexion() {
    }
    //Método para abrir la conexión:
    public void abrir(){   
        //Usuario y contraseña para conectarme al servidor de bases de datos:
        String user = "root";
        String pass = "admin";
        //Url de conexión para llegar a la base de datos "escuela":
        String url= "jdbc:mysql://127.0.0.1:3306/"
                + "escuela?autoReconnect=true&useSSL=false&serverTimezone=GMT";        
        //Driver de conexión a MySql:
        String driver = "com.mysql.cj.jdbc.Driver";
        
        
        try {
            //Cargo el driver de conexión:
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("NO SE ENCONTRÓ LA CLASE: "+ ex.getMessage());
            System.out.println("CERRANDO EL SISTEMA.");
            System.exit(0);
        }
        try {
            //Inicializo el objeto Conection:
            cnn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("NO SE PUDO REALIZAR LA CONEXIÓN: "+ ex.getMessage());
            System.out.println("CERRANDO EL SISTEMA.");
            System.exit(0);
        }
    }
    
    //Método para cerrar la conexión:
    public void cerrar() throws SQLException {
        cnn.close();
    }
    
    //Getter:
    public Connection getCnn() {
        return cnn;
    }
    
}