import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;

import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fernando
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Connection cnn = null;
        ResultSet datos = null;
        ResultSetMetaData metaDatos = null;
        PreparedStatement statement = null;

        //El usuario con el que nos conectamos al mySql:
        String user = "root";

        //El password del usuario:
        String pass = "admin"; 
        
        //Apuntamos a la base de datos con la que queremos trabajar:        
        String url= "jdbc:mysql://127.0.0.1:3306/world?autoReconnect=true&useSSL=false&serverTimezone=GMT";
        
        String driver = "com.mysql.cj.jdbc.Driver";

        //Variable para cargar las querys:
        String consultaSql = "";

        try {
            Class.forName(driver);
            cnn = DriverManager.getConnection(url, user, pass);

            consultaSql = "SELECT country.name AS 'Pais', "
                    + "country.population AS 'Habitantes' "
                    + "FROM world.country ORDER BY country.name ASC;";
            
            statement = cnn.prepareStatement(consultaSql);

            datos = statement.executeQuery();
            metaDatos = datos.getMetaData();

            int cantRegistros = 0;
            
            //Opcion 2 
            String columnas="";
            for(int i=0; i<metaDatos.getColumnCount(); i++)
            {
                columnas= columnas+metaDatos.getColumnLabel(i+1)+"\t\t";
            }
            System.out.println("columnas");
            
            String unaFila;
            while(datos.next())
                    {
                        unaFila= "";
                        for (int i=0; i<metaDatos.getColumnCount(); i++)
                        {
                            unaFila=unaFila+datos.getString(i+1)+ "\t\t";
                        }
                        System.out.println(unaFila);
                        cantRegistros++;
                    }
            
            

            //Opcion 1:
            /*System.out.println("*** Pais -- Habitantes ***");
            while (datos.next()) {
                System.out.println(datos.getString("Pais") + " -- "
                        + datos.getString("Habitantes"));
                cantRegistros++;
            }*/
            
            System.out.println("");
            System.out.println("Cantidad de registros: " + cantRegistros);

            cnn.close();
        } catch (Exception e) {
            System.out.println("Hubo un error!!");
            System.out.println(e.getMessage());
        }
    }

}
