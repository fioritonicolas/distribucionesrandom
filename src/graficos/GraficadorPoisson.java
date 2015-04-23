/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import adapter.DataPoisson;
import java.awt.Color;
import java.util.ArrayList;
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
 * @author Nico
 */
public class GraficadorPoisson {
    private CategoryDataset datosH;
    private JFreeChart grafica;
    private ChartPanel panel;
    private ArrayList<DataPoisson> listDatos;

    public GraficadorPoisson(ArrayList<DataPoisson> listDatos) {
        this.listDatos = listDatos;
    }
    
    
    
     public void levantarFrame() {
        datosH = createDataset();
        crearGrafico();
        FrameGraficoExponencial f = new FrameGraficoExponencial(panel);
        f.setSize(400, 600);
        f.setVisible(true);
    }
    
    private CategoryDataset createDataset() {
        final DefaultCategoryDataset ds = new DefaultCategoryDataset(); 
        
        for (DataPoisson listDato : listDatos) {
            
            String aux = Integer.toString(listDato.getNumero());
            ds.addValue(listDato.getOcurrencias(), "x", aux);
        }

//        for (int i = 0; i < frecuencias.length; i++) {
//
// 
//
//            String aux = Double.toString(marcaClase);
//            ds.addValue(frecuencias[i],"x" , aux);
//         
//    
//        }
        return ds;
    }
    
        private void crearGrafico() {
        grafica = ChartFactory.createLineChart3D("Distribucion Poisson",
                "Randoms", "Frecuencias", datosH,
                PlotOrientation.VERTICAL, true, true, true);
        
                grafica.setBackgroundPaint(new Color(255, 255, 255));
		CategoryPlot categoryplot = (CategoryPlot)grafica.getPlot();
		NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
		numberaxis.setAutoRangeIncludesZero(false);
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        panel = new ChartPanel(grafica);
    }

    public void setListDatos(ArrayList<DataPoisson> listDatos) {
        this.listDatos = listDatos;
    }
        
        
    
}
