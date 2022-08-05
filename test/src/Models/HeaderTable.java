package Models;

import Controller.ActionsListener;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class HeaderTable extends AbstractTableModel {
    private ArrayList<Header> headerArrayList;
    public HeaderTable(ArrayList<Header> headerArrayList) {
        this.headerArrayList = headerArrayList;
    }
    public HeaderTable() {

    }
    @Override
    public int getRowCount() {
        return headerArrayList.size();
    }
    @Override
    public int getColumnCount() {
        return 4;
    }
    @Override
    public Object getValueAt(int i, int j) {
        Header header = headerArrayList.get(i);
        switch (j) {
            case 0:
                return header.getInvoiceNumber();
            case 1:
                return ActionsListener.simpleDateFormat.format(header.getInvoiceDate());
            case 2:
                return header.getCutomer();
            case 3:
                return header.getTotal();

        }
        return "";
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No.";
            case 1:
                return "Date";
            case 2:
                return "Customer";
            case 3:
                return "Total";
        }
        return "";
    }

}
