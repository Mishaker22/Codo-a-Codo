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
public interface AlumnoDao {
    /*  La interfaz AlumnoDao (DATA ACCESS OBJECT u objeto de acceso a datos)
        nos permite abstraernos de la implementación de la persistencia de
        datos de la entidad "Alumno", la clase que implemente esta interfaz
        (por convención "AlumnoDaoImpl") será la que tenga que definir el
        "como" se implementan los métodos.
    */
    //*** Métodos abstractos a implementar ***  
    //Devuelve una lista con todos los Alumnos:
    public List<Alumno> obtenerAlumnos();
    //Devuelve un Alumno según su id:
    public Alumno obtenerAlumno(int id);
    //Agrega un Alumno:
    public boolean agregarAlumno(Alumno alumno);
    //Modifica un Alumno:
    public boolean actualizarAlumno(Alumno alumno);
    //Borrar un Alumno según id:
    public boolean borrarAlumno(int id);  
}