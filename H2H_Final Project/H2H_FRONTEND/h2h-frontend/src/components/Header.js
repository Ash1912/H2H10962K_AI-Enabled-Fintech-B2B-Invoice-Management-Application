import React, { Component } from "react";
import "./header.css";
import abclogo from "./assets/abclogo.svg";
import logo from "./assets/hrclogo.svg";

export class Header extends Component {
  render() {
    return (
      <div className="property">
        <div className="image">
          <img src={abclogo} alt="ABC Logo" />
          <p className="invoice">Invoice List</p>
        </div>
        <div className="logo">
          <img src={logo} alt="HRC Logo" />
        </div>
      </div>
    );
  }
}
export default Header;
