
package distribucionesrandom;


public class DistribucionUniforme 
{
    private int a;
    private int b;
    private double v[];
    private int cantNum;

    public DistribucionUniforme(int a, int b, double[] v, int cantNum) {
        this.a = a;
        this.b = b;
        this.v = new double[cantNum];
        this.cantNum = cantNum;
    }

    public double[] generarDistribucion()
    {
        double num = 0;
        for (int i = 0; i < v.length; i++) 
        {
            num = (((b - a) * Math.random()) + a);
            v[i] = num;
        }
        return v;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double[] getV() {
        return v;
    }

    public void setV(double[] v) {
        this.v = v;
    }

    public int getCantNum() {
        return cantNum;
    }

    public void setCantNum(int cantNum) {
        this.cantNum = cantNum;
    }
    
    
    
}
