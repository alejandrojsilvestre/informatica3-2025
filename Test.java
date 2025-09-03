import structs.Stack;

public class Test {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>(5);
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Top element: " + stack.top()); // Should print 30
        
        System.out.println("Popped element: " + stack.pop()); // Should print 30
        System.out.println("Popped element: " + stack.pop()); // Should print 20
        
        System.out.println("Is stack empty? " + stack.isEmpty()); // Should print false
        
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70); // Should print "Stack is full"

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
        
        System.out.println("Is stack empty? " + stack.isEmpty()); // Should print true
        System.out.println("Popped element: " + stack.pop()); // Should print "Stack is empty" and return -1


        Stack<String> stringStack = new Stack<String>(3);        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("Top element: " + stringStack.top()); // Should print "World"
        System.out.println("Popped element: " + stringStack.pop()); // Should print "   World"
        System.out.println("Popped element: " + stringStack.pop()); // Should print "Hello"
        System.out.println("Is stack empty? " + stringStack.isEmpty()); // Should print true
        System.out.println("Popped element: " + stringStack.pop()); // Should


    }
    
}
