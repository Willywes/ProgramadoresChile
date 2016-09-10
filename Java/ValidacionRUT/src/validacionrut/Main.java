/*
 * Aporte para Programadores Chile 09-2016
 */
package validacionrut;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Willywes (Alejandro Isla)
 */
public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opcion = 123;
        
        do {
            
            System.out.println("***********  VALIDADOR DE RUT ************");
            System.out.println("1) Ingrese su opción ");
            System.out.println();
            System.out.println("1) Validar RUT ");
            System.out.println("2) Encontrar Dv ");
            System.out.println();
            System.out.println("0) Salir");
            System.out.print("Ingrese su opción : ");
            
            try {
                System.out.println();
                
                opcion = Integer.parseInt(sc.nextLine());
                
                if (opcion < 0 || opcion > 2) {
                    
                    throw new Exception("Seleccione bien las opciones del menu");
                    
                } else {
                    
                    switch (opcion) {
                        
                        case 1:
                            
                            System.out.println("Ingrese RUT con DV ej: 12345678-9"); // solicitamos el rut separado con un guion -
                            
                            String[] rutDv = sc.nextLine().split("-"); // separamos el rut del dv

                            if (rutDv.length == 2) { //validamos que esten separados

                                int rut = Integer.parseInt(rutDv[0]); // pasamos el string a entero
                                
                                if (rut < 1000000 || rut > 100000000) { // validamos que entre dentro de un rango
                                    
                                    throw new Exception("Rut Fuera de Rango"); 
                                }
                                char dv = rutDv[1].charAt(0); // cargamos el primer caracter despues del guion
                                
                                if (Rut.ValidarRut(rut, dv)) {
                                    System.out.println("RUT CORRECTO");
                                } else {
                                    System.out.println("RUT INCORRECTO");
                                }
                                pausar();
                                pausar();
                                
                            } else {
                                throw new Exception("Ingrese el dv");
                            }
                            break;
                        
                        case 2:
                            
                            System.out.println("Ingrese RUT sin DV ej: 12345678");
                            
                            int rut = Integer.parseInt(sc.nextLine()); // validamos que sean numeros
                            
                            if (rut < 1000000 || rut > 100000000) { // validamos un rango
                                
                                throw new Exception("Rut Fuera de Rango");
                            } else {
                                
                                System.out.println("DV : " + Rut.RetornarDV(rut)); // retornamos el DV
                                System.out.println("RUT : " + rut + "-" + Rut.RetornarDV(rut)); // el rut completo
                                pausar();
                                pausar();
                            }
                                                        
                            break;
                        
                    }
                    
                }
                
            } catch (Exception e) {
                
                System.out.println();                
                System.out.println("ERROR d: " + e.getMessage());
                System.out.println();                
                
                pausar();
            }
            
        } while (opcion != 0);
        
    }
    
    private static void pausar() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
