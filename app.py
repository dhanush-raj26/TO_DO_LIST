from flask import Flask, render_template, request, redirect, url_for
import datetime

app = Flask(__name__)

# Task class to store task details
class Task:
    def __init__(self, description):
        self.description = description
        self.is_done = False

# ToDoMethods class to manage tasks
class ToDoMethods:
    def __init__(self):
        self.tasks = []

    def add_task(self, desc):
        self.tasks.append(Task(desc))

    def view_tasks(self):
        return self.tasks

    def toggle_task(self, idx):
        if 0 <= idx < len(self.tasks):
            self.tasks[idx].is_done = not self.tasks[idx].is_done
            return True
        return False

    def remove_task(self, idx):
        if 0 <= idx < len(self.tasks):
            self.tasks.pop(idx)
            return True
        return False

# Global instance for task management
todo = ToDoMethods()
user_id = None

@app.route('/', methods=['GET', 'POST'])
def index():
    global user_id
    if request.method == 'POST':
        # Handle user ID submission
        if 'user_id' in request.form:
            user_id = request.form['user_id']
        # Handle task addition
        elif 'task_desc' in request.form:
            desc = request.form['task_desc']
            if desc.strip():
                todo.add_task(desc)
        # Handle task toggle
        elif 'toggle_idx' in request.form:
            idx = int(request.form['toggle_idx']) - 1
            todo.toggle_task(idx)
        # Handle task removal
        elif 'remove_idx' in request.form:
            idx = int(request.form['remove_idx']) - 1
            todo.remove_task(idx)
        return redirect(url_for('index'))

    # Display current date/time and task list
    now = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    tasks = todo.view_tasks()
    return render_template('index.html', user_id=user_id, current_time=now, tasks=tasks)

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)