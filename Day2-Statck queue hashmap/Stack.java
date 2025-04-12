public class Stack{
    int[] stack=new int[5];
    int top=0;
    //add element to the stack
    public void push(int data){
        stack[top]=data;
        top++;
    }
    //Removes element from the stack
    public int pop(){
        int data;
        top--;
        data=stack[top];
        stack[top]=0;
        return data;
    }
    //get the top element
    public int peek(){
        int data;
        data=stack[top-1];
        return data;
    }
    //size of the stack
    public int size(){
        return top;
    }
    //is empty
    public boolean isEmpty(){
        return top<=0;
    }
    public void show(){
        for(int num:stack){
            System.out.print(num+" ");
        }
    }
    public static void main(String[] args) {
        Stack num=new Stack();
        num.push(20);
        num.push(15);
        num.push(48);
        System.out.println("top element is: "+num.peek());
        System.out.println(num.pop());
        System.out.println("Empty: "+num.isEmpty());
        num.show();
    }
}