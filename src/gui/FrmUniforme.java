
package gui;

import distribucionesrandom.DistribucionUniforme;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luciano
 */
public class FrmUniforme extends javax.swing.JFrame {

    private DistribucionUniforme du;
    private double []numDist;
    private DefaultTableModel modelo = new DefaultTableModel();
    public FrmUniforme() {
        initComponents();
         modelo.addColumn("Intervalos");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        modelo.addColumn("fo");
        modelo.addColumn("fe");
        modelo.addColumn("((fe-fo)^2)/2");
        du = new DistribucionUniforme();
    }
    
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfingreseA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfingreseB = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfcantNum = new javax.swing.JTextField();
        jbtgeneraNum = new javax.swing.JButton();
        btngenerarGrafico = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtfIntervalos = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTextField1.setEditable(false);
        jTextField1.setText("                                            Distribución Uniforme");
        jTextField1.setName("Distribución Uniforme"); // NOI18N

        jLabel1.setText("Ingrese A:");

        jLabel2.setText("Ingrese B:");

        jLabel3.setText("Ingrese Cantidad de Numeros");

        jbtgeneraNum.setText("Generar Numeros");
        jbtgeneraNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtgeneraNumActionPerformed(evt);
            }
        });

        btngenerarGrafico.setText("Generar Grafico");

        jLabel4.setText("Ingrese Cantidad de Intervalos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtfingreseA, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jtfingreseB, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jbtgeneraNum)
                        .addGap(33, 33, 33)
                        .addComponent(btngenerarGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfcantNum, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(jtfIntervalos))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfingreseA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfingreseB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfcantNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfIntervalos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtgeneraNum)
                    .addComponent(btngenerarGrafico))
                .addContainerGap())
        );

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cantidad Numeros", "Numeros"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtgeneraNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtgeneraNumActionPerformed
        int numA = Integer.parseInt(this.jtfingreseA.getText());
        int numB = Integer.parseInt(this.jtfingreseB.getText());
        int cant = Integer.parseInt(this.jtfcantNum.getText());
        
        du.setA(numA);
        du.setB(numB);
        du.setCantNum(cant);
        
        numDist = new double[cant];
        numDist = du.generarDistribucion();
        
        int intervalos = Integer.parseInt(this.jtfIntervalos.getText());
        Object[]fila = new Object[6];
        double amplitud = (double)(1.0/intervalos);
        double amplitudNueva = round(amplitud, 2);
        double inicioIntervalo = 0;
        double finalIntervalo = (round(inicioIntervalo, 2) + amplitudNueva);
        float esperada;
        float numerador;
        double acum = 0;
        
         int[] vec = new int[intervalos];
        
        for (int i = 0; i < numDist.length; i++) 
        {
            if(numDist[i]<= inicioIntervalo && numDist[i]< finalIntervalo)
            {
                vec[i]++;
            }
            inicioIntervalo = round(finalIntervalo,2);
            finalIntervalo = (round(inicioIntervalo,2) +  amplitudNueva);
        }
        
       
        
        for (int i = 0; i < vec.length; i++) {
                    
                    
                   
                    fila[1] = round(inicioIntervalo,2);
                    fila[2] = round(finalIntervalo,2);
         
                    inicioIntervalo = round(finalIntervalo,2);
                    finalIntervalo = (round(inicioIntervalo,2) +  amplitudNueva);
                    
                    Object value = (Object) vec[i];
                    fila[0] = i+1;
                    fila[3] = value;
                    esperada = cant/intervalos;
                    fila[4] = esperada;
                    numerador = (esperada-vec[i]);
                    fila[5] = (Math.pow(numerador,2))/2;
                    acum = acum + (Math.pow(numerador,2))/2;
                    modelo.addRow(fila);
                    
                    
                }
            Object[]totales = new Object[6];
            totales[0] = "TOTALES";
            totales[5] = acum;
            modelo.addRow(totales);
            this.jtable.setModel(modelo);
//            jTextCantInt.setText("");
//            jTextCantNums.setText("");
//            jTextCteAdt.setText("");
//            jTextField2.setText("");
//            jTextMod.setText("");
//            jTextMulti.setText("");
//            jTextSemilla.setText("");
        
    }//GEN-LAST:event_jbtgeneraNumActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUniforme().setVisible(true);
            }
        });
    }
    
    public void cargarTabla()
    {
        for (int i = 0; i < numDist.length; i++) 
        {
            
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btngenerarGrafico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbtgeneraNum;
    private javax.swing.JTable jtable;
    private javax.swing.JTextField jtfIntervalos;
    private javax.swing.JTextField jtfcantNum;
    private javax.swing.JTextField jtfingreseA;
    private javax.swing.JTextField jtfingreseB;
    // End of variables declaration//GEN-END:variables
}
