package com.highradius.implementation;

import java.util.List;

import com.highradius.model.Invoice;

public interface InvoiceDao {
	List<Invoice> getInvoices();

	void insertInvoice(Invoice invoice);

	void updateInvoice(Integer id, Invoice invoice);

	void deleteInvoice(Integer id);
}