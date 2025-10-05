import java.util.*;
class Task {
    String description;
    boolean isDone;
    Task(String description) {
        this.description = description;
        this.isDone = false;
    }
}

public class ToDoMethods {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String desc) {
        tasks.add(new Task(desc));
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task t = tasks.get(i);
                String status = t.isDone ? "[Done]" : "[Undone]";
                System.out.println((i+1) + ". " + t.description + " " + status);
            }
        }
    }

    public void toggleTask(int idx) {
        if (idx > 0 && idx <= tasks.size()) {
            tasks.get(idx-1).isDone = !tasks.get(idx-1).isDone;
            System.out.println("Task status toggled.");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    public void removeTask(int idx) {
        if (idx > 0 && idx <= tasks.size()) {
            tasks.remove(idx-1);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task number!");
        }
    }
}