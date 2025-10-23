import React from 'react';

export default function Modal({ children, onClose }) {
  return (
    <div
      style={{
        position: 'fixed',
        left: 0, top: 0, width: '100vw', height: '100vh',
        zIndex: 1000,
        background: 'rgba(18, 24, 38, 0.8)',
        backdropFilter: 'blur(6px)',
        display: 'flex', alignItems: 'center', justifyContent: 'center',
      }}
      onClick={onClose}
    >
      <div
        style={{
          background: '#171F2A',
          borderRadius: 16,
          minWidth: 400,
          maxWidth: 650,
          width: '100%',
          padding: '2rem',
          boxShadow: '0 8px 32px rgba(0,0,0,0.4)',
          color: '#fafafa',
          position: 'relative',
          margin: '3rem',
        }}
        onClick={e => e.stopPropagation()}
      >
        <button
          aria-label="Close"
          style={{
            position: 'absolute', top: 12, right: 14,
            border: 'none', background: 'none', fontSize: 24,
            color: '#26FCC9', cursor: 'pointer',
          }}
          onClick={onClose}
        >
          ×
        </button>
        {children}
      </div>
    </div>
  );
}

