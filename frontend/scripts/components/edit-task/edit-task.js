import { loadTasks } from '../load-task/load-task.js';

function editTask(index, updatedTask) {
    const tasks = JSON.parse(localStorage.getItem('tasks')) || [];
    
    // Atualiza a tarefa no array
    tasks[index] = updatedTask;

    // Salva as tarefas atualizadas no localStorage
    localStorage.setItem('tasks', JSON.stringify(tasks));

    // Recarrega a lista de tarefas
    loadTasks();
}

export function openEditModal(index) {

    const tasks = JSON.parse(localStorage.getItem('tasks')) || [];
    const task = tasks[index];

    // Preenche o modal com os dados da tarefa
    document.getElementById('editTaskName').value = task.name;
    document.getElementById('editTaskDescription').value = task.description;
    document.getElementById('editTaskCategory').value = task.category;
    document.getElementById('editTaskPriority').value = task.priority;
    document.getElementById('editTaskDueDate').value = task.dueDate;
    document.getElementById('editTaskStatus').value = task.status;

    // Exibe o modal
    openModal();
    
    // Adiciona o evento de submit ao formulário de edição
    document.getElementById('editTaskForm').onsubmit = (e) => {
        e.preventDefault(); // Evita o recarregamento da página
        
        // Captura os valores atualizados
        const updatedTask = {
            name: document.getElementById('editTaskName').value,
            description: document.getElementById('editTaskDescription').value,
            category: document.getElementById('editTaskCategory').value,
            priority: document.getElementById('editTaskPriority').value,
            dueDate: document.getElementById('editTaskDueDate').value,
            status: document.getElementById('editTaskStatus').value,
        };

        // Chama a função para editar a tarefa
        editTask(index, updatedTask);
        
        // Fecha o modal
        closeModal();
    };
    
}

export async function loadModal() {
    const modalContainer = document.getElementById('editModal');

    // Carrega o conteúdo do modal a partir do arquivo HTML
    const response = await fetch('./pages/edit-task-modal/edit-task-modal.html');
    const modalContent = await response.text();

    // Injeta o conteúdo no container do modal
    modalContainer.innerHTML = modalContent;

    // Adiciona o evento para fechar o modal
    const closeButton = modalContainer.querySelector('.close');
    closeButton.addEventListener('click', () => {
        closeModal();
        modalContainer.style.display = 'none';
    });
}

function openModal() {
    const modalContainer = document.getElementById('editModal');
    modalContainer.style.display = 'block';

    document.body.classList.add('no-scroll');
}

function closeModal() {
    const modalContainer = document.getElementById('editModal');
    modalContainer.style.display = 'none';

    document.body.classList.remove('no-scroll');
}