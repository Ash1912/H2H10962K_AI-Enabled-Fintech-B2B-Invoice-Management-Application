import React, { useState, useEffect } from "react";
import { DataGrid } from "@mui/x-data-grid";
import "../styles/Body.css";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogContentText from "@material-ui/core/DialogContentText";

const columns = [
  { field: "slno", headerName: "Sl.No", width: 90 },
  { field: "customer_order_id", headerName: "Customer Order ID", width: 150 },
  { field: "sales_org", headerName: "Sales Org", width: 150 },
  {
    field: "distribution_channel",
    headerName: "Distribution Channel",
    width: 180,
  },
  { field: "division", headerName: "Division", width: 120 },
  {
    field: "released_credit_value",
    headerName: "Released Credit Value",
    width: 180,
  },
  {
    field: "purchase_order_type",
    headerName: "Purchase Order Type",
    width: 160,
  },
  { field: "company_code", headerName: "Company Code", width: 130 },
  {
    field: "order_creation_date",
    headerName: "Order Creation Date",
    width: 180,
  },
  {
    field: "order_creation_time",
    headerName: "Order Creation Time",
    width: 180,
  },
  {
    field: "credit_control_area",
    headerName: "Credit Control Area",
    width: 160,
  },
  { field: "sold_to_party", headerName: "Sold to Party", width: 150 },
  { field: "order_amount", headerName: "Order Amount", width: 130 },
  {
    field: "requested_delivery_date",
    headerName: "Requested Delivery Date",
    width: 200,
  },
  { field: "order_currency", headerName: "Order Currency", width: 130 },
  { field: "credit_status", headerName: "Credit Status", width: 120 },
  { field: "customer_number", headerName: "Customer Number", width: 150 },
  { field: "amount_in_usd", headerName: "Amount in USD", width: 150 },
  { field: "unique_cust_id", headerName: "Unique Customer ID", width: 180 },
];

