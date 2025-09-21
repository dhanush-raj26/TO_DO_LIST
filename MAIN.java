import java.util.Scanner;
import java.time.LocalDateTime;

public class MAIN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoMethods todo = new ToDoMethods();

        System.out.print("Enter your user ID: ");
        String userId = scanner.nextLine();
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date and Time: " + now);

        int choice;
        do {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done/Undone");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    todo.addTask(desc);
                    System.out.println("Task added!");
                    break;
                case 2:
                    todo.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter task number to toggle done/undone: ");
                    int idx = scanner.nextInt();
                    scanner.nextLine();
                    todo.toggleTask(idx);
                    break;
                case 4:
                    System.out.print("Enter the task number to remove: ");
                    int removeIndex = scanner.nextInt();
                    scanner.nextLine();
                    todo.removeTask(removeIndex);
                    break;
                case 5:
                    System.out.println("Goodbye, " + userId + "!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1-5.");
            }
        } while (choice != 5);
        scanner.close();
    }
}
