package Controller;

import Models.Header;
import Models.Items;
import Models.ItemsTable;
import View.test;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;

import static Controller.ActionsListener.simpleDateFormat;

public class InvoiceSelectionListener implements ListSelectionListener {

    private test appFrame;
    public InvoiceSelectionListener(test appFrame) {
        this.appFrame = appFrame;
    }
    public InvoiceSelectionListener() {
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInoviceIndex = appFrame.getInvoicesTable().getSelectedRow();
        if (selectedInoviceIndex != -1){
            Header selectedInvoice = appFrame.getHeaderArrayList().get(selectedInoviceIndex);
            ArrayList<Items> itemArrayList = selectedInvoice.getLines();
            ItemsTable itemsTable = new ItemsTable(itemArrayList);
            appFrame.setItemsArrayList(itemArrayList);
            appFrame.getInvoiceItemsTable().setModel(itemsTable);
            appFrame.getInvoiceNumerValueLabel().setText("" + selectedInvoice.getInvoiceNumber());
            appFrame.getCustomerNameValueLabel().setText(selectedInvoice.getCutomer());
            appFrame.getInvoiceDateValueLabel().setText(simpleDateFormat.format(selectedInvoice.getInvoiceDate()));
            appFrame.getInvoiceTotalValueLabel().setText("" + selectedInvoice.getTotal());
        }
    }

}
