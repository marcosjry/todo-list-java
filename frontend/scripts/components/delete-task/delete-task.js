import { loadTasks } from "../load-task/load-task.js";

export function deleteTask(index) {
    const tasks = JSON.parse(localStorage.getItem('tasks')) || [];
    tasks.splice(index, 1); // Remove a tarefa do array
    localStorage.setItem('tasks', JSON.stringify(tasks)); // Atualiza o localStorage
    loadTasks(); // Recarrega a lista de tarefas
}