/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando
 */
public class Empleado {
    
    //Atributos de la clase Empleado
    private int legajo;
    private String nombre;
    private String apellido;
    private int dni;
    private boolean estado;
    
    public Empleado(){
        this.estado= false;
    }
    
    //Constructor sobrecargado
    public Empleado(int legajo, String nombre, String apellido, int dni){
        this.legajo= legajo;
        this.nombre= nombre;
        this.apellido= apellido;
        this.dni= dni;
        this.estado= true;
    }
    
    //Getters
    public int getLegajo(){
        return this.legajo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public int getDni(){
        return this.dni;
    }
    public boolean getEstado(){
        return this.estado;
    }
    
    //Setters
    public void setLegajo(int legajo){
        this.legajo= legajo;
    }
    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    public void setApellido(String apellido){
        this.apellido= apellido;
    }
    public void setDni(int dni){
        this.dni= dni;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    @Override
    public String toString(){
        return "LEG: "+ this.legajo+ " -- NOM: "+ this.nombre+
                " -- APE: "+ this.apellido+ " -- DNI: "+ this.dni+
                " -- ESTADO: "+ this.estado;
    }
    
}
