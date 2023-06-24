package com.highradius.connection;

import com.highradius.model.Invoice;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private List<Invoice> invoiceList;

    public DatabaseConnection() {
        invoiceList = new ArrayList<>();
    }

    public List<Invoice> getInvoices() {
        return invoiceList;
    }

    public void addInvoice(Invoice invoice) {
        invoiceList.add(invoice);
    }
}
