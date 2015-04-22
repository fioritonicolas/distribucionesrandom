/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

/**
 *
 * @author Nico
 */
public class DataPoisson {
    
    private int numero;
    private int ocurrencias;
    private String label;

    public DataPoisson() {
        ocurrencias = 0;
    }

    public DataPoisson(int numero, int ocurrencias) {
        this.numero = numero;
        this.ocurrencias = ocurrencias;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getOcurrencias() {
        return ocurrencias;
    }

    public void setOcurrencias(int ocurrencias) {
        this.ocurrencias = ocurrencias;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    
    
}
