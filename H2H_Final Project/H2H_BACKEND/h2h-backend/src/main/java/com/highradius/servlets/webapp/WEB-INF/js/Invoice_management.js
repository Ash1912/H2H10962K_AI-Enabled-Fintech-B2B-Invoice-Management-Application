// Retrieve HTML elements
var addInvoiceButton = document.getElementById('addInvoice');
var deleteInvoiceButton = document.getElementById('deleteInvoice');
var invoiceTable = document.getElementById('invoiceTable');
var editInvoiceModal = document.getElementById('editInvoiceModal');
var saveChangesButton = document.getElementById('saveChanges');
var cancelChangesButton = document.getElementById('cancelChanges');

var editOrderCurrency = document.getElementById('editOrderCurrency');
var editCompanyCode = document.getElementById('editCompanyCode');
var editDistributionChannel = document.getElementById('editDistributionChannel');

var currentlyEditingInvoiceId = null;

// Load invoice list on page load
window.onload = function() {
    fetch('DataLoadingServlet')
        .then(response => response.json())
        .then(data => populateTable(data))
        .catch(error => console.error('Error:', error));
};

// Function to fill table with data
function populateTable(data) {
    // Remove all rows (except the first one)
    while (invoiceTable.rows.length > 1) {
        invoiceTable.deleteRow(1);
    }

    // Add a row for each invoice
    data.forEach(invoice => {
        var row = invoiceTable.insertRow();
        row.innerHTML = `
            <td><input type="checkbox" value="${invoice.slNo}"></td>
            <td>${invoice.slNo}</td>
            <td>${invoice.customerOrderID}</td>
            <td>${invoice.salesOrg}</td>
            <td>${invoice.distributionChannel}</td>
            <td>${invoice.companyCode}</td>
            <td>${invoice.orderCreationDate}</td>
            <td>${invoice.orderCurrency}</td>
            <td>${invoice.customerNumber}</td>
            <td>${invoice.amountInUsd}</td>
            <td><button class="editButton">Edit</button></td>`;
        
        // Add click listener to the edit button
        row.querySelector('.editButton').addEventListener('click', function() {
            openEditModal(invoice.slNo);
        });
    });
}

// Add click listener to the add invoice button
addInvoiceButton.addEventListener('click', function() {
    // TODO: Open a form to create a new invoice, then send a POST request to AddServlet
});

// Add click listener to the delete invoice button
deleteInvoiceButton.addEventListener('click', function() {
    var selectedIds = Array.from(invoiceTable.querySelectorAll('input[type="checkbox"]:checked'))
        .map(input => input.value);
    
    fetch('DeleteInvoiceServlet', {
        method: 'POST',
        body: JSON.stringify(selectedIds),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => populateTable(data))
        .catch(error => console.error('Error:', error));
});

// Function to open the edit modal and fill in the current data
function openEditModal(id) {
    currentlyEditingInvoiceId = id;
    // TODO: Fill in the current values for the invoice, then show the modal
    editInvoiceModal.style.display = 'block';
}

// Add click listener to the save changes button in the edit modal
saveChangesButton.addEventListener('click', function() {
    fetch('UpdateServlet', {
        method: 'POST',
        body: JSON.stringify({
            id: currentlyEditingInvoiceId,
            orderCurrency: editOrderCurrency.value,
            companyCode: editCompanyCode.value,
            distributionChannel: editDistributionChannel.value
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            populateTable(data);
            editInvoiceModal.style.display = 'none';
        })
        .catch(error => console.error('Error:', error));
});

// Add click listener to the cancel changes button in the edit modal
cancelChangesButton.addEventListener('click', function() {
    editInvoiceModal.style.display = 'none';
});
