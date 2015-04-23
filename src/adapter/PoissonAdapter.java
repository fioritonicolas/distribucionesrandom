/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


/**
 *
 * @author Diego
 */
public class PoissonAdapter implements TableModel {

    private static String mNames[] = {"Numero","Ocurrencias"};
    private ArrayList<DataPoisson> mData;

    public PoissonAdapter(ArrayList<DataPoisson> pDatos) {
        mData = pDatos;

    }

    public int getRowCount() {
        return mData.size();
    }

    public int getColumnCount() {
        return 2;
    }

    public String getColumnName(int columnIndex) {
        return mNames[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        if (getRowCount() > 0) {
            return getValueAt(0, columnIndex).getClass();
        } else {
            return Object.class;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        DataPoisson wAux = mData.get(rowIndex);
        Object wRes = null;
        switch (columnIndex) {
            case 0:
                wRes = wAux.getNumero();
                break;
            case 1:
                wRes= wAux.getOcurrencias() + "";
        }

        return wRes;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    public void addTableModelListener(TableModelListener l) {

    }

    public void removeTableModelListener(TableModelListener l) {

    }

    public DataPoisson getBancoAt(int rowIndex) {
        return mData.get(rowIndex);
    }
}
