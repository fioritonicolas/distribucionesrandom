/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribucionesrandom;

import java.util.Random;

/**
 *
 * @author Martin
 */
public class ExponentialDistribution {
    
    private int cantValores;
    private double media;
    private double[] values;
    
    public ExponentialDistribution(int cantValores, int media)
    {
       this.cantValores = cantValores;
       this.media = media;
    }
    
    
    public int getCantValores() {
        return cantValores;
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
            System.out.println("random:" + randx);
            aux = ((-Math.log(1-randx)) / generateLamnda());
            values[i] = aux;
        }    
    }
    
    public double generateLamnda()
    {
        return (1/media);
    }
    
    public String toString()
    {
        StringBuilder SB = new StringBuilder();
        
        for (int i=0; i<values.length; i++) {           
            SB.append(values[i]);
            SB.append("\n");
        }
        
        return SB.toString();
    }
    
    
}
