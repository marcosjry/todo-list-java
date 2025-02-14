document.getElementById('taskForm').addEventListener('submit', function (e) {
    e.preventDefault(); // Evita o recarregamento da página

    // Captura os valores do formulário
    const taskName = document.getElementById('taskName').value;
    const taskDescription = document.getElementById('taskDescription').value;
    const taskCategory = document.getElementById('taskCategory').value;
    const taskPriority = document.getElementById('taskPriority').value;
    const taskDueDate = document.getElementById('taskDueDate').value;
    const taskStatus = document.getElementById('taskStatus').value;

    // Cria um objeto com os dados da tarefa
    const task = {
        name: taskName,
        description: taskDescription,
        category: taskCategory,
        priority: taskPriority,
        dueDate: taskDueDate,
        status: taskStatus,
    };

    // Salva a tarefa no localStorage
    let tasks = JSON.parse(localStorage.getItem('tasks')) || []; // Recupera as tarefas existentes
    tasks.push(task);
    localStorage.setItem('tasks', JSON.stringify(tasks)); // Salva no localStorage

    // Redireciona de volta para a lista de tarefas
    window.location.href = '../../../frontend/index.html';
});