import { addDeleteEventListeners, addEditEventListeners } from "../../events/events.js";

export function loadTasks() {
    const taskList = document.getElementById('taskList');
    taskList.innerHTML = ''; // Limpa a lista antes de carregar as tarefas

    // Recupera as tarefas do localStorage
    const tasks = JSON.parse(localStorage.getItem('tasks')) || [];

    // Exibe cada tarefa na lista
    tasks.forEach((task, index) => {
        const taskElement = document.createElement('div');
        taskElement.classList.add('task');
        taskElement.innerHTML = `
            <h3>${task.name}</h3>
            <p><strong>Descrição:</strong> ${task.description}</p>
            <p><strong>Categoria:</strong> ${task.category}</p>
            <p><strong>Prioridade:</strong> ${task.priority}</p>
            <p><strong>Data de Término:</strong> ${task.dueDate}</p>
            <p><strong>Andamento:</strong> ${task.status}</p>
            <button class="delete-task-button" data-index="${index}">Excluir</button>
            <button class="edit-task-button" data-index="${index}">Editar</button>
        `;
        taskList.appendChild(taskElement);
    });

    addDeleteEventListeners();
    addEditEventListeners();
}


