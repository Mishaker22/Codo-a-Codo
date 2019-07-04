import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando
 */
public class AlumnoDaoImpl implements AlumnoDao{
    /*  En esta clase definiremos como se implementan los métodos CRUD (crear
        leer, actualizar y borrar).
    */
    //Atributo de tipo Conexion:
    private Conexion conexion;
    
    public AlumnoDaoImpl() {
        
        //Creo una nueva conexión:
        conexion = new Conexion();
    }
    //Implemento el método abstracto obtenerTodos:
    @Override
    public List<Alumno> obtenerAlumnos() {
        //Creo una lista de alumnos:
        List<Alumno> listaAlumnos = new ArrayList<Alumno>();
        this.conexion.abrir();
        try {
            //Escribo la consulta SQL para seleccionar a todos los alumnos
            //de la tabla "alumnos":
            String sql = "SELECT * FROM alumnos";
            //Creo un objeto de tipo PreparedStatement:
            PreparedStatement statement = null;
            //Lo inicializo con los datos de la conexión y la consulta SQL:
            statement= this.conexion.getCnn().prepareStatement(sql);
            //Realizo la consulta y guardo los datos devueltos en un objeto
            //de tipo ResultSet:
            ResultSet datos = statement.executeQuery();
            //Para cada una de las filas del ResultSet, creo un objeto Alumno
            //con los atributos recibidos y lo agrego a la lista de alumnos:
            while(datos.next()){
                Alumno alumno = new Alumno(datos.getInt("id"), datos.getString("nombre"),datos.getString("apellido"),datos.getInt("edad"));
                listaAlumnos.add(alumno);
            }
  
        } catch (SQLException ex) {
            System.out.println("No se pudo seleccionar a los alumnos: "+ ex.getMessage());
        } finally {
            try {
                //Cierro la conexión al servidor:
                this.conexion.cerrar();
            } catch (SQLException ex) {
                System.out.println("No se pudo cerrar la conexión: "+
                        ex.getMessage());
            }
        }
        //Devuelvo la lista de alumnos:
        return listaAlumnos;
    }
    
    

    
        //Implemento el método abstracto obtener:
    @Override
    public Alumno obtenerAlumno(int id) {
        Alumno alumno = null;
        this.conexion.abrir();
        try {    
            String sql = "SELECT * FROM alumnos WHERE id=" + id;
            PreparedStatement statement = this.conexion.getCnn().prepareStatement(sql);
            ResultSet datos = statement.executeQuery();
            if(datos.first()) {
                alumno = new Alumno(
                        datos.getInt("id"), 
                        datos.getString("nombre"), 
                        datos.getString("apellido"),
                        datos.getInt("Edad"));
                
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo obtener al alumno: "+ ex.getMessage());
        } finally {
            try {
                this.conexion.cerrar();
            } catch (SQLException ex) {
                System.out.println("No se pudo cerrar la conexíon un error: "+
                        ex.getMessage());
            }
        }
        //Devuelvo el alumno:
        return alumno;    
    }

    @Override
    public boolean agregarAlumno(Alumno alumno) {
        boolean fueAgregado= false;
        this.conexion.abrir();
        try {    
            //Utilizo párametros para crear la consulta:
            String sql = "INSERT INTO alumnos(nombre,apellido,edad,id_Curso)" + "VALUES(?,?,?,?)";
            PreparedStatement statement = this.conexion.getCnn().prepareStatement(sql);
            
            //Seteo los párametros con los datos del alumno a agregar:
            statement.setString(1, alumno.getNombre());
            statement.setString(2, alumno.getApellido());
            statement.setInt(3, alumno.getEdad());
            statement.setInt(4, alumno.getId());
         
            //Ejecuto la actualización de la base de datos:
            statement.executeUpdate();
            System.out.println("Alumno agregado exitosamente.");
            fueAgregado= true;
            
        } catch (SQLException ex) {
            System.out.println("no se pudo agregar al alumno: "+ ex.getMessage());
        } finally {
            try {
                this.conexion.cerrar();
            } catch (SQLException ex) {
                System.out.println("No se pudo cerrar la conexión: "+
                        ex.getMessage());
            }
        }
        return fueAgregado;
    }

    @Override
    public boolean actualizarAlumno(Alumno alumno) {
        boolean fueActualizado= false;
        int id= alumno.getId();
        String nombre= alumno.getNombre();
        String apellido= alumno.getApellido();
        int edad= alumno.getEdad();
        this.conexion.abrir();
        try {    
            String sql = "UPDATE escuela.alumnos SET nombre='"+ nombre+ 
                   "', apellido='"+ apellido+ "' WHERE id='"+ id+ "'";
            PreparedStatement statement = this.conexion.getCnn().prepareStatement(sql);
            //Ejecuto la actualización del alumno en la base de datos:
            statement.execute();
            
          
            
            System.out.println("Alumno actualizado exitosamente.");
            fueActualizado= true;
        } catch (SQLException ex) {
            System.out.println("No se pudo actualizar al alumno: "+ ex.getMessage());
        } finally {
            try {
                this.conexion.cerrar();
            } catch (SQLException ex) {
                System.out.println("No se pudo cerrar la conexíon un error: "+
                        ex.getMessage());
            }
        }
        return fueActualizado;
    }

    @Override
    public boolean borrarAlumno(int id) {
        boolean fueBorrado= false;
        this.conexion.abrir();
        try {    

            String sql = "DELETE FROM alumnos WHERE id="+ id;
            PreparedStatement statement = this.conexion.getCnn().prepareStatement(sql);
            statement.execute();
            fueBorrado= true;


        } catch (SQLException ex) {
            System.out.println("No se pudo borrar al alumno: "+ ex.getMessage());
        } finally {
            try {
                this.conexion.cerrar();
            } catch (SQLException ex) {
                System.out.println("No se pudo cerrar la conexíon un error: "+
                        ex.getMessage());
            }
        }
        return fueBorrado;
    }

}