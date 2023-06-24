import React from "react";

import abclogo from "../assets/abclogo.svg";
import hrclogo from "../assets/hrclogo.svg";
import "../styles/Header.css";

const Header = () => {
  return (
    <div className="header">
      <div className="upper">
        <div className="logocompany">
          <img src={abclogo} alt="ABC Product Logo" />
        </div>
        <div className="logohrc">
          <img src={hrclogo} alt="Highradius Logo" />
        </div>
      </div>
      <div className="lower">
        <h2 className="inv">Invoice List</h2>
      </div>
    </div>
  );
};

export default Header;
