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
public class PoissonDistribucion {
    
    private int cantNums;
    private double lambda;
    private int distribucion[];
    
    public PoissonDistribucion(int cantNum, double lambda)
    {
        this.cantNums = cantNum;
        this.lambda = lambda;
    }
    
    
    public int[] generarDist()
    {
        distribucion = new int[cantNums];
        for (int i = 0; i < distribucion.length; i++) {
            distribucion[i] = this.getPoisson(lambda);
        }
        return distribucion;
    }
    
    
    private int getPoisson(double lambda) {
        double L = Math.exp(-lambda);
        //System.out.println("LAMBA ELEVADO ES: "+lambda);
        double p = 1.0;
        int k = 0;

        do {
          k++;
          p *= Math.random();
          //System.out.println("P : "+p);
        } while (p > L);

        return k - 1;
    }

    public int getCantNums() {
        return cantNums;
    }

    public void setCantNums(int cantNums) {
        this.cantNums = cantNums;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    public int[] getDistribucion() {
        return distribucion;
    }

    public void setDistribucion(int[] distribucion) {
        this.distribucion = distribucion;
    }
    
    
    
}
