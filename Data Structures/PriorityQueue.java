public class PriorityQueue {

    private int[] heap;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Priority queue is full");
            return;
        }

        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        int removedItem = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return removedItem;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void heapifyUp(int i) {
        int parent = (i - 1) / 2;
        while (i > 0 && heap[i] < heap[parent]) {
            swap(i, parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    private void heapifyDown(int i) {
        int leftChild, rightChild, minChild;
        while (true) {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            minChild = i;

            if (leftChild < size && heap[leftChild] < heap[minChild]) {
                minChild = leftChild;
            }

            if (rightChild < size && heap[rightChild] < heap[minChild]) {
                minChild = rightChild;
            }

            if (minChild == i) {
                break;
            }

            swap(i, minChild);
            i = minChild;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Priority queue is empty");
            return;
        }

        System.out.print("Priority queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);

        pq.enqueue(5);
        pq.enqueue(2);
        pq.enqueue(9);
        pq.enqueue(10);
        pq.enqueue(1);
        pq.enqueue(7);
        pq.enqueue(3);
        pq.enqueue(4);
        pq.enqueue(6);
        pq.enqueue(8);

        pq.printQueue();

        pq.dequeue();
        pq.dequeue();

        pq.printQueue();
    }
}