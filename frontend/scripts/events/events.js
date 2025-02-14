import { deleteTask } from '../components/delete-task/delete-task.js';
import { openEditModal } from '../components/edit-task/edit-task.js';

export function addDeleteEventListeners() {
    const deleteButtons = document.querySelectorAll('.delete-task-button');

    deleteButtons.forEach(button => {
        button.addEventListener('click', () => {
            const index = button.getAttribute('data-index'); // Pega o índice da tarefa
            deleteTask(index); // Chama a função deleteTask
        });
    });
}

export function addEditEventListeners() {
    const editButtons = document.querySelectorAll('.edit-task-button');

    editButtons.forEach(button => {
        button.addEventListener('click', () => {
            const index = button.getAttribute('data-index'); // Pega o índice da tarefa
            openEditModal(index); // Abre o modal de edição
        });
    });
}