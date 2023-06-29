import React, { useState, useEffect } from "react";
import "../styles/Body.css";
import Datagrid from "./Datagrid";
import AddData from "./AddData";
import Analytics from "./Analytics";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogContentText from "@material-ui/core/DialogContentText";

import Grid from "@material-ui/core/Grid";
import EditData from "./EditData";

export default function HomePage() {
  const [activebtn, setActiveBtn] = useState(1);
  const [advancedbtn, setAdvancedBtn] = useState(true);
  const [searchValue, setSearchValue] = useState("");
  const [filteredRows, setFilteredRows] = useState([]);
  const [rows, setRows] = useState([]);
  const [open, setOpen] = useState(false);

// Above line import necessary dependencies and components for Homepage. Component also defines the several state
// by using the useState hook. useState is used to initialize the initial value as the argument

  const handleClickOpen = () => {
    //open adv search dialogbox
    setOpen(true);
  };

  const handleClose = () => {
    //close adv search dialogbox
    setOpen(false);
  };

  const activebutton = (index) => {
    //set the active tab
    setActiveBtn(index);
  };

  const inputChange = (event) => {
    //for search box
    const value = event.target.value;
    setSearchValue(value);
    setAdvancedBtn(value.length === 0); //adv button true if no value is present
    setActiveBtn(3);
  };

  const clear = () => {
    setSearchValue("");
    setAdvancedBtn(true);
    setActiveBtn(1);
    setFilteredRows([]); // Clear the filtered rows
  };

//useEffect is used for filtering the rows based on the search values

  useEffect(() => {
    //triggered for changes in searchValue or row state changes
    if (searchValue.length > 0) {
      const filtered = rows.filter((row) =>
        row.customer_order_id.toLowerCase().includes(searchValue.toLowerCase())
      );
      setFilteredRows(filtered);
    } else {
      setFilteredRows([]);
    }
  }, [searchValue, rows]);

  const fetchInvoiceeData = async () => {
    try {
      const response = await fetch(
        `http://localhost:8080/h2h_milestone_3/InvoiceData`,
        { method: "GET" }
      );
      if (response.ok) {
        const data = await response.json();
        // Add a unique id for each row
        const rowsWithId = data.map((row, index) => ({
          ...row,
          id: index + 1,
        }));
        setRows(rowsWithId);
      } else {
        console.error("Failed to fetch data from the servlet.");
      }
    } catch (error) {
      console.error("Error while fetching data:", error);
    }
  };
  useEffect(() => {
    // fetch only once
    fetchInvoiceeData(1);
  }, []);

  return (
    <div className="body-container">
      <div className="body-header">
        <div className="firsthalf">
          <button
            className={activebtn === 1 ? "btn-active" : "btn-inactive"}
            onClick={() => activebutton(1)}
          >
            HOME PAGE
          </button>
          <button
            className={activebtn === 2 ? "btn-active" : "btn-inactive"}
            onClick={() => activebutton(2)}
          >
            ADD DATA
          </button>
          <button
            className={activebtn === 3 ? "btn-active" : "btn-search"}
            onClick={() => activebutton(3)}
          >
            SEARCH RESULT
          </button>
          <button
            className={activebtn === 4 ? "btn-active" : "btn-inactive"}
            onClick={() => activebutton(4)}
          >
            ANALYTICS VIEW
          </button>{" "}
          <button
            className={activebtn === 5 ? "btn-active" : "btn-inactive"}
            onClick={() => activebutton(5)}
          >
            EDIT DATA
          </button>
        </div>

        <div className="secondhalf">
          <input
            type="text"
            placeholder="Search Customer Order ID"
            onChange={inputChange}
            className="searchbox"
            value={searchValue}
          />
          <button
            className={advancedbtn ? "clear-btn-inactive" : "clear-btn"}
            onClick={clear}
          >
            Clear
          </button>
          <button
            onClick={handleClickOpen}
            className={advancedbtn ? "advanced-btn" : "advanced-btn-inactive"}
          >
            ADVANCED SEARCH
          </button>

          <Dialog
            open={open}
            onClose={handleClose}
            aria-labelledby="form-dialog-title"
          >
            <DialogContent className="dialog-content ">
              <DialogContentText>Advanced Search</DialogContentText>
              <Grid container direction="column" spacing={2}>
                <Grid item>
                  <input
                    type="text"
                    className="dialog-input"
                    placeholder="Customer Order Id"
                  />
                </Grid>
                <Grid item>
                  <input
                    type="text"
                    className="dialog-input"
                    placeholder="Customer Number"
                  />
                </Grid>
                <Grid item>
                  <input
                    type="text"
                    className="dialog-input"
                    placeholder="Sales Org"
                  />
                </Grid>
              </Grid>
            </DialogContent>
            <DialogActions>
              <button className="dialog-btn">Search</button>
              <button className="dialog-btn" onClick={handleClose}>
                Cancel
              </button>
            </DialogActions>
          </Dialog>
        </div>
      </div>
      <div className="main-content">
        {activebtn === 1 && <Datagrid rows={rows} />}
        {activebtn === 2 && <AddData />}
        {activebtn === 3 && <Datagrid rows={filteredRows} />}
        {activebtn === 4 && <Analytics />}
        {activebtn === 5 && <EditData />}
      </div>
    </div>
  );
}
