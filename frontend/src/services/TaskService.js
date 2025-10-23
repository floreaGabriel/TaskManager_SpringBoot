const API_URL = import.meta.env.VITE_API_URL;

function getAuthHeaders() {
    const token = localStorage.getItem("token");
    return token ? { "Authorization": `Bearer ${token}`, "Content-Type": "application/json" } : { "Content-Type": "application/json" };
}

export async function fetchTasks() {
    const res = await fetch(`${API_URL}/tasks`, { headers: getAuthHeaders() });
    if (!res.ok) throw new Error("Failed to fetch tasks.");
    return await res.json();
}

export async function addTask(task) {
    const res = await fetch(`${API_URL}/tasks`, {
        method: "POST",
        headers: getAuthHeaders(),
        body: JSON.stringify(task)
    });
    if (!res.ok) throw new Error("Failed to add task.");
    return await res.json();
}

export async function toggleTaskCompleted(taskId) {
    const res = await fetch(`${API_URL}/tasks/${taskId}/toggle`, {
        method: "PATCH",
        headers: getAuthHeaders()
    });
    if (!res.ok) throw new Error("Failed to toggle task.");
    return await res.json();
}

export async function deleteTask(taskId) {
    const res = await fetch(`${API_URL}/tasks/${taskId}`, {
        method: "DELETE",
        headers: getAuthHeaders()
    });
    if (!res.ok) throw new Error("Failed to delete task.");
}

export async function updateTask(taskId, taskData) {
    const res = await fetch(`${API_URL}/tasks/${taskId}`, {
        method: "PUT",
        headers: getAuthHeaders(),
        body: JSON.stringify(taskData)
    });
    if (!res.ok) throw new Error("Failed to update task.");
    return await res.json();
}

