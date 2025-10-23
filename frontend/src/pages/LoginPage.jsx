import React, { useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { login as loginService } from '../services/authService';
import { AuthContext } from '../context/AuthContext';

export default function LoginPage() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const { login } = useContext(AuthContext);
  const navigate = useNavigate();

  async function handleLogin(e) {
    e.preventDefault();
    try {
      const data = await loginService(username, password);
      login(data.token);
      navigate('/tasks');
    } catch (err) {
      alert(err.message);
    }
  }

  return (
    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '100vh', background: '#000' }}>
      <form onSubmit={handleLogin} style={{ background: '#171F2A', padding: '2rem', borderRadius: 12, minWidth: 320 }}>
        <h2 style={{ color: '#26FCC9' }}>Login</h2>
        <input type="text" placeholder="Username" value={username} onChange={e => setUsername(e.target.value)} required
          style={{ width: '100%', padding: '0.7rem', margin: '0.5rem 0', borderRadius: 8, background: '#242C3D', color: '#fff', border: '1px solid #333' }} />
        <input type="password" placeholder="Password" value={password} onChange={e => setPassword(e.target.value)} required
          style={{ width: '100%', padding: '0.7rem', margin: '0.5rem 0', borderRadius: 8, background: '#242C3D', color: '#fff', border: '1px solid #333' }} />
        <button type="submit" style={{ width: '100%', padding: '0.7rem', background: '#228AF9', color: '#fff', borderRadius: 8, border: 'none', cursor: 'pointer', fontWeight: 'bold' }}>Login</button>
        <p style={{ color: '#888', marginTop: 10 }}>Don't have an account? <a href="/register" style={{ color: '#26FCC9' }}>Register</a></p>
      </form>
    </div>
  );
}

