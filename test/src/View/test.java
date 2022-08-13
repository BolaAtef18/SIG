package View;

import Controller.ActionsListener;
import Models.Header;
import Models.HeaderTable;
import Models.Items;
import Models.ItemsTable;
import com.sun.deploy.security.ruleset.Rule;
import com.sun.deploy.security.ruleset.RuleSetParser;
import com.sun.xml.internal.bind.api.Bridge;
import com.sun.xml.internal.ws.api.SOAPVersion;
import com.sun.xml.internal.ws.api.addressing.AddressingVersion;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;
import com.sun.xml.internal.ws.spi.db.XMLBridge;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class test extends javax.swing.JFrame {

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem loadMenuItem;
    private JMenuItem saveMenuItem;


    private JPanel Main;
    private JTable table1;


    private JButton createNewInvoiceButton;
    private JButton deleteInvoiceButton;
    private JTextField txtInvoiceDate;
    private JButton cancelButton;
    private JButton saveButton;
    private JTextField txtCustomerName;
    private JTable table2;

    private test app;
    private ArrayList<Header> headerArrayList;
    private ArrayList<Items> itemsArrayList;
    private HeaderTable headerTable = new HeaderTable();
    private javax.swing.JTable invoicesTable;
    private javax.swing.JTable invoiceItemsTable;
    private javax.swing.JLabel invoiceNoValueLabel;
    private javax.swing.JTextField customerNameTextField;
    private javax.swing.JTextField invoiceDateTextField;
    private javax.swing.JLabel invoiceNumerValueLabel;
    private javax.swing.JLabel customerNameValueLabel;
    private javax.swing.JLabel invoiceDateValueLabel;
    private javax.swing.JLabel invoiceTotalValueLabel;
    private javax.swing.JTextField itemNameTextField;
    private javax.swing.JTextField itemPriceTextField;
    private javax.swing.JTextField countTextField;
    private ItemsTable itemsTable = new ItemsTable();

    private ActionsListener actionsListener = new ActionsListener(this);


    public <Items> test() {


        menuBar = new JMenuBar();
        loadMenuItem = new JMenuItem("Load File", 'L');
        saveMenuItem = new JMenuItem("Save File", 'S');
        loadMenuItem.setAccelerator(KeyStroke.getKeyStroke('L', KeyEvent.ALT_DOWN_MASK));
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.ALT_DOWN_MASK));
        ButtonGroup group = new ButtonGroup();
        fileMenu = new JMenu("File");
        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        loadMenuItem.addActionListener(actionsListener);
        saveMenuItem.addActionListener(actionsListener);
        deleteInvoiceButton.addActionListener(actionsListener);
        createNewInvoiceButton.addActionListener(actionsListener);
        saveButton.addActionListener(actionsListener);
        cancelButton.addActionListener(actionsListener);



        createTable1();

        createTable2();
    }
    public ActionsListener getActionsListener() {
        return actionsListener;
    }
    public void setActionsListener(ActionsListener actionsListener) {
        this.actionsListener = actionsListener;
    }

    private void createTable1() {
        String[][] Invoice_Table = {
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""}
        };
        table1.setModel(new DefaultTableModel(Invoice_Table,
                new String[]{"NO.", "Date", "Customer", "Total"}
        ));

    }

    private void createTable2() {
        String[][] Invoice_Items = {
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""}
        };
        table2.setModel(new DefaultTableModel(Invoice_Items,
                new String[]{"NO.", "Item Name", "Item Price", "Count", "Item Total"}
        ));

    }


    public static void main(String[] args) throws IOException {


        test j = new test();
        j.setContentPane(new test().Main);
        j.setSize(800, 600);
        j.setLocation(200, 50);

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.pack();



    }
    public void setHeaderArrayList(ArrayList<Header> headerArrayList) {
        this.headerArrayList = headerArrayList;
    }
    public Header getNo(int no){
        for (Header header : headerArrayList){
            if (header.getInvoiceNumber() == no) {
                return header;
            }
        }
        return null;
    }
    public void setItemsArrayList(ArrayList<Items> itemsArrayList) {
        this.itemsArrayList = itemsArrayList;
    }
    public void setHeaderTable(HeaderTable headerTable) {
        this.headerTable = headerTable;
    }
    public JTable getInvoicesTable() {
        return invoicesTable;
    }
    public JTable getInvoiceItemsTable() {
        return invoiceItemsTable;
    }
    public ArrayList<Header> getHeaderArrayList() {
        return headerArrayList;
    }
    public JLabel getInvoiceNoValueLabel() {
        return invoiceNoValueLabel;
    }
    public JTextField getCustomerNameTextField() {
        return customerNameTextField;
    }
    public JTextField getInvoiceDateTextField() {
        return invoiceDateTextField;
    }
    public HeaderTable getHeaderTable() {
        return headerTable;

    }
    public JLabel getInvoiceNumerValueLabel() {
        return invoiceNumerValueLabel;
    }
    public JLabel getCustomerNameValueLabel() {
        return customerNameValueLabel;
    }
    public JLabel getInvoiceDateValueLabel() {
        return invoiceDateValueLabel;
    }
    public JLabel getInvoiceTotalValueLabel() {
        return invoiceTotalValueLabel;
    }
    public JTextField getItemNameTextField() {
        return itemNameTextField;
    }
    public JTextField getItemPriceTextField() {
        return itemPriceTextField;
    }
    public JTextField getCountTextField() {
        return countTextField;
    }
    public ArrayList<Items> getItemsArrayList() {
        return itemsArrayList;
    }
    public ItemsTable getItemsTable() {
        return itemsTable;
    }











}



