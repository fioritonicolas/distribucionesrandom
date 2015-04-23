/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribucionesrandom;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author Martin
 */
public class ExponentialDistribution {
    
    private int cantValores;
    private double media;
    private double[] values;
    double[] temp;
    
    public ExponentialDistribution(int cantValores, double media)
    {
       this.cantValores = cantValores;
       this.media = media;
    }
    
    
    public int getCantValores() {
        return cantValores;
    }

    public double[] getValues() {
        return values;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void setValues(double[] values) {
        this.values = values;
    }

    public double getMedia() {
        return media;
    }


    public void setCantValores(int cantValores) {
        this.cantValores = cantValores;
    }

    public void setMedia(int media) {
        this.media = media;
    }
    
    public void generateValuesExponential()
    {
        values = new double[cantValores];
        double aux;
        double randx;
        Random rand = new Random();
        
        for (int i = 0; i < values.length; i++) {
            
            randx = rand.nextDouble();
            aux = ((-Math.log(1-randx)) / generateLamnda());
            values[i] = aux;
        }
        
    }
    
    public double generateLamnda()
    {
        return (1/media);
    }
    
    public int[] intervalos(int cantIntervalos)
    {
        ordenar();
        double maxIntervalo = values[values.length-1];
        int vector[] = new int[cantIntervalos];
       
        for (int i = 0; i < values.length; i++) 
        {
            if(values[i]!=maxIntervalo)
            {
            double intervalo1 = (double) ((values[i]/(maxIntervalo/cantIntervalos)));
            
            int intervalo = (int)Math.floor(intervalo1);
            vector[intervalo] += 1;
            }
            
            else
            {              
                vector[vector.length-1]+= 1;               
            }
            
        }
        return vector;
        
    }
    
          public void ordenar()
        {
            int n = values.length;
            temp = new double[n];
            sort(0, n - 1);

        }
        
        private void sort(int izq, int der)
        {
            if(izq < der) 
            {
                int centro = (izq + der) / 2;
                sort(izq, centro);
                sort(centro + 1, der);
                merge(izq, centro, der);
            }    
        }       
        
        private void merge(int izq, int centro, int der)
        {
            for(int i = izq; i <= der; i++) temp[i] = values[i];

            int i = izq, j = centro + 1, k = izq;
            while(i <= centro && j <= der) 
            {
               if(temp[i] <= temp[j]) 
               {
                 values[k] = temp[i];
                 i++;
               } 
               else 
               {
                 values[k] = temp[j];
                 j++;
               }
               k++;
            }
            
            while(i <= centro) 
            {
               values[k] = temp[i];
               k++;
               i++;
            }
        }

    
    public String toString()
    {
        StringBuilder SB = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");
        
        for (int i=0; i<values.length; i++) {           
            SB.append(df.format(values[i]));
            SB.append("\n");
        }
        
        return SB.toString();
    }
    

    
}
