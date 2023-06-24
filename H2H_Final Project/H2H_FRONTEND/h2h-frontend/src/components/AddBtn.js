import React from "react";
import { withStyles } from "@material-ui/core/styles";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import MuiDialogTitle from "@material-ui/core/DialogTitle";
import MuiDialogContent from "@material-ui/core/DialogContent";
import MuiDialogActions from "@material-ui/core/DialogActions";
import IconButton from "@material-ui/core/IconButton";
import CloseIcon from "@material-ui/icons/Close";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import "./addModel.css";
import AddIcon from "@material-ui/icons/Add";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import axios from "axios";

const useStyles = makeStyles((theme) => ({
  divs: {
    backgroundColor: "#2A3E4C",
    color: "#FFFFFF",
    fontFamily: " normal normal normal Ubuntu",
  },
  paper: {
    minWidth: "1000px",
  },
  view: {
    width: "200px",
    height: "45px",
    borderRadius: "10px",
    backgroundColor: "#2A3E4C",
    textAlign: "center",
    fontSize: "18px",
    color: "#FFFFFF",
    margin: theme.spacing(1),
  },
  addbt: {
    color: "#FFFFFF",
    textAlign: "center",
    borderInlineEnd: "2px solid #14AFF1",
    minWidth: "200px",
    height: "50px",
    fontSize: "20px",
    display: "flex",
  },
  add: {
    marginLeft: "638px",
    textAlign: "center",
    border: "1px solid #14AFF1",
    borderRadius: "10px",
    width: "120px",
    height: "45px",
    color: "#FFFFFF",
    backgroundColor: "#14AFF1",
  },
  can: {
    color: "#fff",
    border: "1px solid #fff",
    borderRadius: "10px",
    width: "500px",
    height: "45px",
  },
  clear: {
    color: "#fff",
    border: "1px solid #fff",
    borderRadius: "10px",
    width: "500px",
    height: "45px",
  },
  rootmain: {
    display: "flex",
    flexWrap: "wrap",
    backgroundColor: "#2A3E4C",
    color: "#FFFFFF",
  },
  label1: {
    margin: theme.spacing(1),
    color: "#97A1A9",
  },
  text1: {
    border: "1px solid #356680",
    borderRadius: "10px",
    opacity: "1",
    backgroundColor: "white",
    borderColor: "#356680",
    color: "Black",
  },
  root1: {
    flexGrow: 1,
    width: "100%",
  },
  grid: {
    width: "100%",
    margin: "0px",
    color: "#FFFFFF",
  },
}));
const styles = (theme) => ({
  root: {
    margin: 0,
    padding: theme.spacing(2),
  },
  closeButton: {
    position: "absolute",
    right: theme.spacing(1),
    top: theme.spacing(1),
    color: theme.palette.grey[500],
  },
});
const DialogTitle = withStyles(styles)((props) => {
  const { children, classes, onClose, ...other } = props;
  return (
    <MuiDialogTitle disableTypography className={classes.root} {...other}>
      <Typography variant="h6">{children}</Typography>
      {onClose ? (
        <IconButton
          aria-label="close"
          className={classes.closeButton}
          onClick={onClose}
        >
          <CloseIcon />
        </IconButton>
      ) : null}
    </MuiDialogTitle>
  );
});
const DialogContent = withStyles((theme) => ({
  root: {
    padding: theme.spacing(2),
  },
}))(MuiDialogContent);
const DialogActions = withStyles((theme) => ({
  root: {
    margin: 0,
    padding: theme.spacing(1),
  },
}))(MuiDialogActions);

