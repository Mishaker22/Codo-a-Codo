/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //COO TODA CLASE, PARA "USARLA" DEBO CREAR U OBJETO DE LA MISMA:
        ventana v1=new ventana();
        
        //Le solicito que aparezca en el centro de la pantalla:
        
        v1.setLocationRelativeTo(null);
        
        //HAGO CISIBLE EL OBJETO:
        v1.setVisible(true);
    }
    
}
