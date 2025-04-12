class Node {
    int data;
    Node next;
    @SuppressWarnings("unused")
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Doublylinkedlist {
    Node head;
    @SuppressWarnings("unused")
    Node tail;
    // Insert at the start
    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;

        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }
    //Insert at the end
    public void insertAtEnd(int data){
        Node newnode=new Node(data);
        Node last=head;
        if (head==null){
            newnode.prev=null;
            head=newnode;
            return;
        }
        while(last.next!=null){
            last=last.next;
        }
        last.next=newnode;
        newnode.prev=last;
        newnode.next=null;
    }
    //Insert at any index
    public void insertAtAny(int index,int data){
        Node newnode=new Node(data);
        if(index==0 || head==null){
            newnode.next=head;
            newnode.prev=null;
        }
        Node temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        newnode.next=temp.next;
        temp.next=newnode;
        newnode.prev=temp;
        if(temp.next!=null){
            temp.next.prev=newnode;
        }
        if(newnode.next==null){
            tail=newnode;
        }
    }
    // Display forward
    public void display() {
        Node temp = head;
        System.out.print("List : ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Doublylinkedlist list = new Doublylinkedlist();
        list.insertAtStart(5);
        list.insertAtStart(10);
        list.insertAtStart(15);
        list.insertAtEnd(20);
        list.insertAtEnd(21);
        list.insertAtAny(2, 79);
        list.display();
    }
}
