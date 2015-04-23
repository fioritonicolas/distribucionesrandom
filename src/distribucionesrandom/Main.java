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
        
        DistribucionNormal dN = new DistribucionNormal(10.0, 5.0);
        
        dN.generarRND(500);
        
        System.out.println(dN.toString());
         System.out.println("ahora ordenado");
        int [] vec = dN.intervalos(10);
        
        for (int i = 0; i < vec.length; i++) 
        {
            System.out.println(vec[i]);
            
        }
        
//        ExponentialDistribution ed = new ExponentialDistribution(1,10);
//        ed.generateValuesExponential();
//        System.out.println(ed.toString());
//        
//        DistribucionUniforme dU = new DistribucionUniforme(5, 12, 500);
//        double[] generarDistribucion = dU.generarDistribucion();
//        PoissonDistribucion pD = new PoissonDistribucion(500, 5.3);
//        int[] distribucion = pD.generarDist();
//        int[] frecuencias = new int[20];
//        for (int i = 0; i < distribucion.length; i++) {
//            int e = distribucion[i];
//            frecuencias[e]++;
//            //System.out.println(e);
//        
//    }
//    
}
}
    
