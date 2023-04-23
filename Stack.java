public class Stack {
    private int[] arr;
    private int top;
    private int capacity;
    
    // constructor to initialize the stack
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    
    // push method to add an element to the stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack is full");
            System.exit(1);
        }
        arr[++top] = x;
    }
    
    // pop method to remove and return the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return arr[top--];
    }
    
    // method to return the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return arr[top];
    }
    
    // method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
    
    // method to check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    // method to return the size of the stack
    public int size() {
        return top + 1;
    }
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        
        // push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        // print the top element of the stack
        System.out.println("Top element of the stack: " + stack.peek());
        
        // pop an element from the stack
        System.out.println("Popped element: " + stack.pop());
        
        // print the top element of the stack again
        System.out.println("Top element of the stack: " + stack.peek());
        
        // push more elements onto the stack
        stack.push(40);
        stack.push(50);
        
        // print the size of the stack
        System.out.println("Size of the stack: " + stack.size());
        
        // pop all elements from the stack
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
        
        // try to pop an element from an empty stack
        // System.out.println("Popped element: " + stack.pop());
    }
    
}
