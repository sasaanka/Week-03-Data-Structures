class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        next=null;
    }
}
public class Singlylinkedlist{
    Node head;

    //Insert elements into the list
    public void insert(int data){
        Node newnode=new Node(data);
        
        if (head==null){
            head=newnode;
        }else{
            Node n=head; 
            while(n.next!=null){
                n=n.next;

            }
            n.next=newnode;
        }
    }

    //Insert at the start
    public void insertAtStart(int data){
        Node newnode=new Node(data);
        
        newnode.next=head;
        head=newnode;
    }

    //Insert at any location
    public void insertAtAny(int index,int data){
        Node newnode=new Node(data);
        
        if (index==0){
            newnode.next=head;
            head=newnode;
            
        }else{
        Node n=head;
        for (int i=0;i<index-1;i++){
            n=n.next;
        }
        newnode.next=n.next;
        n.next=newnode;
        }
    }
    //Delete elements
    public void deleteAt(int index){
        if (index==0){
            head=head.next;
        }else{
            Node n=head;
            Node n1;
            for(int i=0;i<index-1;i++){
                n=n.next;
            }
            n1=n.next;
            n.next=n1.next;
            System.out.println("n1"+n1.data);
        }
    }

    //Display elements
    public void show(){
        Node n=head;
        while(n.next!=null){
            System.out.println(n.data);
            n=n.next;
        }
        System.out.println(n.data);
    }
    public static void main(String[] args) {
        Insert list = new Insert();
        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insertAtStart(8);
        list.insertAtAny(1, 12);
        list.insertAtAny(0, 48);
        list.deleteAt(2);

        System.out.println("Linked List:");
        list.show();
    }
}

