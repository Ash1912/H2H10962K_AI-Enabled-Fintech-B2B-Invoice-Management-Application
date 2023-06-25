import React, { useState } from "react";
import "../styles/AddData.css";

const AnalyticsView = () => {
  const [formData, setFormData] = useState({
    distributionChannel: "",
    customerNumber: "",
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
  };
  return (
    <div>
      <div className="analytics-container">
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
      </div>
      <div className="form-button">
        <div className="btn1">
          <button className="form-btn button1" onClick={handleSubmit}>
            VIEW
          </button>
        </div>
      </div>
    </div>
  );
};

export default AnalyticsView;
