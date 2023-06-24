import React, { useState } from "react";

const Table = () => {
  // Static data for the table
  const data = [
    {
      SINo: 1,
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
      SINo: 2,
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
      SINo: 3,
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
      SINo: 4,
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
      SINo: 5,
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
      SINo: 6,
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
      SINo: 7,
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
      SINo: 8,
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

  // State to keep track of selected items
  const [selectedItems, setSelectedItems] = useState([]);

  // Function to handle checkbox change
  const handleCheckboxChange = (item) => {
    if (selectedItems.includes(item.SINo)) {
      setSelectedItems(selectedItems.filter((id) => id !== item.SINo));
    } else {
      setSelectedItems([...selectedItems, item.SINo]);
    }
  };

  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        height: "100vh",
      }}
    >
      <table
        style={{
          backgroundColor: "grey",
          color: "white",
          border: "10px solid orange",
          fontFamily: "Comic Sans MS",
        }}
      >
        <thead>
          <tr>
            <th>
              <input type="checkbox" />
            </th>
            <th>SI No</th>
            <th>CUSTOMER ORDER ID</th>
            <th>SALES ORG</th>
            <th>DISTRIBUTION CHANNEL</th>
            <th>COMPANY CODE</th>
            <th>ORDER CREATION DATE</th>
            <th>ORDER AMOUNT</th>
            <th>ORDER CURRENCY</th>
            <th>CUSTOMER NUMBER</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item) => (
            <tr
              key={item.SINo}
              style={{
                backgroundColor: "grey",
                color: "white",
                margin: "10px 0",
              }}
            >
              <td>
                <input
                  type="checkbox"
                  checked={selectedItems.includes(item.SINo)}
                  onChange={() => handleCheckboxChange(item)}
                />
              </td>
              <td style={{ border: "1px solid white" }}>{item.SINo}</td>
              <td style={{ border: "1px solid white" }}>
                {item.CUSTOMERORDERID}
              </td>
              <td style={{ border: "1px solid white" }}>{item.SALESORG}</td>
              <td style={{ border: "1px solid white" }}>
                {item.DISTRIBUTIONCHANNEL}
              </td>
              <td style={{ border: "1px solid white" }}>{item.COMPANYCODE}</td>
              <td style={{ border: "1px solid white" }}>
                {item.ORDERCREATIONDATE}
              </td>
              <td style={{ border: "1px solid white" }}>{item.ORDERAMOUNT}</td>
              <td style={{ border: "1px solid white" }}>
                {item.ORDERCURRENCY}
              </td>
              <td style={{ border: "1px solid white" }}>
                {item.CUSTOMERNUMBER}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Table;
