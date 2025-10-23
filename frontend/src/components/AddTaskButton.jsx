export default function AddTaskButton({ onClick, isFab = false }) {
  if (isFab) {
    return (
      <button
        onClick={onClick}
        style={{
          position: "fixed",
          right: "18px",
          bottom: "26px",
          zIndex: 1100,
          width: "62px",
          height: "62px",
          borderRadius: "50%",
          background: "#228AF9",
          color: "#fff",
          fontSize: "2rem",
          fontWeight: "bold",
          boxShadow: "0 4px 16px rgba(18,24,38,0.53)",
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
          border: "none",
          cursor: "pointer"
        }}
        aria-label="Add Task"
      >
        +
      </button>
    );
  }
  return (
    <button onClick={onClick} className="bg-blue-500 text-white p-2 rounded">
      + Add Task
    </button>
  );
}

