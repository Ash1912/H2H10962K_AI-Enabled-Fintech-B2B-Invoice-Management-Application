import * as React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import { ThemeProvider, createTheme } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';



const renderWhiteTextCell = (params: GridCellParams) => {
  return (
    <div style={{ color: 'white' }}>
      {params.value}
    </div>
  );
};


const columns = [
  { field: 'id', headerName: 'SINo', width: 40, renderCell: renderWhiteTextCell },
  { field: 'CUSTOMERORDERID', headerName: 'CUSTOMERORDERID', width: 150, renderCell: renderWhiteTextCell },
  { field: 'SALESORG', headerName: 'SALESORG', width: 130, renderCell: renderWhiteTextCell },
  { field: 'DISTRIBUTIONCHANNEL', headerName: 'DISTRIBUTIONCHANNEL', width: 250, renderCell: renderWhiteTextCell },
  { field: 'COMPANYCODE', headerName: 'COMPANYCODE', width: 180, renderCell: renderWhiteTextCell },
  { field: 'ORDERCREATIONDATE', headerName: 'ORDERCREATIONDATE', width: 190, renderCell: renderWhiteTextCell },
  { field: 'ORDERAMOUNT', headerName: 'ORDERAMOUNT', width: 140, renderCell: renderWhiteTextCell },
  { field: 'ORDERCURRENCY', headerName: 'ORDERCURRENCY', width: 160, renderCell: renderWhiteTextCell },
  { field: 'CUSTOMERNUMBER', headerName: 'CUSTOMERNUMBER', width: 200, renderCell: renderWhiteTextCell },
];
const rows = [
  {
    id: 1,
    CUSTOMERORDERID: 754349803,
    SALESORG: 3911,
    DISTRIBUTIONCHANNEL: "United Arab Emirates",
    COMPANYCODE: 3290,
    ORDERCREATIONDATE: "01-01-2022",
    ORDERAMOUNT: 1405.54,
    ORDERCURRENCY: "AED",
    CUSTOMERNUMBER: 121049970,
  },
  {
    id: 2,
    CUSTOMERORDERID: 930253442,
    SALESORG: 2381,
    DISTRIBUTIONCHANNEL: "Greece",
    COMPANYCODE: 3290,
    ORDERCREATIONDATE: "01-01-2022",
    ORDERAMOUNT: 1441.4835,
    ORDERCURRENCY: "EUD",
    CUSTOMERNUMBER: 1210351400,
  },
  {
    id: 3,
    CUSTOMERORDERID: 819741436,
    SALESORG: 3605,
    DISTRIBUTIONCHANNEL: "Argentina",
    COMPANYCODE: 3290,
    ORDERCREATIONDATE: "01-01-2022",
    ORDERAMOUNT: 1065.33,
    ORDERCURRENCY: "EUR",
    CUSTOMERNUMBER: 1210124309,
  },
  {
    id: 4,
    CUSTOMERORDERID: 881355361,
    SALESORG: 3645,
    DISTRIBUTIONCHANNEL: "Armenia",
    COMPANYCODE: 3470,
    ORDERCREATIONDATE: "02-01-2022",
    ORDERAMOUNT: 302.85,
    ORDERCURRENCY: "EUR",
    CUSTOMERNUMBER: 12311152,
  },
  {
    id: 5,
    CUSTOMERORDERID: 821659852,
    SALESORG: 2470,
    DISTRIBUTIONCHANNEL: "United States of America",
    COMPANYCODE: 3220,
    ORDERCREATIONDATE: "02-01-2022",
    ORDERAMOUNT: 8380.69,
    ORDERCURRENCY: "EUR",
    CUSTOMERNUMBER: 1230021722,
  },
  {
    id: 6,
    CUSTOMERORDERID: 957194828,
    SALESORG: 3150,
    DISTRIBUTIONCHANNEL: "United States Minor Outlying Islands",
    COMPANYCODE: 3290,
    ORDERCREATIONDATE: "02-01-2022",
    ORDERAMOUNT: 545.85,
    ORDERCURRENCY: "EUR",
    CUSTOMERNUMBER: 1210183107,
  },
  {
    id: 7,
    CUSTOMERORDERID: 806322513,
    SALESORG: 3396,
    DISTRIBUTIONCHANNEL: "Serbia",
    COMPANYCODE: 3290,
    ORDERCREATIONDATE: "02-01-2022",
    ORDERAMOUNT: 545.85,
    ORDERCURRENCY: "EUR",
    CUSTOMERNUMBER: 1210499770,
  },
  {
    id: 8,
    CUSTOMERORDERID: 922237131,
    SALESORG: 2353,
    DISTRIBUTIONCHANNEL: "Turks and Caicos Islands",
    COMPANYCODE: 3290,
    ORDERCREATIONDATE: "02-01-2022",
    ORDERAMOUNT: 562.73,
    ORDERCURRENCY: "EUR",
    CUSTOMERNUMBER: 1210111951,
  },
];

const whiteTheme = createTheme({
  palette: {
    mode: 'light',

    primary: {
      main: '#ffffff', // Set the primary color to white
    },

    text: {
      primary: '#ffffff', // Set the primary text color to white
    },

    // checkboxSelection:
    // {
    //   main: '#ffffff',
    // }
  },
});


export default function App() {
  const [selectedRows, setSelectedRows] = React.useState([]);

  const handleRowSelection = (newSelection) => {
    setSelectedRows(newSelection.selectionModel);
  };

  const gridOptions = {
    checkboxSelection: true,
    rowSelection: true,
    autoHeight: false,
  };

  return (
    <ThemeProvider theme={whiteTheme}>
      <CssBaseline />
    <div style={{ border: '5px solid rgb(247, 119, 15)', borderRadius: 3, height: '100%' ,background:'rgb(54, 57, 58)' }}>
      <div class="tb" >
        <DataGrid
          rows={rows}
          columns={columns}
          checkboxSelection
          onSelectionModelChange={handleRowSelection}
          selectionModel={selectedRows}
          {...gridOptions}
          disablePagination
        />
      </div>
    </div>
    </ThemeProvider>
  );
}