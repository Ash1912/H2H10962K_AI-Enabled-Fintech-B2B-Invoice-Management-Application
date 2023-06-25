import React, { useState } from "react";
import axios from "axios";
import "../styles/AddData.css";

const EditData = () => {
  const [formData, setFormData] = useState({
    slNo: "",
    customerOrderID: "",
    salesOrg: "",
    distributionChannel: "",
    customerNumber: "",
    companyCode: "",
    orderCurrency: "",
    amountInUsd: "",
    orderCreationDate: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const formParams = new URLSearchParams();
    for (let key in formData) {
      formParams.append(key, formData[key]);
    }
    axios
      .post(`http://localhost:8080/h2h_milestone_3/updateInvoice`, formParams)
      .then((response) => {
        if (response.data === "EDITED SUCCESSFULLY") {
          alert("Data updated successfully");
        } else {
          alert("Error occurred while updating data");
        }
      })
      .catch((error) => {
        console.error("Error occurred while updating data", error);
        alert("Error occurred while updating data");
      });
  };

  const clearForm = () => {
    setFormData({
      slNo: "",
      customerOrderID: "",
      salesOrg: "",
      distributionChannel: "",
      customerNumber: "",
      companyCode: "",
      orderCurrency: "",
      amountInUsd: "",
      orderCreationDate: "",
    });
  };

  return (
    <div>
      <div className="container">
        <div className="inp1">
          <input
            type="number"
            className="inputbox"
            placeholder="SL NO"
            name="slNo"
            value={formData.slNo}
            onChange={handleChange}
          />
        </div>
        <div className="inp2 ">
          <input
            type="number"
            className="inputbox"
            placeholder="CUSTOMER ORDER ID"
            name="customerOrderID"
            value={formData.customerOrderID}
            onChange={handleChange}
          />
        </div>
        <div className="inp3 ">
          <input
            type="number"
            className="inputbox"
            placeholder="SALES ORG"
            name="salesOrg"
            value={formData.salesOrg}
            onChange={handleChange}
          />
        </div>
        <div className="inp4">
          <input
            type="text"
            className="inputbox"
            placeholder="DISTRIBUTION CHANNEL"
            name="distributionChannel"
            value={formData.distributionChannel}
            onChange={handleChange}
          />
        </div>
        <div className="inp5">
          <input
            type="text"
            className="inputbox"
            placeholder="CUSTOMER NUMBER"
            name="customerNumber"
            value={formData.customerNumber}
            onChange={handleChange}
          />
        </div>
        <div className="inp6 ">
          <input
            type="text"
            className="inputbox"
            placeholder="COMPANY CODE"
            name="companyCode"
            value={formData.companyCode}
            onChange={handleChange}
          />
        </div>
        <div className="inp7 ">
          <input
            type="text"
            className="inputbox"
            placeholder="ORDER CURRENCY"
            name="orderCurrency"
            value={formData.orderCurrency}
            onChange={handleChange}
          />
        </div>
        <div className="inp8 ">
          <input
            type="number"
            className="inputbox"
            placeholder="AMOUNT IN USD"
            name="amountInUsd"
            value={formData.amountInUsd}
            onChange={handleChange}
          />
        </div>
        <div className="inp9 ">
          <input
            type="text"
            className="inputbox"
            placeholder="ORDER CREATION DATE"
            name="orderCreationDate"
            value={formData.orderCreationDate}
            onChange={handleChange}
          />
        </div>
      </div>
      <div className="form-button">
        <div className="btn1">
          <button className="form-btn button1" onClick={handleSubmit}>
            EDIT
          </button>
        </div>
        <div className="btn2">
          <button className="form-btn button2" onClick={clearForm}>
            CLEAR DATA
          </button>
        </div>
      </div>
    </div>
  );
};

export default EditData;
