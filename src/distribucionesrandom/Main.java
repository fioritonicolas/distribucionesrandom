/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribucionesrandom;

/**
 *
 * @author Nico
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        
        DistribucionUniforme dU = new DistribucionUniforme(5, 12, 500);
        double[] generarDistribucion = dU.generarDistribucion();
        PoissonDistribucion pD = new PoissonDistribucion(500, 5.3);
        int[] distribucion = pD.generarDist();
        int[] frecuencias = new int[20];
        for (int i = 0; i < distribucion.length; i++) {
            int e = distribucion[i];
            frecuencias[e]++;
            //System.out.println(e);
            
        }
        
        System.out.println("LOS NUMEROS:");
        for (int i = 0; i < frecuencias.length; i++) {
            System.out.println(i);
            
        }
        
        System.out.println("SUS FRECUENCIAS");
        for (int i = 0; i < frecuencias.length; i++) {
            System.out.println(frecuencias[i]);
            
        }
        
        
        
      
    }
    
}
