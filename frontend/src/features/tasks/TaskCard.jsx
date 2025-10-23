import React, { useState } from 'react';
import styles from './TaskCard.module.css';

function getPriorityClass(priority) {
    if (priority === "LOW") return styles.priorityLow;
    if (priority === "MEDIUM") return styles.priorityMedium;
    if (priority === "HIGH") return styles.priorityHigh;
    return styles.priorityLow;
}

export default function TaskCard({ task, onDelete, onEdit, onToggleCompleted }) {
    const [expanded, setExpanded] = useState(false);

    const { id, title, description, priority, category, deadline, completed } = task;

    async function handleDelete() {
        if (window.confirm(`Delete task "${title}"?`)) {
            await onDelete(id);
        }
    }
    async function handleToggleCompleted() {
        await onToggleCompleted(id);
    }
    return (
        <div className={`${styles.card} ${completed ? styles.completedCard : ''}`}>
            <div className={styles.headerRow}>
                <div style={{ display: "flex", alignItems: "center", gap: "10px", flexWrap: "wrap" }}>
                    <h2 className={styles.cardTitle}>{title}</h2>
                    <span className={`${styles.priority} ${getPriorityClass(priority)}`}>{priority}</span>
                    <span className={styles.category}>{category}</span>
                </div>
                <div className={styles.cardRight}>
                    {deadline &&
                        <span className={styles.deadline}>
                            {new Date(deadline).toLocaleDateString(undefined, {
                                day: '2-digit',
                                month: '2-digit',
                                year: '2-digit',
                                hour: '2-digit',
                                minute: '2-digit'
                            })}
                        </span>
                    }
                    <button
                        className={`${styles.toggleCompletedBtn} ${completed ? styles.checked : ''}`}
                        onClick={handleToggleCompleted}
                        aria-label={completed ? "Completed" : "Mark as completed"}
                        tabIndex={0}
                    >
                        {completed ? (
                            <svg width={22} height={22} viewBox="0 0 24 24" fill="none">
                                <circle cx="12" cy="12" r="10" fill="#228AF9" />
                                <path d="M7 13l3 3 7-7" stroke="#fff" strokeWidth="2" fill="none" />
                            </svg>
                        ) : (
                            <svg width={22} height={22} viewBox="0 0 24 24" fill="none">
                                <circle cx="12" cy="12" r="10" stroke="#228AF9" strokeWidth="2" fill="none" />
                            </svg>
                        )}
                    </button>
                    <button
                        className={styles.expandBtn}
                        aria-label={expanded ? "Hide details" : "Show more"}
                        onClick={() => setExpanded(e => !e)}
                    >
                        <svg
                            width={22}
                            height={22}
                            style={{
                                transition: 'transform 0.25s',
                                transform: expanded ? 'rotate(90deg)' : 'rotate(0deg)'
                            }}
                            viewBox="0 0 24 24"
                        >
                            <polyline points="7 10 12 15 17 10" fill="none" stroke="#FFD92F" strokeWidth={2} />
                        </svg>
                    </button>
                </div>
            </div>
            <p className={styles.cardDesc}>
                {expanded
                    ? description
                    : (description && description.length > 100
                        ? description.substring(0, 100) + "..."
                        : description
                    )
                }
            </p>
            {expanded && (
                <div className={styles.expandedArea}>
                    <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", marginTop: 16, gap: 10 }}>
                        <button className={styles.editBtn} onClick={() => onEdit(task)}>
                            Edit
                        </button>
                        <button className={styles.deleteBtn} onClick={handleDelete}>
                            Delete
                        </button>
                    </div>
                </div>
            )}
        </div>
    );
}

