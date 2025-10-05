import java.util.*;

class Task {
    int taskId;
    String description;
    boolean isDone;

    Task(int id, String description) {
        this.taskId = id;
        this.description = description;
        this.isDone = false;
    }
}

public class ToDoMethods {
    private ArrayList<Task> tasks = new ArrayList<>();
    private static int idCounter = 1; 

    public void addTask(String desc) {
        tasks.add(new Task(idCounter++, desc));
    }

    
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
        } else {
            for (Task t : tasks) {
                String status = t.isDone ? "[Done]" : "[Undone]";
                System.out.println("Task ID: " + t.taskId + " | " + t.description + " " + status);
            }
        }
    }


    public void toggleTask(int id) {
        Task t = findTaskById(id);
        if (t != null) {
            t.isDone = !t.isDone;
            System.out.println("Task ID " + id + " status toggled.");
        } else {
            System.out.println("Invalid Task ID!");
        }
    }


    public void removeTask(int id) {
        Task t = findTaskById(id);
        if (t != null) {
            tasks.remove(t);
            System.out.println("Task ID " + id + " removed.");
        } else {
            System.out.println("Invalid Task ID!");
        }
    }

    private Task findTaskById(int id) {
        for (Task t : tasks) {
            if (t.taskId == id)
                return t;
        }
        return null;
    }
}
