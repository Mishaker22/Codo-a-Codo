//datas access option.
import java.util.List;
import javax.swing.JOptionPane;

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
        
        //Creo el objeto "alumnoDao" para la manejar la persistencia de los
        //objetos "alumno":
        AlumnoDao alumnoDao = new AlumnoDaoImpl();
        
        //Creo una lista de alumnos y la inicializo con todos los alumnos que
        //tengo almacenados:
        List<Alumno> listaAlumnos = alumnoDao.obtenerAlumnos();
        System.out.println(listaAlumnos); 
  
        /*
         
        //Muestro en consola al alumno con id=3 en la base de datos:
        System.out.println(alumnoDao.obtenerAlumno(3));

        //Creo un nuevo alumno para agregar a la base de datos:
        //Alumno a1= new Alumno("MARGE","SIMPSON");
        //alumnoDao.agregar(a1);
        
        listaAlumnos = alumnoDao.obtenerAlumnos();
        System.out.println(listaAlumnos); 
        
            /*
            //Cambio nombre y apellido para cargar a MAGGIE SIMPSON:
            a1.setnombre("MAGGIE");

            //Ahora agrego al alumno:
            if (  alumnoDao.agregar(a1)   ){
                JOptionPane.showMessageDialog(null, "ADENTRO",
                        "ALUMNO AGREGADO!",
                        JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "NO SE PUDO!!",
                        "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
            */
        
            
            /*    
            //Obtengo el primer alumno agregado:
            listaAlumnos = alumnoDao.obtenerAlumnos();
            int primero= 0;
            Alumno a1=listaAlumnos.get(primero;

            a1.setid(listaAlumnos.get(primero).getid());

            System.out.println(a1);
            //Cambio el nombre y el apellido del objeto a1:
            a1.setnombre("BART");
            a1.setapellido("SIMPSON");
            alumnoDao.actualizarAlumno(a1);

            //Borrando el alumno con id= 715:
            alumnoDao.borrarAlumno(715);
            listaAlumnos= alumnoDao.obtenerTodos();
            System.out.println(listaAlumnos);
            */
        /*
        
        //Creo un nuevo alumno utilizando el constructor sin el atributo "id"
        //ya que ese campo en la tabla alumnos esta seteado como "Auto
        //Incremental:
        Alumno nuevoAlumno= new Alumno("Daniel", "Ramirez");
        
        //Agrego al alumno:
        alumnoDao.agregar(nuevoAlumno);
        
        //Vuelvo a recibir a todos los alumnos guardados:
        listaAlumnos = alumnoDao.obtenerTodos();
        System.out.println(listaAlumnos);         
        
        //Recibo al alumno con id= 3;
        Alumno alumno = alumnoDao.obtener(3);
        System.out.println(alumno);  
        
        //Modifico los datos del alumno con id= 3:
        alumno.setnombre("LISA");
        alumno.setapellido("SIMPSON");
        
        //Realizo la actualización del alumno anterior en la base de datos:
        alumnoDao.actualizarAlumno(alumno);
        
        //Borro el alumno con id= 1:
        alumnoDao.borrarAlumno(1);
        
        //Vuelvo a recibir a todos los alumnos guardados:
        listaAlumnos = alumnoDao.obtenerTodos();
        System.out.println(listaAlumnos);
          

        */
    }
}

