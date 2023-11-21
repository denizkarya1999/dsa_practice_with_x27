// Worst-case time complexity: O(1)
// Worst-case space complexity: O(n)
class Queue {
    private int size;
    private int[] queueArray;
    private int front;
    private int index;

    // Initialize the queue
    public Queue(int size) {
        this.size = size;
        queueArray = new int[size];
        front = 0;
        index = -1;
    }

    // Enqueue: Add to the back of the queue
    // Worst-Time Complexity: O(1)
    public void Enqueue(int element) {
        if (index == size - 1) {
            System.out.println("Queue is full. Cannot enqueue " + element);
        } else {
            queueArray[++index] = element;
        }
    }

    // Dequeue: Remove from the front of the queue
    // Worst-Time Complexity: O(N)
    public void Dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
        } else {
            for (int i = 0; i < index; i++) {
                queueArray[i] = queueArray[i + 1];
            }
            index--;
        }
    }

    // Check if the queue is empty
    // Worst-Case Time Complexity: O(1)
    public boolean isEmpty() {
        return front > index;
    }

    // Get the front of the queue
    // Worst-Case Time Complexity: O(1)
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // You can return a special value or throw an exception
        }
        return queueArray[front];
    }

    // Get the back of the queue
    // Worst-Case Time Complexity: O(1)
    public int back() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // You can return a special value or throw an exception
        }
        return queueArray[index];
    }

    public static void main(String[] args) {
        Queue exampleQueue = new Queue(8);
        exampleQueue.Enqueue(2);
        exampleQueue.Enqueue(3);
        exampleQueue.Enqueue(4);
        exampleQueue.Enqueue(5);
        exampleQueue.Enqueue(6);
        exampleQueue.Enqueue(7);
        exampleQueue.Enqueue(8);
        exampleQueue.Enqueue(9);
        System.out.println(exampleQueue.front());
        System.out.println(exampleQueue.back());
        exampleQueue.Dequeue();
        exampleQueue.Dequeue();
        System.out.println(exampleQueue.front());
        System.out.println(exampleQueue.back());
    }
}