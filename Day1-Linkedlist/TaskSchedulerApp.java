class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task currentTask = null;

    // Add task at the beginning
    public void addAtBeginning(Task newTask) {
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    // Add task at the end
    public void addAtEnd(Task newTask) {
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Add task at specific position
    public void addAtPosition(Task newTask, int position) {
        if (position <= 1) {
            addAtBeginning(newTask);
            return;
        }

        Task temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove task by ID
   public void removeById(int taskId) {
    if (head == null) {
        System.out.println("Task list is empty.");
        return;
    }

    Task temp = head, prev = null;

    do {
        if (temp.taskId == taskId) {
            // Only one node
            if (temp == head && head.next == head) {
                head = null;
                currentTask = null;
            } 
            // Deleting head with multiple nodes
            else if (temp == head) {
                Task last = head;
                while (last.next != head) {
                    last = last.next;
                }
                head = head.next;
                last.next = head;
            } 
            // Deleting non-head node
            else if (prev != null) {
                prev.next = temp.next;
            }

            if (currentTask == temp) {
                currentTask = head;
            }

            System.out.println("Task ID " + taskId + " removed.");
            return;
        }

        prev = temp;
        temp = temp.next;
    } while (temp != head);

    System.out.println("Task ID " + taskId + " not found.");
}



    // View current task and move to next
    public void viewAndMoveToNext() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        if (currentTask == null) currentTask = head;

        System.out.println("Current Task -> ID: " + currentTask.taskId + ", Name: " + currentTask.taskName +
                ", Priority: " + currentTask.priority + ", Due: " + currentTask.dueDate);

        currentTask = currentTask.next;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task temp = head;
        System.out.println("All Tasks:");
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in list.");
            return;
        }

        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Found -> ID: " + temp.taskId + ", Name: " + temp.taskName +
                        ", Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No task found with priority: " + priority);
    }
}
public class TaskSchedulerApp {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(new Task(1, "Design UI", 2, "2025-04-15"));
        scheduler.addAtBeginning(new Task(2, "Fix bugs", 1, "2025-04-14"));
        scheduler.addAtPosition(new Task(3, "Write tests", 3, "2025-04-20"), 2);
        scheduler.displayAllTasks();

        scheduler.viewAndMoveToNext(); 
        scheduler.viewAndMoveToNext(); 
        scheduler.viewAndMoveToNext(); 
        scheduler.searchByPriority(1); 
        scheduler.removeById(2); 
        scheduler.displayAllTasks();
    }
}
