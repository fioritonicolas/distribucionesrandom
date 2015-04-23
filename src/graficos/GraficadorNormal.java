/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Martin
 */
public class GraficadorNormal {
    private CategoryDataset datosH;
    private JFreeChart grafica;
    private ChartPanel panel;
    private int cantNums;
    private int intervalos;
    private int[] frecuencias;
    private double[] values;
    

    public void setValues(double[] values) {
        this.values = values;
    }
    
    
    public GraficadorNormal()
    {
        
    }
    
    public JFreeChart getGrafica() {
        return grafica;
    }

    public void setGrafica(JFreeChart Grafica) {
        this.grafica = Grafica;
    }

    public ChartPanel getPanel() {
        return panel;
    }

    public void setPanel(ChartPanel panel) {
        this.panel = panel;
    }

     private CategoryDataset createDataset() {
         
        final DefaultCategoryDataset ds = new DefaultCategoryDataset(); 
       // final XYSeries series = new XYSeries("Observado");
        
        
        double amplitud = (values[values.length-1] / intervalos);

        double inicioIntervalo = 0;
        //  double finalIntervalo = (round(inicioIntervalo,2) + amplitudRounded);
        double finalIntervalo = inicioIntervalo + amplitud;
        double marcaClase = 0;

        for (int i = 0; i < frecuencias.length; i++) {

            System.out.println("FRECUENCIAS; " + frecuencias[i]);
            
            marcaClase = (inicioIntervalo + finalIntervalo) / 2;
            System.out.println("MARCA DE CLASE: " + marcaClase);

            String aux = Double.toString(marcaClase);
            ds.addValue(frecuencias[i],"x" , aux);
         
           
            
          //  series.addOrUpdate(marcaClase, frecuencias[i]);
             

            System.out.println("INICIO " + inicioIntervalo);
            System.out.println("FIN " + finalIntervalo);
            inicioIntervalo = finalIntervalo;
            finalIntervalo = (inicioIntervalo + amplitud);
        }
            

        
     
        //  final XYSeriesCollection dataset = new XYSeriesCollection(series);
      //  dataset.setIntervalWidth(amplitud);
        
        
        return ds;
    }
    
    
    
    
    
    /*   private IntervalXYDataset createDataset() {
        final XYSeries series = new XYSeries("Observado");
        
        
        double amplitud = (values[values.length-1] / intervalos);

        double inicioIntervalo = 0;
        //  double finalIntervalo = (round(inicioIntervalo,2) + amplitudRounded);
        double finalIntervalo = inicioIntervalo + amplitud;
        double marcaClase = 0;

        for (int i = 0; i < frecuencias.length; i++) {

            System.out.println("FRECUENCIAS; " + frecuencias[i]);
            
            marcaClase = (inicioIntervalo + finalIntervalo) / 2;
            System.out.println("MARCA DE CLASE: " + marcaClase);

          
            series.addOrUpdate(marcaClase, frecuencias[i]);
             

            System.out.println("INICIO " + inicioIntervalo);
            System.out.println("FIN " + finalIntervalo);
            inicioIntervalo = finalIntervalo;
            finalIntervalo = (inicioIntervalo + amplitud);
        }

        
        final XYSeriesCollection dataset = new XYSeriesCollection(series);
        dataset.setIntervalWidth(amplitud);
        
        return dataset;
    }
    */

    public int getCantNums() {
        return cantNums;
    }

    public void setCantNums(int cantNums) {
        this.cantNums = cantNums;
    }

    public int getIntervalos() {
        return intervalos;
    }

    public void setIntervalos(int intervalos) {
        this.intervalos = intervalos;
    }

    public int[] getFrecuencias() {
        return frecuencias;
    }

    public void setFrecuencias(int[] frecuencias) {
        this.frecuencias = frecuencias;
    }

    public void levantarFrame() {
      
        FrameGraficoExponencial f = new FrameGraficoExponencial(panel);
        f.setSize(400, 600);
        f.setVisible(true);
    }

    public void cargarDatos() {
        datosH = createDataset();
        asignacion();
    }

    private void asignacion() {
        grafica = ChartFactory.createLineChart3D("Grafico",
                "Intervalos", "Frecuencias", datosH,
                PlotOrientation.VERTICAL, true, true, true);
        
                grafica.setBackgroundPaint(new Color(255, 255, 255));
		CategoryPlot categoryplot = (CategoryPlot)grafica.getPlot();
		NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
		numberaxis.setAutoRangeIncludesZero(false);
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
  /*
                IntervalMarker marker = new IntervalMarker((double)cantNums / intervalos, (double)cantNums / intervalos);
        
        marker.setLabel("Esperado");
        marker.setLabelAnchor(RectangleAnchor.BOTTOM);
        marker.setLabelTextAnchor(TextAnchor.BOTTOM_CENTER);
        Font labelFont = new Font("Serif", Font.PLAIN, 12);
        marker.setLabelFont(labelFont);
        // target.setPaint(new Color(222, 222, 255, 128));
        marker.setOutlinePaint(new Color(255, 0, 0));
           
        XYPlot plot = (XYPlot) grafica.getPlot();
        plot.addRangeMarker(marker, Layer.FOREGROUND);
  */         

    //   plot.setBackgroundPaint(Color.CYAN);
      //   final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        //renderer.setSeriesPaint(0, Color.BLUE);
        panel = new ChartPanel(grafica);
    }
}