const Datagrid = ({ rows }) => {
  const [dataRows, setDataRows] = useState(rows);
  // const [openedit, setOpenedit] = React.useState(false);
  const [editData, setEditData] = useState({});
  // const [selectedRows, setSelectedRows] = useState([]);
  const [openDeleteDialog, setOpenDeleteDialog] = useState(false);

  // const handleSelectionChange = (newSelection) => {
  //   setSelectedRows(newSelection.selection.map((row) => row["Sl.No"]));
  //   console.log(newSelection.selection); // Log the selected rows
  // };

  const handleDelete = async () => {
    try {
      const slno = editData.slno;
      const response = await fetch(
        `http://localhost:8080/h2h_milestone_3/delete?slno=${slno}`
      );
      if (response.ok) {
        setDataRows(dataRows.filter((row) => row["Sl.No"] !== slno));
        setOpenDeleteDialog(false);
        alert("Deleted Successfully");
      } else {
        console.error("Delete request failed.");
      }
    } catch (error) {
      console.error("An error occurred while deleting the record:", error);
    }
  };

  useEffect(() => {
    if (rows && rows.length > 0) {
      setDataRows(rows);
    }
  }, [rows]);

  const handleOpenDeleteDialog = () => {
    setOpenDeleteDialog(true);
  };

  const handleCloseDeleteDialog = () => {
    setOpenDeleteDialog(false);
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setEditData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };
  // const handleClickOpenedit = () => {
  //   setOpenedit(true);
  // };

  // const handleCloseedit = () => {
  //   setOpenedit(false);
  // };
  const handleRefresh = async () => {
    try {
      const response = await fetch(
        "http://localhost:8080/h2h_milestone_3/read"
      );
      if (response.ok) {
        const newData = await response.json();
        const rowsWithId = newData.map((row, index) => ({
          ...row,
          id: index + 1,
        }));
        setTimeout(() => {
          setDataRows(rowsWithId);
        }, 2000);
      } else {
        console.error("Refresh request failed.");
      }
    } catch (error) {
      console.error("An error occurred while refreshing the data:", error);
    }
  };

  return (
    <div>
      <div style={{ height: 538, width: "100%" }}>
        <style>
          {`
            .MuiCheckbox-colorPrimary.Mui-checked .MuiSvgIcon-root {
              color: #fc7500;
            }
            .MuiDataGrid-root .MuiDataGrid-columnHeaderTitle {
              overflow: visible;
              color: white;
            }
            .MuiDataGrid-root .MuiDataGrid-window {
              color: white;
            }
            .MuiTypography-colorInherit {
              color: white;
            }
            .MuiIconButton-colorInherit {
              color: white;
            }
            .MuiCheckbox-root {
              color: white;
            }
            .MuiButton-contained {
              background-color: #fc7500;
              margin-right: 8px;
            }
          `}
        </style>
        <DataGrid
          sx={{
            backgroundColor: "#666666",
            color: "white",
            border: "none",
          }}
          rows={dataRows}
          columns={columns}
          checkboxSelection
          style={{ color: "white" }}
          pageSize={8}
          pageSizeOptions={[5, 8, 10, 20, 50, 100]}
          disableRowSelectionOnClick
          pagination
        />
        <div
          style={{
            display: "flex",
            alignItems: "flex-start",
            marginBottom: "8px",
            position: "relative",
            bottom: "2em",
            width: "max-content",
            background: "#666666",
          }}
        >
          <Button
            variant="contained"
            color="primary"
            style={{ backgroundColor: "#fc7500" }}
            onClick={handleRefresh} // Add click event handler
          >
            Refresh
          </Button>
          <Button
            variant="contained"
            color="primary"
            style={{ backgroundColor: "#fc7500" }}
            // onClick={handleClickOpenedit}
            disabled
          >
            Edit
          </Button>

          {/* Edit dialog */}
          {/* <Dialog open={openedit} onClose={handleCloseedit}>
            <DialogContent>
              <DialogContentText>Edit</DialogContentText>
              <form>
                <div>

                  <input
                    type="text"
                    label="Input 1"
                    className="edit-input"
                    name="input1"
                    value={editData.input1 || ""}
                    onChange={handleInputChange}
                    placeholder="ORDER CURRENCY"
                  />
                  <input
                    placeholder="COMPANY CODE"
                    style={{ marginLeft: "5px", marginBottom: "10px" }}
                    type="text"
                    className="edit-input"
                    label="Input 2"
                    name="input2"
                    value={editData.input2 || ""}
                    onChange={handleInputChange}
                  />
                </div>
                <div>

                  <input
                    placeholder="DISTRIBUTION CHANNEL"
                    style={{ width: "-webkit-fill-available" }}
                    className="edit-input"
                    type="text"
                    label="Input 3"
                    name="input3"
                    value={editData.input3 || ""}
                    onChange={handleInputChange}
                  />
                </div>
              </form>
            </DialogContent>
            <DialogActions>
              <button onClick={handleCloseedit} className="dialog-btn">
                Cancel
              </button>
              <button className="dialog-btn">Edit</button>
            </DialogActions>
          </Dialog> */}
          <Button
            variant="contained"
            color="primary"
            style={{ backgroundColor: "#fc7500" }}
            onClick={handleOpenDeleteDialog}
          >
            Delete
          </Button>
          <Dialog open={openDeleteDialog} onClose={handleCloseDeleteDialog}>
            <DialogContent>
              <DialogContentText>Delete Records?</DialogContentText>
              <p>Are you sure you want to delete the selected record?</p>
              <input
                placeholder="Sl.No"
                className="edit-input"
                type="text"
                label="Sl.No"
                name="slno"
                value={editData.slno || ""}
                onChange={handleInputChange}
              />
            </DialogContent>
            <DialogActions>
              <button className="dialog-btn" onClick={handleCloseDeleteDialog}>
                Cancel
              </button>
              <button onClick={handleDelete} className="dialog-btn">
                Delete
              </button>
            </DialogActions>
          </Dialog>
          <Button variant="contained" color="primary" disabled>
            Predict
          </Button>
        </div>
      </div>
    </div>
  );
};

export default Datagrid;
