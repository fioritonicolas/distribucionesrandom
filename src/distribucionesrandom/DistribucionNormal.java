/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribucionesrandom;

import java.text.DecimalFormat;

/**
 *
 * @author Martin
 */
public class DistribucionNormal {
    
    private double vecrnd[];
    private double media;
    private double varianza;
    
    public DistribucionNormal(double med, double var)
    {
        media = med;
        varianza = var;
    }

    public double[] getVecrnd() {
        return vecrnd;
    }
    
    public void generarRND(int cant)
    {
        vecrnd = new double[cant];
        double rnd1;
        double rnd2;
        double z;
        double x;
        
        for (int i = 0; i < vecrnd.length; i++) 
        {
            rnd1 = Math.random();
            rnd2 = Math.random();
            
            z = Math.sqrt(-2*Math.log10(rnd1))*Math.cos(2*(Math.PI)*rnd2);
            
            x = media+(z*varianza);
            vecrnd [i] = x;
        }        
    }
    
    public String toString()
    {
        StringBuilder sB = new StringBuilder();
        
        DecimalFormat dF = new DecimalFormat("#.##");
        
        for (int i = 0; i < vecrnd.length; i++) 
        {
            sB.append(dF.format(vecrnd[i]));
            sB.append("\n");            
        }
        
        return sB.toString();
    }
    
    public int[] intervalos(int cant)
    {
        int [] intfrec = new int[cant];
        double [] aux = vecrnd;
        ordenar(aux);
        double maxFrec = aux[aux.length-1];
        double intervalo1;
        int intervalo;
                
        for (int i = 0; i < aux.length; i++) 
        {
            if(aux[i] != maxFrec)
            {
                intervalo1 = (double) ((aux[i]/(maxFrec/cant)));
                intervalo = (int) Math.floor(intervalo1);
                
                intfrec[intervalo] += 1;
            }
            else
                intfrec[cant-1] += 1;
        }        
        
        return intfrec;
    }
    
    public void ordenar(double [] v)
        {
              ordenar( 0, v.length - 1,v );
        }
        
        private void ordenar (int izq, int der, double [] v)
        {
              int i = izq, j = der; 
              double y;
              double x = v[(izq + der) / 2];
              do 
              {
                    while( v[i] < x && i < der ) { i++; }
                    while( x < v[j] && j > izq ) { j--; }
                    if( i <= j )
                    {
                          y = v[i];
                          v[i] = v[j];
                          v[j] = y;
                          i++;
                          j--;
                    }
              }
              while( i <= j );
              if( izq < j ) ordenar( izq, j, v );
              if( i < der ) ordenar( i, der, v );
        } 
}
