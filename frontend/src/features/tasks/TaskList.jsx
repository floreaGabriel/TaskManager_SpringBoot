import TaskCard from './TaskCard.jsx';

export default function TaskList({ tasks, onDelete, onEdit, onToggleCompleted }) {
    if (!tasks.length) return <p style={{ color: '#888', textAlign: 'center', marginTop: '3rem' }}>No tasks found.</p>;
    return (
        <div className="flex flex-col items-center w-full">
            {tasks.map((t) => (
                <TaskCard
                    key={t.id}
                    task = {t}
                    onDelete = {onDelete}
                    onEdit = {onEdit}
                    onToggleCompleted={onToggleCompleted}
                />
            ))}
        </div>
    );
}

