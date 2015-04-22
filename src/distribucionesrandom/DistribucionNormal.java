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
    
    
}
