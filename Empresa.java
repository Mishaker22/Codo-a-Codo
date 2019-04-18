/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando
 */
public class Empresa {
    
    /*  De momento utilizaremos un vector para guardar a los empleados,
        más adelante lo reemplazaremos por otra estructura y ya no
        necesitaremos tener la variable que hace referencia a un indice.
    */
    private String razonSocial;
    private Empleado[] empleados;
    
    //Constructor sobrecargado
    public Empresa(String razonSocial, int cantidadEmpleados){
        this.razonSocial= razonSocial;
        this.empleados= new Empleado[cantidadEmpleados];
        inicializarEmpresa();
    }
    
    private void inicializarEmpresa(){
        for (int i = 0; i < this.empleados.length; i++) {
            this.empleados[i]= new Empleado();
        }
    }
    
    private int buscarLibre(){
        int indice= -1;
        for (int i = 0; i < this.empleados.length; i++) {
            if (  ! this.empleados[i].getEstado()  ){
                indice= i;
                break;
            }
        }
        return indice;
    }
    
    //Agregar empleado
    public boolean agregarEmpleado(Empleado empleado){
        boolean fueAgregado= false;
        int indice= buscarLibre();
        if (indice >= 0){
            this.empleados[indice]= empleado;
            fueAgregado= true;
        }
        return fueAgregado;
    }
    
    public void mostrarEmpleados(){
        System.out.println("\nLista de empleados:\n");
        int contador= 0;
        for (int i = 0; i < this.empleados.length; i++) {
            if(this.empleados[i].getEstado()){
                System.out.println( this.empleados[i] );
                contador++;
            }
        }
        if( contador==0 ){
            System.out.println("\nSin empleados activos.\n");
        }
    }
}
