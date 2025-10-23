import styles from './Navbar.module.css';
import Logo from './Logo.jsx';
import AddTaskButton from './AddTaskButton.jsx';

export default function Navbar({ onAddTask }) {
  return (
    <nav className={styles.navbar}>
      <div className={styles.left}>
        <Logo />
      </div>
      <h1 className={styles.title}>
        <span className={styles.gradientText}>
          Task Manager
        </span>
      </h1>
      <div className={styles.addButton}>
        <AddTaskButton onClick={onAddTask} />
      </div>
    </nav>
  );
}

