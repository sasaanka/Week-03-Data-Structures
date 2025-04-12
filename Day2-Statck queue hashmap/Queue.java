public class Queue{
    int[] queue=new int[5];
    int size;
    int front;
    int rear;
    public void enqueue(int data){
        queue[rear]=data;
        rear++;
        size++;
    }
    public int dequeue(){
        int data=queue[front];
        front++;
        size--;
        return data;
    }
    public void show(){
        for(int i=0;i<size;i++){
            System.out.print(queue[front+i]+" ");  //front+i cheste ne front element remove itadi
        }
    }public static void main(String[] args) {
        Queue q1=new Queue();
        q1.enqueue(15);
        q1.enqueue(20);
        q1.enqueue(25);
        q1.enqueue(30);
        q1.enqueue(50);
        q1.dequeue();
        q1.show();
    }
}