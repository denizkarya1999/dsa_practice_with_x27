// Worst time complexity: O(1)
// Worst space complexity: O(n)
public class Stack {
    private int maxSize; // Maximum size of the stack
    private int top; // Index of the top element in the stack
    private String[] stackArray; // The array that will be used for Stack

    // Get the size and initialize the array and top
    public Stack(int size) {
        maxSize = size;
        stackArray = new String[maxSize];
        top = -1; // Initialize the top index to -1 (empty stack)
    }

    // Worst-case time complexity: O(1)
    // Push the item into Stack
    public void push(String item) {
        if (top < maxSize - 1) { // If the size is greater than top increment the top and assign item
            stackArray[++top] = item;
        } else { // If top is greater or equal to maxSize do not accept any item
            System.out.println("Stack is full. Cannot push " + item);
        }
    }

    // Worst-case time complexity: O(1)
    // This function removes item from stack
    public String pop() {
        if (top >= 0) { // Top is always greater than 0 when there are items in stack therefore
                        // decrement top
            return stackArray[top--];
        } else { // Otherwise give error and return null
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
    }

    // Worst-case time complexity: O(1)
    // This finds the top of the stack
    public String peek() {
        if (top >= 0) { // If the top is greater than 0 return the value
            return stackArray[top];
        } else { // Otherwise give error and return null
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        }
    }

    // Worst-case time complexity: O(1)
    // Return whether the stack is empty or not
    public boolean isEmpty() {
        return top == -1;
    }

    // Worst-case time complexity: O(1)
    // Get the size of the stack
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(3);

        stack.push("Plate 1");
        stack.push("Plate 2");
        stack.push("Plate 3");

        System.out.println("Stack of Plates: " + stack.size() + " plates");

        System.out.println("Top Plate: " + stack.peek());

        System.out.println("Removed Plate: " + stack.pop());
        System.out.println("Removed Plate: " + stack.pop());

        System.out.println("Stack of Plates after Popping: " + stack.size() + " plates");
    }
}