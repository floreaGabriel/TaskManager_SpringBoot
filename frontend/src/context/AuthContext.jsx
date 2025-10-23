import React, { createContext, useState, useEffect } from "react";
import { getToken, logout as logoutService } from "../services/authService";

export const AuthContext = createContext();

export function AuthProvider({ children }) {
  const [token, setToken] = useState(getToken());

  useEffect(() => {
    setToken(getToken());
  }, []);

  function login(newToken) {
    localStorage.setItem("token", newToken);
    setToken(newToken);
  }

  function logout() {
    logoutService();
    setToken(null);
  }

  return (
    <AuthContext.Provider value={{ token, login, logout, isAuthenticated: !!token }}>
      {children}
    </AuthContext.Provider>
  );
}

