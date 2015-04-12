/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author Nico
 */
public class GraficadorUniforme {

    private CategoryDataset datosH;
    private JFreeChart grafica;
    private ChartPanel panel;
    private int cantNums;
    private int intervalos;
    private int[] frecuencias;
    private double menor;
    private double mayor;

    public GraficadorUniforme() {

//        
//        grafica = ChartFactory.createBarChart("Visitas diarias",
//        "Días", "Visitas", datos,
//        PlotOrientation.VERTICAL, true, true, false);
        //ChartFactory.createHis
    }

    

    public JFreeChart getGrafica() {
        return grafica;
    }

    public void setGrafica(JFreeChart Grafica) {
        this.grafica = Grafica;
    }
    
    public void setMayorMenor(double menor, double mayor)
    {
        this.menor = menor;
        this.mayor = mayor;
    }

    public ChartPanel getPanel() {
        return panel;
    }

    public void setPanel(ChartPanel panel) {
        this.panel = panel;
    }

    private CategoryDataset createDataset() {
//        final XYSeries series = new XYSeries("Observado");
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // intervalos = 20
        // cant numeros = 2000
        // amplitud = 100
        double amplitud = (cantNums / intervalos);
//         double amplitud = (double) (mayor) - (menor) / intervalos;

//        double amplitudRounded = round(amplitud, 2);

        double inicioIntervalo = 0;
        //  double finalIntervalo = (round(inicioIntervalo,2) + amplitudRounded);
        double finalIntervalo = inicioIntervalo + amplitud;
        double marcaClase = 0;

        for (int i = 0; i < frecuencias.length; i++) {

            //System.out.println("FRECUENCIAS; " + frecuencias[i]);
            //marcaClase = round((inicioIntervalo +  finalIntervalo)/2,2);
            marcaClase = (inicioIntervalo + finalIntervalo) / 2;
            //System.out.println("MARCA DE CLASE: " + marcaClase);

            // series.addOrUpdate(inicioIntervalo   , frecuencias[i]);
            String aux = Double.toString(marcaClase);
            dataset.addValue(frecuencias[i],"y",aux);
               // series.addOrUpdate(finalIntervalo    ,frecuencias[i]);

//            System.out.println("INICIO " + inicioIntervalo);
//            System.out.println("FIN " + finalIntervalo);
            inicioIntervalo = finalIntervalo;
            finalIntervalo = (inicioIntervalo + amplitud);
        }

        // primer valor: la marca de clase (punto medio de intervalos
        // segundo valor la frecuencia observada
        // series.add(1, 32);
        
//        final XYSeriesCollection dataset = new XYSeriesCollection(series);
//        dataset.setIntervalWidth(amplitud);
//        dataset.addSeries(series2);
        return dataset;
    }

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
        FrameGraficoUniforme f = new FrameGraficoUniforme(panel);
        f.setSize(400, 600);
        f.setVisible(true);
    }

    public void cargarDatos() {
        datosH = createDataset();
        asignacion();
    }

    private void asignacion() {
        grafica = ChartFactory.createLineChart3D("Histograma de Frecuencias",
                "Intervalos", "Frecuencias", datosH,
                PlotOrientation.VERTICAL, true, true, false);
        
                grafica.setBackgroundPaint(new Color(255, 255, 255));
		CategoryPlot categoryplot = (CategoryPlot)grafica.getPlot();
		NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
		numberaxis.setAutoRangeIncludesZero(false);
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//        IntervalMarker marker = new IntervalMarker((double)cantNums / intervalos, (double)cantNums / intervalos);
//        marker.setLabel("Esperado");
//        marker.setLabelAnchor(RectangleAnchor.BOTTOM);
//        marker.setLabelTextAnchor(TextAnchor.BOTTOM_CENTER);
//        Font labelFont = new Font("Serif", Font.PLAIN, 12);
//        marker.setLabelFont(labelFont);
//        // target.setPaint(new Color(222, 222, 255, 128));
//        marker.setOutlinePaint(new Color(255, 0, 0));
//        XYPlot plot = (XYPlot) grafica.getPlot();
//        plot.addRangeMarker(marker, Layer.FOREGROUND);

     //   plot.setBackgroundPaint(Color.CYAN);
//         final BarRenderer renderer = (BarRenderer) plot.getRenderer();
//          renderer.setSeriesPaint(0, Color.BLUE);
        panel = new ChartPanel(grafica);
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
