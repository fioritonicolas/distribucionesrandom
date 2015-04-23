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
    
    private double [] limSup;
    private double [] marca;
    
    public DistribucionNormal(double med, double var)
    {
        media = med;
        varianza = var;
    }

    public double[] getVecrnd() {
        return vecrnd;
    }

    public double[] getLimSup() {
        return limSup;
    }

    public double[] getMarca() {
        return marca;
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
//            do
//            {
                rnd1 = Math.random();
                rnd2 = Math.random();

                z = Math.sqrt(-2*Math.log10(rnd1))*Math.cos(2*(Math.PI)*rnd2);

                x = media+(z*varianza);
//            }while(x < 0);
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
        limSup = new double [cant];
        marca = new double [cant];
        
        double [] aux = vecrnd;
        
        ordenar(aux);
        double maxFrec = aux[aux.length-1];
        double minFrec = aux[0];
        double amplitud = ((maxFrec-minFrec)/cant);
        
        //establezco limites superiores
        for (int i = 0; i < limSup.length; i++) 
        {
            if(i!=0)
            {
                limSup [i] = amplitud + limSup[i-1];
                marca [i] = amplitud + marca[i-1];
            }
            else
            {
                limSup [i] = minFrec+amplitud;
                marca [i] = (amplitud/2)+minFrec;
            }
            //System.out.println(i + " - " + limSup[i] + " - " + marca[i]);            
        }
        
        for (int i = 0; i < aux.length; i++) 
        {
            for (int j = 0; j < limSup.length; j++) 
            {
                if(aux[i] <= limSup[j])
                {
                    intfrec[j] += 1;
                    break;
                }
            }            
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
