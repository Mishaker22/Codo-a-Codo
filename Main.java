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
        
        Empresa parrilla= new Empresa("El Bondiolazo", 3);
        Empresa Pizzeria=new Empresa("La doble Muzza", 2);
        
        
                 
        
        Empleado emp1= new Empleado(100,"Lucas","Perez",35000999);
        Empleado emp2= new Empleado(101,"Ana","Suarez",29000444);
        Empleado emp3= new Empleado(102,"Carlos","Gomez",28444333);
        Empleado emp4= new Empleado(103,"Gabriela","Rodriguez",33222000);
        
        //Nombre de empresa y cantidad de empleados:
        Empresa panaderia= new Empresa("La bola de fraile", 3);
        
        //Agrego un empleado a la empresa:
        contratar(emp1,panaderia);
        contratar(emp2,panaderia);
        contratar(emp3,panaderia);
        contratar(emp4,panaderia);
        
     
        Empresa pizzeria= new Empresa("La bufalinda", 3);
        
        //contratar(emp3, pizzeria);
        //contratar(emp4, pizzeria);
               
        panaderia.mostrarEmpleados();        
        pizzeria.mostrarEmpleados();        
   }
    
   public static void contratar(Empleado unEmpleado, Empresa unaEmpresa){
       if ( unaEmpresa.agregarEmpleado(unEmpleado) ){
            System.out.println("EMPLEADO AGREGADO!");
        }else{
            System.out.println("NO HAY LUGAR!");
        }
   }
   
}
