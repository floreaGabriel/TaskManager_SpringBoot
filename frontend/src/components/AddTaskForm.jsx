import React, { useState, useEffect } from 'react';

const categories = ["General", "School", "Business", "Personal", "Urgent"];
const priorities = [
  { value: "LOW", label: "Low" },
  { value: "MEDIUM", label: "Medium" },
  { value: "HIGH", label: "High" }
];

export default function AddTaskForm({ onAdd, onClose, initialData }) {
  const [title, setTitle] = useState(initialData?.title || '');
  const [description, setDescription] = useState(initialData?.description || '');
  const [category, setCategory] = useState(initialData?.category || 'General');
  const [priority, setPriority] = useState(initialData?.priority || 'LOW');
  const [deadline, setDeadline] = useState(initialData?.deadline || '');

  useEffect(() => {
    if (initialData) {
      setTitle(initialData.title || '');
      setDescription(initialData.description || '');
      setCategory(initialData.category || 'General');
      setPriority(initialData.priority || 'LOW');
      setDeadline(initialData.deadline || '');
    }
  }, [initialData]);

  async function handleSubmit(e) {
    e.preventDefault();
    await onAdd({ title, description, category, priority, deadline: deadline || null });
    onClose();
  }

  return (
    <form onSubmit={handleSubmit} style={{ display: "flex", flexDirection: "column", gap: "1rem" }}>
      <h2 style={{ color: "#26FCC9", fontWeight: 700 }}>{initialData ? 'Edit Task' : 'Add Task'}</h2>
      <input
        type="text"
        required
        minLength={3}
        maxLength={100}
        placeholder="Task title"
        value={title}
        onChange={e => setTitle(e.target.value)}
        style={{ padding: "1rem", fontSize: 18, borderRadius: 8, background: "#181F2E", color: "#fff", border: "1px solid #252C3D" }}
      />
      <textarea
        maxLength={500}
        placeholder="Description"
        value={description}
        onChange={e => setDescription(e.target.value)}
        style={{ padding: "1rem", fontSize: 16, borderRadius: 8, background: "#181F2E", color: "#fff", border: "1px solid #252C3D", minHeight: 80 }}
      />
      <div style={{ display: 'flex', gap: '1rem' }}>
        <select value={priority} onChange={e => setPriority(e.target.value)}
          style={{ flex:1, padding: "0.7rem", fontSize: 16, borderRadius: 8, background: "#181F2E", color: "#fff", border: "1px solid #252C3D" }}>
          {priorities.map(p => <option key={p.value} value={p.value}>{p.label}</option>)}
        </select>
        <select value={category} onChange={e => setCategory(e.target.value)}
          style={{ flex:1, padding: "0.7rem", fontSize: 16, borderRadius: 8, background: "#181F2E", color: "#fff", border: "1px solid #252C3D" }}>
          {categories.map(c => <option key={c} value={c}>{c}</option>)}
        </select>
      </div>
      <input
        type="datetime-local"
        value={deadline}
        onChange={e => setDeadline(e.target.value)}
        style={{ padding: "0.7rem", fontSize: 16, borderRadius: 8, background: "#181F2E", color: "#fff", border: "1px solid #252C3D" }}
      />
      <div style={{ display: 'flex', gap: '1rem', marginTop: '8px', justifyContent: 'center' }}>
        <button type="submit" style={{ background:'#228af9', color:'#fff', border:'none', borderRadius:8, padding:'0.7rem 1.5rem', fontWeight:600, fontSize:16, cursor:'pointer' }}>
          {initialData ? 'Update Task' : 'Add Task'}
        </button>
        <button type="button" onClick={onClose} style={{ background:'#252C3D', color:'#26FCC9', border:'none', borderRadius:8, padding:'0.7rem 1.2rem', fontWeight:600, fontSize:16, cursor:'pointer' }}>Cancel</button>
      </div>
    </form>
  );
}

