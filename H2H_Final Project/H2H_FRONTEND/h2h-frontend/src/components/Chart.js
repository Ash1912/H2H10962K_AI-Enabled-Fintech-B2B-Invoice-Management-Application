import React, { useState, useEffect } from "react";
import axios from "axios";
import Dialog from "@mui/material/Dialog";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import IconButton from "@mui/material/IconButton";
import CloseIcon from "@mui/icons-material/Close";
import Slide from "@mui/material/Slide";

import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";
import { Bar } from "react-chartjs-2";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);
const Transition = React.forwardRef(function Transition(props, ref) {
  return <Slide direction="up" ref={ref} {...props} />;
});

function Chart() {
  const [open, setOpen] = React.useState(true);
  const handleClose = () => {
    setOpen(false);
    window.location.reload(false);
  };

  const [chartData, setChartData] = useState(null);
  const [AMOUNT_IN_USD, setAMOUNT_IN_USD] = useState(null);
  const [CUSTOMER_NUMBER, setCUSTOMER_NUMBER] = useState(null);
  useEffect(() => {
    axios.get(`http://localhost:8081/backend/AnalyticsServlet`).then((res) => {
      console.log(res.data);
      setChartData(...res.data);
      setAMOUNT_IN_USD(res.data[0].AMOUNT_IN_USD);
      setCUSTOMER_NUMBER(res.data[0].CUSTOMER_NUMBER);
    }, []);
  }, []);
  console.log(chartData);
  console.log(AMOUNT_IN_USD);
  console.log(CUSTOMER_NUMBER);
  const options = {
    responsive: true,
    plugins: {
      title: {
        display: true,
        text: "Analytics View Data",
      },
      scales: {
        yAxes: [
          {
            ticks: {
              min: 0,
              max: 100,
              stepSize: 10,
            },
          },
        ],
      },
      font: {
        size: 12,
        family: "tahoma",
        weight: "normal",
        style: "italic",
      },
    },
  };
  const labels = ["Martinique", "Moldova", "United Arab Emirates"];
  const data = {
    labels,
    title: {
      display: true,
      text: "Chart Title",
    },
    subtitle: {
      display: true,
      text: "Chart Subtitle",
      color: "blue",
      font: {
        size: 12,
        family: "tahoma",
        weight: "normal",
        style: "italic",
      },
    },
    datasets: [
      {
        label: "Customer Number",
        data: CUSTOMER_NUMBER,
        backgroundColor: "rgba(255, 99, 132, 0.5)",
      },
      {
        label: "Amount In USD",
        data: AMOUNT_IN_USD,
        backgroundColor: "rgba(53, 162, 235, 0.5)",
      },
    ],
  };

  return (
    <Dialog
      fullScreen
      open={open}
      onClose={handleClose}
      TransitionComponent={Transition}
    >
      <AppBar sx={{ position: "relative" }}>
        <Toolbar>
          <IconButton
            edge="start"
            color="inherit"
            onClick={handleClose}
            aria-label="close"
          >
            <CloseIcon />
          </IconButton>
        </Toolbar>
      </AppBar>
      <Bar options={options} data={data} />;
    </Dialog>
  );
}
export default Chart;
