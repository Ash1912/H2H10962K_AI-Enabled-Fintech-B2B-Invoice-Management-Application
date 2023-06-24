import React, { useState, useEffect } from "react";
import { DataGrid } from "@material-ui/data-grid";
import { styled } from "@mui/material/styles";
import { light } from "@material-ui/core/styles/createPalette";

function customCheckbox(theme) {
  return {
    "& .MuiCheckbox-root svg": {
      color: "white",
    },
    "& .MuiTablePagination-root": {
      color: "white",
    },
    "& .MuiSvgIcon-root": {
      color: "white",
    },
  };
}
const StyledDataGrid = styled(DataGrid)(({ theme }) => ({
  border: 0,
  color: light,
  ...customCheckbox(theme),
}));

const columns = [
  { field: "Sl_No", headerName: "SERIAL NO.", width: 150, height: 50 },
  {
    field: "CUSTOMER_ORDER_ID",
    headerName: "Customer Order ID",
    width: 150,
    height: 50,
  },
  { field: "SALES_ORG", headerName: "Sales Org", width: 150 },
  {
    field: "DISTRIBUTION_CHANNEL",
    headerName: "Distribution Channel",
    width: 200,
  },
  { field: "COMPANY_CODE", headerName: "Company Code", width: 200 },
  {
    field: "ORDER_CREATION_DATE",
    headerName: "Order Creation Date",
    width: 200,
  },
  { field: "ORDER_AMOUNT", headerName: "Order Amount", width: 200 },
  {
    field: "ORDER_CURRENCY",
    headerName: "Order Currency",
    width: 200,
  },
  {
    field: "CUSTOMER_NUMBER",
    headerName: "Customer Number",
    width: 200,
  },
  { field: "AMOUNT_IN_USD", headerName: "Amount In USD", width: 200 },
];
const DataTable = (props) => {
  const [tableData, setTableData] = useState([]);
  const [pageSize, setPageSize] = useState(10);
  var [pageIndex, setPageIndex] = useState([]);
  var [checkBoxData, setCheckBoxData] = useState([]);
  var [CUSTOMER_ORDER_ID, setCUSTOMER_ORDER_ID] = useState([]);
  const [selectedRows, setSelectedRows] = React.useState([]);
  console.log(props.columns);
  console.log(props.doc_id);
  console.log(props.invoice_id);
  console.log(props.cust_number);
  console.log(props.business_year);
  useEffect(() => {
    fetch("http://localhost:8081/backend/DisplayServlet")
      .then((data) => data.json())
      .then((data) => setTableData(data));
  }, []);

  function search(rows) {
    if (props.columns.length === 1) {
      return rows.filter(
        (row) =>
          row.CUSTOMER_ORDER_ID.toString()
            .toLowerCase()
            .indexOf(props.q.toLowerCase()) > -1 ||
          row.SALES_ORG.toString()
            .toLowerCase()
            .indexOf(props.q.toLowerCase()) > -1 ||
          row.COMPANY_CODE.toString()
            .toLowerCase()
            .indexOf(props.q.toLowerCase()) > -1 ||
          row.CUSTOMER_NUMBER.toString()
            .toLowerCase()
            .indexOf(props.q.toLowerCase()) > -1
      );
    } else {
      return rows.filter(
        (row) =>
          row.CUSTOMER_NUMBER.toString()
            .toLowerCase()
            .indexOf(props.CUSTOMER_NUMBER.toLowerCase()) > -1 &&
          row.COMPANY_CODE.toString()
            .toLowerCase()
            .indexOf(props.COMPANY_CODE.toLowerCase()) > -1 &&
          row.SALES_ORG.toString()
            .toLowerCase()
            .indexOf(props.SALES_ORG.toLowerCase()) > -1 &&
          row.CUSTOMER_ORDER_ID.toString()
            .toLowerCase()
            .indexOf(props.CUSTOMER_ORDER_ID.toLowerCase()) > -1
      );
    }
  }
  function getIndex(Sl_No) {
    return tableData.findIndex((obj) => obj.Sl_No === Sl_No);
  }
  return (
    <div style={{ height: 500, width: "100%" }}>
      <StyledDataGrid
        rows={search(tableData)}
        columns={columns}
        getRowId={(row) => row.Sl_No}
        loading={!tableData.length}
        checkboxSelection
        style={{ color: "white", border: "1px solid white" }}
        onSelectionModelChange={(ids) => {
          pageIndex = ids;
          checkBoxData.push(getIndex(pageIndex[ids.length - 1]));
          CUSTOMER_ORDER_ID.push(
            parseInt(tableData[checkBoxData[checkBoxData.length - 1]].CUSTOMER_ORDER_ID)
          );
          props.changeCheck(pageIndex);
          props.changsetData(checkBoxData);
          props.changeCUSTOMERORDERIDdata(CUSTOMER_ORDER_ID);
        }}
        pageSize={pageSize}
        onPageSizeChange={(newPageSize) => setPageSize(newPageSize)}
        rowsPerPageOptions={[5, 10, 20]}
        Pagination
      />
    </div>
  );
};
export default DataTable;
