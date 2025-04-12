class Node{
    String name;
    int id;
    int quantity;
    int price;
    Node next;
    
    public Node(String name,int id,int quantity,int price){
        this.name=name;
        this.id=id;
        this.quantity=quantity;
        this.price=price;
        next=null;
    }
}
public class Inventory{
    Node head;
    //Add item at the start
    public void insertAtStart(String name,int id,int quantity,int price){
        Node newnode=new Node(name,id,quantity,price);
        newnode.next=head;
        head=newnode;
        
    }
    //Insert item at the end
    public void insertAtEnd(String name,int id,int quantity,int price){
        Node newnode=new Node(name,id,quantity,price);
        if (head==null){
            head=newnode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
    }
    //Insert at any location
    public void insertAtAny(int index,String name,int id,int qunatity,int price){
        Node newnode=new Node(name,id,qunatity,price);
        if(index==0 || head==null){
            newnode.next=head;
            head=newnode;
            return;
        }
        Node temp=head;
        for (int i=0;i<index-1;i++){
            temp=temp.next;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    //Delete at any location
    public void deleteAt(int id){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.id==id){
            head=head.next;
            System.out.println("Item with "+id +" is deleted.");
            return;
        }
        Node temp=head;
        while(temp.next!=null && temp.next.id!=id){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("ID not found");
        }else{
            temp.next=temp.next.next;
            System.out.println("Item with "+id+" is deleted");
        }
    }
    //search by itemid or itemname
    public void searchByIdorName(int id,String name){
        Node temp=head;
        boolean found = false;
        while(temp!=null){
            if (temp.id == id) {
                System.out.println("Found by ID: " + temp.name + " | Quantity: " + temp.quantity + " | Price: " + temp.price);
                found = true;
            } else if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found by Name: " + temp.name + " | ID: " + temp.id + " | Quantity: " + temp.quantity + " | Price: " + temp.price);
                found = true;
            }
            temp=temp.next;
        }if (!found) {
            System.out.println("Item not found.");
        }
        
    }
    //Update quantity by id
    public void updatequantity(int id,int newquantity){
        Node temp=head;
        boolean found=false;
        while(temp!=null){
            if (temp.id==id){
                temp.quantity=newquantity;
                found=true;
                System.out.println("Quantity is updated for "+id);
            }
            temp=temp.next;
        }
        if(!found){
            System.out.println("ID not found");
        }
    }
    //calculate total value
    public void caltotal(){
        int total=0;
        Node temp=head;
        while(temp!=null){
            total+=temp.price*temp.quantity;
            temp=temp.next;
        }
        System.out.println("Total inventory value: "+total);
    }
    //Sort by name or price
    public void sort(String field, boolean ascending) {
        if (head == null || head.next == null) return;

        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                boolean condition = false;
                if (field.equalsIgnoreCase("name")) {
                    condition = ascending ? i.name.compareToIgnoreCase(j.name) > 0 : i.name.compareToIgnoreCase(j.name) < 0;
                } else if (field.equalsIgnoreCase("price")) {
                    condition = ascending ? i.price > j.price : i.price < j.price;
                }
                if (condition) {
                    // Swap data
                    String tempName = i.name;
                    int tempId = i.id;
                    int tempQty = i.quantity;
                    double tempPrice = i.price;

                    i.name = j.name;
                    i.id = j.id;
                    i.quantity = j.quantity;
                    i.price = j.price;

                    j.name = tempName;
                    j.id = tempId;
                    j.quantity = tempQty;
                    j.price = (int) tempPrice;
                }
            }
        }
    }
    //Display all the details
    public void display(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        System.out.println("Inventory list");
        while(temp!=null){
            System.out.println("Item: "+temp.name+", ID: "+temp.id+", Price: "+temp.price+", Quantity: "+temp.quantity);
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        Inventory List=new Inventory();
        List.insertAtAny(1, "Banana", 120, 5, 20);
        List.insertAtStart("Orange", 110, 6, 15);
        List.insertAtEnd("Apple", 115, 7, 12);
        List.insertAtAny(2, "Kiwi", 125, 3, 50);
        List.display();
        List.caltotal();
        List.sort("price",true);
        System.out.println("Sorting with price----");
        List.display();
    }
}