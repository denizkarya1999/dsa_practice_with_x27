class Node {
    int data;
    Node previous;
    Node next;

    Node(int d) {
        this.data = d;
    }
}

// Space complexity: O(N)
public class LinkedList {
    Node head;

    // Perform insertion
    // Worst case time complexity O(N)
    public void insert(int i) {
        Node newNode = new Node(i);

        // If the linked list is empty, set the new node as the head and exit the method
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse the linked list to find the last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // Insert the new node after the last node
        last.next = newNode;

        // Update the previous pointer of the new node to point to the last node
        newNode.previous = last;
    }

    // Method to delete a node with a given value from the linked list
    // Worst case time complexity O(N)
    public void delete(int data) {
        Node current = head;

        // Search for the node to delete
        while (current != null && current.data != data) {
            current = current.next;
        }

        // If the node to delete is found
        if (current != null) {
            // Update the previous node's next pointer
            if (current.previous != null) {
                current.previous.next = current.next;
            } else {
                // If the node to delete is the head, update the head
                head = current.next;
            }

            // Update the next node's previous pointer
            if (current.next != null) {
                current.next.previous = current.previous;
            }
        }
    }

    // Method to search for the node on the linkedList
    // Worst case time complexity: O(N)
    public Node search(int data) {
        Node current = head;

        // Traverse the linked list
        while (current != null) {
            // Check if the current node contains the desired value
            if (current.data == data) {
                return current; // Found the node, return it
            }

            // Move to the next node
            current = current.next;
        }

        return null; // Value not found in the linked list
    }

    // Method to print the list
    // Worst-case time complexity: O(N)
    public void printList() {
        // Print the list forward
        System.out.print("Forward: ");
        Node forward = head;
        while (forward != null) {
            System.out.print(forward.data + " ");
            forward = forward.next;
        }

        // Print the list backward
        System.out.print("\nBackward: ");
        Node backward = getLastNode();
        while (backward != null) {
            System.out.print(backward.data + " ");
            backward = backward.previous;
        }

        System.out.println();
    }

    // Helper method that gets the last node
    // Worst-case time complexity: O(N)
    private Node getLastNode() {
        Node last = head;
        while (last != null && last.next != null) {
            last = last.next;
        }
        return last;
    }

    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList exampleLinkedList = new LinkedList();

        // Populate the LinkedList
        exampleLinkedList.insert(1);
        exampleLinkedList.insert(2);
        exampleLinkedList.insert(3);
        exampleLinkedList.insert(4);
        exampleLinkedList.insert(5);
        exampleLinkedList.insert(6);
        exampleLinkedList.insert(7);
        exampleLinkedList.insert(8);
        exampleLinkedList.insert(9);
        exampleLinkedList.insert(10);
        exampleLinkedList.printList();

        // Add and remove
        exampleLinkedList.insert(11);
        exampleLinkedList.printList();
        exampleLinkedList.delete(11);
        exampleLinkedList.printList();

        // Search in the linkedList
        System.out.println(exampleLinkedList.search(12));
    }
}