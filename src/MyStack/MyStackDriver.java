package MyStack;

public class MyStackDriver {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Print the top element
        System.out.println("Top element: " + stack.peek());

        // Pop and print elements from the stack
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

        // Attempt to pop from an empty stack (uncomment to see the exception)
        // System.out.println("Popped element: " + stack.pop());
    }
}

