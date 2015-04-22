/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribucionesrandom;

import adapter.DataPoisson;
import java.util.ArrayList;

/**
 *
 * @author Nico
 */
public class PoissonDistribucion {
    
    private int cantNums;
    private double lambda;
    private int intervalos;
    private int distribucion[];
    private int mayor;
    
    public PoissonDistribucion(int cantNum, double lambda)
    {
        this.cantNums = cantNum;
        this.lambda = lambda;
        
    }
    
    public PoissonDistribucion()
    {
        this.cantNums = 500;
        this.lambda = 33.2;
    }
    
    
    public int[] generarDist()
    {
        mayor = 0;
        distribucion = new int[cantNums];
        for (int i = 0; i < distribucion.length; i++) {
            distribucion[i] = this.getPoisson(lambda);
        }
        return distribucion;
    }
    
    public ArrayList<DataPoisson> getDristAgrupadaEnIntevalos()
    {
        ArrayList<DataPoisson> list = new ArrayList<>(intervalos);
        
        int amplitudIntevalos = mayor/intervalos;
        int limiteInferior, limiteSuperior;
        limiteInferior = 0;
        limiteSuperior = limiteInferior + amplitudIntevalos;
        DataPoisson dP;
        if(amplitudIntevalos > 0)
        {
            
            for (int i = 0; i < intervalos; i++) {
                 
                
                dP = new DataPoisson();
                dP.setLabel(limiteInferior + " - "  + limiteSuperior);
                for (int j = 0; j < distribucion.length; j++) {
                       int ran = distribucion[j];
                        if(ran>=limiteInferior && ran <limiteSuperior)
                        {
                                dP.setOcurrencias(dP.getOcurrencias()+1);
                        }
                }
             
                 
                 
            list.add(dP);
            limiteInferior = limiteSuperior;
            limiteSuperior = limiteInferior + amplitudIntevalos;
                
            }
            
            
            
            
        }
        
        
        return list;
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
        
        if(mayor==0)
        {
            mayor = k-1;
        }
        
        if((k-1)>mayor)
        {
            mayor = k-1;
        }

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

    public int getIntervalos() {
        return intervalos;
    }

    public void setIntervalos(int intervalos) {
        this.intervalos = intervalos;
    }
    
    
    
    
}
