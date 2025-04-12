class Node{
    int taskId;
    String name;
    int priority;
    String dueDate;
    Node next;
    public Node(int taskId,String name,int priority,String dueDate){
        this.taskId=taskId;
        this.name=name;
        this.priority=priority;
        this.dueDate=dueDate;
        this.next=null;
    }
}
public class TaskScheduling{
    Node head;
    Node tail;
    //Add at the start
    public void addatStart(int taskId,String name,int priority,String dueDate){
        Node newnode=new Node(taskId,name,priority,dueDate);
        if(head==null){
            head=tail=newnode;
            newnode.next=head;
        }else{
            newnode.next=head;
            head=newnode;
            tail.next=head;
        }
    }
    //Add at the end
    public void addatEnd(int taskId,String name,int priority,String dueDate){
        Node newnode=new Node(taskId,name,priority,dueDate);
        if(head==null){
            head=tail=newnode;
            newnode.next=head;
        }else{
            tail.next=newnode;
            tail=newnode;
            tail.next=head;
        }
    }
    //Add at any specific location
    public void addAtAny(int index,int taskId,String name,int priority,String dueDate){
        Node newnode=new Node(taskId,name,priority,dueDate);
        if(index==0 || head==null){
            head=tail=newnode;
            newnode.next=head;
        }
        Node temp=head;
        int count=1;
        while(count<index-1 && temp.next!=head){
            temp=temp.next;
            count++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
        if(temp==tail){
            tail=newnode;
        }
    }
    // Display all tasks
    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Node temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId +", Name: " + temp.name +", Priority: " + temp.priority +", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    public static void main(String[] args) {
        TaskScheduling list=new TaskScheduling();
        list.addatStart(145,"shop",5,"20-01");
        list.addatEnd(152, "Welcome", 1, "02-12");
        list.addAtAny(1, 784, "Bill", 6, "21-01");
        list.displayAll();
    }
}