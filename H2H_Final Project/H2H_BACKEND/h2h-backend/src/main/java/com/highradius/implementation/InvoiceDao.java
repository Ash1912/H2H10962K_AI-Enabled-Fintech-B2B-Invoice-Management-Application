package com.highradius.implementation;

import java.util.List;
import com.highradius.model.Invoice;

public interface InvoiceDao {
    List<Invoice> getInvoiceList();
    boolean insertInvoice(Invoice invoice);
    boolean updateInvoice(int id, String orderCurrency, int companyCode, String distributionChannel);
    boolean deleteInvoice(List<Integer> ids);
	int getLastInvoiceId();
}
