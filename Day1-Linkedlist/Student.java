class StudentNode{
    int rollno;
    String name;
    int age;
    char grade;
    StudentNode next;
    public StudentNode(int rollno,String name,int age,char grade){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.next=null;
    }
}
public class Student{
    StudentNode head;
    //Insert Student at the start
    public void insertAtStart(int rollno,String name,int age,char grade){
        StudentNode newnode=new StudentNode(rollno, name, age, grade);
        newnode.next=head;
        head=newnode;
    }
    //Insert Student at the end
    public void insertAtEnd(int rollno,String name,int age,char grade){
        StudentNode newnode=new StudentNode(rollno,name,age,grade);
        if (head==null){
            head=newnode;
        }else{
            StudentNode temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;
        }
    }
    //Insert At any location
    public void insertAtAny(int index,int rollno,String name,int age,char grade){
        StudentNode newnode=new StudentNode(rollno,name,age,grade);
        if(index==0 || head==null){
            newnode.next=head;
            head=newnode;
            return;
        }
            StudentNode temp=head;
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            newnode.next=temp.next;
            temp.next=newnode;
        
    }
    //Delete Student by rollno
    public void deletebyRollno(int rollno){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if (head.rollno==rollno){
            head=head.next;
            System.out.println("Student with "+rollno+" is deleted");
            return;
        }
        StudentNode temp=head;
        while(temp.next!=null && temp.next.rollno!=rollno){
            temp=temp.next;
        }
        if (temp.next==null){
            System.out.println("Rollno not found");
        }else{
            temp.next=temp.next.next;
            System.out.println("Student with roll number " + rollno + " deleted.");
        }
    }
    //Search by rollno
    public void searchByRollno(int rollno){
        if (head==null){
            System.out.println("List is empty");
            return;
        }
        StudentNode temp=head;
        while(temp!=null){
            if(temp.rollno==rollno){
                System.out.println("Rollno found "+temp.name+" Age: "+temp.age+", Grade: "+temp.grade);
                return;
            }
            temp=temp.next;
        }
    }
    //Update grade by rollno
    public void updateGrade(int rollno,char newgrade){
        StudentNode temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.rollno==rollno){
                temp.grade=newgrade;
                System.out.println("Grade updated for "+rollno );
                found=true;
                break;
            }
            temp=temp.next;
        }
        if(!found)
            System.out.println("Student with "+rollno+" not found.");
    }
    //Display all records
    public void show(){
        if(head==null){
            System.out.println("List is empty");
        }
        StudentNode temp=head;
        System.out.println("Student records");
        while(temp!=null){
            System.out.println("Roll No: " + temp.rollno + ", Name: " + temp.name +", Age: " + temp.age + ", Grade: " + temp.grade);
            temp=temp.next;
        }

    }
    public static void main(String[] args) {
        Student list=new Student();
        list.insertAtAny(1,10, "Sasanka", 20, 'O');
        list.insertAtEnd(36, "Shasank", 20, 'A');
        list.insertAtAny(2, 30, "Abhinaya", 21, 'A');
        list.insertAtStart(2, "Bharath", 21, 'O');

        list.searchByRollno(02);
        list.updateGrade(30, 'O');
        list.deletebyRollno(36);
        list.show();

    }
}