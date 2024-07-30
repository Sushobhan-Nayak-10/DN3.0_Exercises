// Task class
class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", taskName=" + taskName + ", status=" + status + "]";
    }
}

// Node class for singly linked list
class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

// Singly linked list for managing tasks
class TaskList {
    private Node head;

    public TaskList() {
        this.head = null;
    }

    // Add task at the beginning of the list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
    }

    // Search for a task by taskId
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and display all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by taskId
    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.taskId == taskId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

// Main class
public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        // Add tasks
        taskList.addTask(new Task(1, "Task 1", "Pending"));
        taskList.addTask(new Task(2, "Task 2", "In Progress"));
        taskList.addTask(new Task(3, "Task 3", "Completed"));

        // Traverse tasks
        System.out.println("All tasks:");
        taskList.traverseTasks();

        // Search for a task
        System.out.println("\nSearching for task with ID 2:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        // Delete a task
        System.out.println("\nDeleting task with ID 1:");
        if (taskList.deleteTask(1)) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }

        // Traverse tasks again
        System.out.println("\nAll tasks after deletion:");
        taskList.traverseTasks();
    }
}