export default function AddBtn(props) {
  const [open, setOpen] = React.useState(false);
  const [CUSTOMER_ORDER_ID, setCUSTOMER_ORDER_ID] = React.useState("");
  const [SALES_ORG, setSALES_ORG] = React.useState("");
  const [DISTRIBUTION_CHANNEL, setDISTRIBUTION_CHANNEL] = React.useState("");
  const [COMPANY_CODE, setCOMPANY_CODE] = React.useState("");
  const [ORDER_CREATION_DATE, setORDER_CREATION_DATE] = React.useState("");
  const [ORDER_AMOUNT, setORDER_AMOUNT] = React.useState("");
  const [ORDER_CURRENCY, setORDER_CURRENCY] = React.useState("");
  const [CUSTOMER_NUMBER, setCUSTOMER_NUMBER] = React.useState("");
  const [AMOUNT_IN_USD, setAMOUNT_IN_USD] = React.useState("");
  var checkBox = props.check;
  const classes = useStyles();
  const handleClickOpen = () => {
    if (checkBox.length === 0) {
      setOpen(true);
    } else {
      setOpen(false);
    }
  };
  const handleClose = () => {
    setOpen(false);
  };
  const handleFinalAdd = () => {
    console.log("Add Button Clicked");
    const data = {
      title: "MY FIRST WEB APP",
      body: "made in India",
    };
    try {
      axios
        .post(
          `http://localhost:8081/backend/InsertServlet?CUSTOMER_ORDER_ID=${CUSTOMER_ORDER_ID}&SALES_ORG=${SALES_ORG}&DISTRIBUTION_CHANNEL=${DISTRIBUTION_CHANNEL}&COMPANY_CODE=${COMPANY_CODE}&ORDER_CREATION_DATE=${ORDER_CREATION_DATE}&ORDER_AMOUNT=${ORDER_AMOUNT}&ORDER_CURRENCY=${ORDER_CURRENCY}&CUSTOMER_NUMBER=${CUSTOMER_NUMBER}&AMOUNT_IN_USD=${AMOUNT_IN_USD}`,
          data
        )
        .then((res) => console.log(res));
    } catch (error) {
      console.log("postError");
      console.log(error);
    }
    window.location.reload(false);
    handleClose();
  };
  return (
    <div>
      <Button
        className={classes.addbt}
        variant="outlined"
        onClick={handleClickOpen}
        startIcon={<AddIcon />}
      >
        Add
      </Button>
      <Dialog
        classes={{ paper: classes.paper }}
        onClose={handleClose}
        aria-labelledby="form-dialog-title"
        open={open}
      >
        <DialogTitle
          className={classes.divs}
          id="form-dialog-title"
          onClose={handleClose}
        >
          Add Invoice
        </DialogTitle>
        <DialogContent className={classes.divs} dividers>
          <form id="AddBtnForm" className="Form">
            <div style={{ padding: "10px" }}>
              <Box
                component="form"
                sx={{
                  "& .MuiTextField-root": { m: 1, width: "25ch" },
                }}
                noValidate
                autoComplete="off"
              >
                <div>
                  <TextField
                    id="outlined-textarea"
                    label="Customer Order ID"
                    fullWidth
                    variant="filled"
                    multiline
                    style={{
                      backgroundColor: "White",
                    }}
                    value={CUSTOMER_ORDER_ID}
                    onChange={(e) => setCUSTOMER_ORDER_ID(e.target.value)}
                  />
                  <TextField
                    id="outlined-textarea"
                    label="Sales Org"
                    fullWidth
                    variant="filled"
                    multiline
                    style={{
                      backgroundColor: "White",
                    }}
                    value={SALES_ORG}
                    onChange={(e) => setSALES_ORG(e.target.value)}
                  />
                  <TextField
                    id="outlined-textarea"
                    label="Distribution Channel"
                    fullWidth
                    variant="filled"
                    InputLabelProps={{ shrink: true, required: true }}
                    type="date"
                    style={{
                      backgroundColor: "White",
                    }}
                    value={DISTRIBUTION_CHANNEL}
                    onChange={(e) => setDISTRIBUTION_CHANNEL(e.target.value)}
                  />
                  <TextField
                    id="outlined-textarea"
                    label="Company Code"
                    fullWidth
                    variant="filled"
                    multiline
                    style={{
                      backgroundColor: "White",
                    }}
                    value={COMPANY_CODE}
                    onChange={(e) => setCOMPANY_CODE(e.target.value)}
                  />
                </div>
                <div>
                  <TextField
                    name="Date"
                    label="ORDER_CREATION_DATE"
                    fullWidth
                    variant="filled"
                    multiline
                    style={{
                      backgroundColor: "White",
                    }}
                    value={ORDER_CREATION_DATE}
                    onChange={(e) => setORDER_CREATION_DATE(e.target.value)}
                  />
                </div>
                <div>
                  <TextField
                    id="outlined-textarea"
                    label="Order Amount"
                    fullWidth
                    variant="filled"
                    multiline
                    style={{
                      backgroundColor: "White",
                    }}
                    value={ORDER_AMOUNT}
                    onChange={(e) => setORDER_AMOUNT(e.target.value)}
                  />
                  <TextField
                    id="outlined-textarea"
                    label="Order Currency"
                    fullWidth
                    variant="filled"
                    multiline
                    style={{
                      backgroundColor: "White",
                    }}
                    value={ORDER_CURRENCY}
                    onChange={(e) => setORDER_CURRENCY(e.target.value)}
                  />
                  <TextField
                    id="outlined-textarea"
                    label="Customer Number"
                    fullWidth
                    variant="filled"
                    multiline
                    style={{
                      backgroundColor: "White",
                    }}
                    value={CUSTOMER_NUMBER}
                    onChange={(e) => setCUSTOMER_NUMBER(e.target.value)}
                  />
                  <TextField
                    id="outlined-textarea"
                    label="Amount In USD"
                    multiline
                    fullWidth
                    variant="filled"
                    style={{
                      backgroundColor: "White",
                    }}
                    value={AMOUNT_IN_USD}
                    onChange={(e) => setAMOUNT_IN_USD(e.target.value)}
                  />
                </div>
              </Box>
            </div>
          </form>
        </DialogContent>
        <DialogActions className={classes.divs}>
          <Button
            className={classes.can}
            id="addt"
            onClick={handleFinalAdd}
            type="submit"
          >
            Add
          </Button>
          <Button className={classes.can} id="addcancel" onClick={handleClose}>
            Cancel
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
