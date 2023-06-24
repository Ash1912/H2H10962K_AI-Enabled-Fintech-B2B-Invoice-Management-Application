import React, { useState } from "react";
import Button from "@material-ui/core/Button";
import { makeStyles } from "@material-ui/core/styles";
import { withStyles } from "@material-ui/core/styles";
import "./grid.css";
import Dialog from "@material-ui/core/Dialog";
import MuiDialogTitle from "@material-ui/core/DialogTitle";
import MuiDialogContent from "@material-ui/core/DialogContent";
import MuiDialogActions from "@material-ui/core/DialogActions";
import IconButton from "@material-ui/core/IconButton";
import CloseIcon from "@material-ui/icons/Close";
import Typography from "@material-ui/core/Typography";
import TextField from "@material-ui/core/TextField";
import Grid from "@material-ui/core/Grid";
const useStyles = makeStyles((theme) => ({
  divs: {
    backgroundColor: "#39495E",
    color: "#FFFFFF",
    fontFamily: "Ubuntu",
  },
  add: {
    color: "#FFFFFF",
    marginTop: "30px",
    marginLeft: "638px",
    textAlign: "center",
    border: "1px solid #14AFF1",
    borderRadius: "10px",
    width: "99px",
    height: "45px",
    textTransform: "none",
    fontSize: "20px",
  },
  btngrp: {
    color: "#FFFFFF",
    textAlign: "center",
    border: "1px solid #14AFF1",
    borderRadius: "5px",
    margin: theme.spacing(1),
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
  predict: {
    width: "170px",
    height: "45px",
    background: "#488fc9",
    borderRadius: "5px",
    textAlign: "left",
    color: "#FFFFFF",
    fontSize: "20px",
    textTransform: "none",
  },
  view: {
    marginLeft: "10px",
    display: "inline-block",
  },
  search: {
    marginLeft: "20px",
    display: "inline-block",
  },
  adbtn: {
    marginLeft: "10px",
    display: "inline-block",
  },
  dlt: {
    marginLeft: "10px",
    display: "inline-block",
  },
  prdt: {
    marginLeft: "15px",
    marginRight: "15px",
    display: "inline-block",
    marginTop: "6px",
    alignContent: "center",
  },
  ana: {
    color: "#FFFFFF",
    textAlign: "center",
    borderInlineEnd: "2px solid #14AFF1",
    width: "200px",
    height: "50px",
    fontSize: "15px",
  },
  label1: {
    margin: theme.spacing(1),
    color: "#97A1A9",
  },
  text1: {
    margin: theme.spacing(1),
    border: "1px solid #356680",
    borderRadius: "10px",
    opacity: "1",
    backgroundColor: "#FFFFFF",
    borderColor: "#356680",
  },
  root1: {
    flexGrow: 1,
    width: "100%",
  },
  grid: {
    width: "100%",
    margin: "0px",
  },
  icon: {
    display: "inline-block",
    width: "4%",
    border: "1px solid #14AFF1",
    alignItems: "center",
    color: "#14AFF1",
    marginLeft: "10px",
  },
  form: {
    display: "inline-block",
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

function AdvanceSearch(props) {
  var checkBox = props.check;
  let [CUSTOMER_ORDER_ID, setCUSTOMER_ORDER_ID] = useState("");

  let [CUSTOMER_NUMBER, setCUSTOMER_NUMBER] = useState("");
  let [SALES_ORG, setSALES_ORG] = useState("");
  const classes = useStyles();
  const [open, setOpen] = useState(false);
  const handleClickOpen = () => {
    if (checkBox.length === 0) {
      setOpen(true);
      props.setColumnsChange([
        "CUSTOMER_ORDER_ID",
        "CUSTOMER_NUMBER",
        "SALES_ORG",
      ]);
    } else {
      setOpen(false);
    }
  };
  const handleClose = () => {
    setOpen(false);
  };
  const handleCUSTOMER_ORDER_IDChange = (event) => {
    setCUSTOMER_ORDER_ID(event.target.value);
  };
  const handleCUSTOMER_NUMBERChange = (event) => {
    setCUSTOMER_NUMBER(event.target.value);
  };

  const handleSALES_ORGChange = (event) => {
    setSALES_ORG(event.target.value);
  };
  const handlSearch = () => {
    props.setCUSTOMER_ORDER_IDChange(CUSTOMER_ORDER_ID);
    props.setCUSTOMER_NUMBERChange(CUSTOMER_NUMBER);
    props.setSALES_ORGChange(SALES_ORG);
    handleClose();
  };
  return (
    <div>
      <Button
        className={classes.ana}
        variant="outlined"
        onClick={handleClickOpen}
      >
        Advance Search
      </Button>
      <Dialog
        width="70%"
        onClose={handleClose}
        aria-labelledby="form-dialog-title1"
        open={open}
      >
        <DialogTitle
          className={classes.divs}
          id="form-dialog-title1"
          onClose={handleClose}
        >
          Advance Search
        </DialogTitle>
        <DialogContent className={classes.divs} dividers>
          <form
            className={classes.root}
            noValidate
            autoComplete="off"
            action=""
            id="AdvancedSearchForm"
          >
            <Grid container width="55%">
              <Grid item xs={6} direction="row">
                <TextField
                  className={classes.text1}
                  id="CUSTOMER_ORDER_ID"
                  variant="outlined"
                  name="CUSTOMER_ORDER_ID"
                  value={CUSTOMER_ORDER_ID}
                  onChange={handleCUSTOMER_ORDER_IDChange}
                  display="inline-block"
                  required
                  type="no"
                  placeholder="CUSTOMER ORDER ID"
                />
              </Grid>
              <Grid item xs={6} direction="row">
                <TextField
                  className={classes.text1}
                  id="CUSTOMER_NUMBER"
                  variant="outlined"
                  name="CUSTOMER_NUMBER"
                  value={CUSTOMER_NUMBER}
                  onChange={handleCUSTOMER_NUMBERChange}
                  display="inline-block"
                  placeholder="Customer Number"
                />
              </Grid>
              <Grid item xs={6} direction="row">
                <TextField
                  className={classes.text1}
                  id="SALES_ORG"
                  variant="outlined"
                  name="SALES_ORG"
                  value={SALES_ORG}
                  onChange={handleSALES_ORGChange}
                  display="inline-block"
                  placeholder="SALES ORG"
                />
              </Grid>
            </Grid>
          </form>
        </DialogContent>
        <DialogActions className={classes.divs}>
          <Button className={classes.can} id="edtcancel" onClick={handlSearch}>
            Search
          </Button>
          <Button className={classes.clear} id="edtreset" onClick={handleClose}>
            Cancel
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
export default AdvanceSearch;
