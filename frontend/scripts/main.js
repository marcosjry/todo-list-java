
document.getElementById('createTaskButton').addEventListener('click', () => {
    window.location.href = './pages/create-task/create-task.html';
});


document.getElementById('searchButton').addEventListener('click', () => {
    const searchTerm = document.getElementById('searchInput').value.toLowerCase();
    const tasks = document.querySelectorAll('.task');

    tasks.forEach(task => {
        const taskName = task.querySelector('h3').textContent.toLowerCase();
        if (taskName.includes(searchTerm)) {
            task.style.display = 'block';
        } else {
            task.style.display = 'none';
        }
    });
});