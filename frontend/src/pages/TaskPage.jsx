import Navbar from '../components/Navbar';
import TaskList from '../features/tasks/TaskList';
import { useEffect, useState } from 'react';
import { addTask, fetchTasks, updateTask, toggleTaskCompleted } from '../services/TaskService';
import AddTaskForm from '../components/AddTaskForm';
import Modal from '../components/Modal.jsx';
import AddTaskButton from '../components/AddTaskButton.jsx';
import useIsMobile from '../hooks/useIsMobile.js';
import LogoutButton from '../components/LogoutButton.jsx';

export default function TaskPage() {
    const isMobile = useIsMobile(500);

    const [tasks, setTasks] = useState([]);
    const [loading, setLoading] = useState(true);
    const [showModal, setShowModal] = useState(false);
    const [editingTask, setEditingTask] = useState(null);

    useEffect(() => {
        fetchTasks()
            .then(setTasks)
            .catch(console.error)
            .finally(() => setLoading(false));
    }, []);

    if (loading) return <p>Loading ...</p>;
    // if (error) return <p style={{ color: 'red' }}>Error: {error}</p>;

    async function handleDeleteTask(taskId) {
        try {
            await deleteTask(taskId);
            setTasks(prev => prev.filter(t => t.id !== taskId));
        } catch (err) {
            alert(err.message);
        }
    }

    function handleEditTask(task) {
        setEditingTask(task);
        setShowModal(true); // deschide modalul de edit (refolosești AddTaskForm sau faci EditTaskForm)
    }
    function handleAddTaskBtn() {
        setShowModal(true);
    }
    async function handleToggleCompleted(taskId) {
        try {
            const updatedTask = await toggleTaskCompleted(taskId);
            setTasks(prev => prev.map(t => t.id === taskId ? updatedTask : t));
        } catch (error) {
            alert(error.message);
        }
    }
    async function handleAddTask(newTask) {
        try {
            const savedTask = await addTask(newTask);
            setTasks(prev => [...prev, savedTask]);
        } catch (error) {
            alert(error.message);
        }
    }
    async function handleUpdateTask(updatedTask) {
        try {
            const savedTask = await updateTask(editingTask.id, updatedTask);
            setTasks(prev => prev.map(t => t.id === editingTask.id ? savedTask : t));
            setShowModal(false);
            setEditingTask(null);
        } catch (error) {
            alert(error.message);
        }
    }

    return (
        <div className="min-h-screen bg-black">
            <Navbar onAddTask={handleAddTaskBtn} />
            <LogoutButton />
            {isMobile && <AddTaskButton onClick={handleAddTaskBtn} isFab />}
            <div className="px-8 py-6">
                {showModal && (
                    <Modal onClose={() => { setShowModal(false); setEditingTask(null); }}>
                        <AddTaskForm
                            onAdd={editingTask ? handleUpdateTask : handleAddTask}
                            onClose={() => { setShowModal(false); setEditingTask(null); }}
                            initialData={editingTask}
                        />
                    </Modal>
                )}
                <TaskList tasks={tasks} onDelete={handleDeleteTask} onEdit={handleEditTask} onToggleCompleted={handleToggleCompleted} />
            </div>
        </div>
    );
}

