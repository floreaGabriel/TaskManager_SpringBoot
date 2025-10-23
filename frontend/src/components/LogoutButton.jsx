import React, { useContext } from 'react';
import { AuthContext } from '../context/AuthContext';
import { useNavigate } from 'react-router-dom';

export default function LogoutButton() {
  const { logout } = useContext(AuthContext);
  const navigate = useNavigate();

  function handleLogout() {
    logout();
    navigate('/login');
  }

  return (
    <button
      onClick={handleLogout}
      style={{
        position: "fixed",
        left: "18px",
        bottom: "26px",
        zIndex: 1100,
        padding: "0.7rem 1.3rem",
        borderRadius: "8px",
        background: "#480E0E",
        color: "#FF3A3A",
        fontSize: "1rem",
        fontWeight: "bold",
        boxShadow: "0 4px 16px rgba(18,24,38,0.53)",
        border: "none",
        cursor: "pointer"
      }}
      aria-label="Logout"
    >
      Logout
    </button>
  );
}

