import { loadTasks } from './components/load-task/load-task.js';
import { loadModal } from './components/edit-task/edit-task.js';

document.addEventListener('DOMContentLoaded', () => {
    loadTasks(); // Chama a função loadTasks para carregar as tarefas

    loadModal();// carrega o modal de Edit

    // Redirecionar para a página de criação de tarefas
    document.getElementById('createTaskButton').addEventListener('click', () => {
        window.location.href = './pages/create-task/create-task.html';
    });

    // Lógica de pesquisa (pode ser expandida conforme necessário)
    document.getElementById('searchButton').addEventListener('click', () => {
        const searchTerm = document.getElementById('searchInput').value.toLowerCase();
        const tasks = document.querySelectorAll('.task');

        tasks.forEach(task => {
            const taskName = task.querySelectorAll('p')[task.querySelectorAll('p').length - 1].textContent.toLowerCase();
            if (taskName.includes(searchTerm)) {
                task.style.display = 'block';
            } else {
                task.style.display = 'none';
            }
        });
    });
});