import React, { useState } from "react";
import DataTable from "./DataTable";
import Footer from "./Footer";
import GridButton from "./GridButton";

function Grid() {
  const [check, setCheck] = useState([]);
  const [q, setQ] = useState("");
  const [columns, setColumns] = useState(["cust_number"]);
  const [data, setData] = useState(null);

  let [CUSTOMER_ORDER_ID, setCUSTOMER_ORDER_ID] = React.useState("");
  let [CUSTOMERORDERIDdata, setCUSTOMERORDERIDData] = React.useState("");
  let [CUSTOMER_NUMBER, setCUSTOMER_NUMBER] = React.useState("");

  console.log("Check Box data :" + data);
  console.log("Sl_no values :" + check);
  console.log("Customer Order Id data :" + CUSTOMERORDERIDdata);
  return (
    <div>
      <div className="table">
        <GridButton
          check={check}
          q={q}
          setQ={setQ}
          setColumnsChange={(cols) => setColumns(cols)}
          setCUSTOMER_ORDER_IDChange={(CUSTOMERORDERID) =>
            setCUSTOMER_ORDER_ID(CUSTOMERORDERID)
          }
          setCUSTOMER_NUMBERChange={(CUSTOMERNUMBER) =>
            setCUSTOMER_NUMBER(CUSTOMERNUMBER)
          }
          checkBoxData={data}
          docIDsend={CUSTOMERORDERIDdata}
        />
        <div>
          <DataTable
            changeCheck={(check) => setCheck(check)}
            q={q}
            columns={columns}
            CUSTOMER_ORDER_ID={CUSTOMER_ORDER_ID}
            CUSTOMER_NUMBER={CUSTOMER_NUMBER}
            changsetData={(data) => setData(data)}
            changeCUSTOMERORDERIDdata={(CUSTOMERORDERIDdata) =>
              setCUSTOMERORDERIDData(CUSTOMERORDERIDdata)
            }
          />
        </div>
      </div>
      <div>
        <Footer />
      </div>
    </div>
  );
}
export default Grid;
