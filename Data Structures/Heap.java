// A class for Min Heap 
class Heap {

    // To store array of elements in heap
    private int[] heapArray;

    // max size of the heap
    private int capacity;

    // Current number of elements in the heap
    private int current_heap_size;

    // Constructor
    public Heap(int n) {
        capacity = n;
        heapArray = new int[capacity];
        current_heap_size = 0;
    }

    // Swapping using reference
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Get the Parent index for the given index
    private int parent(int key) {
        return (key - 1) / 2;
    }

    // Get the Left Child index for the given index
    private int left(int key) {
        return 2 * key + 1;
    }

    // Get the Right Child index for the given index
    private int right(int key) {
        return 2 * key + 2;
    }

    // Inserts a new key
    public boolean insertKey(int key) {
        if (current_heap_size == capacity) {

            // heap is full
            return false;
        }

        // First insert the new key at the end
        int i = current_heap_size;
        heapArray[i] = key;
        current_heap_size++;

        // Fix the min heap property if it is violated
        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(heapArray, i, parent(i));
            i = parent(i);
        }
        return true;
    }

    // Decreases value of given key to new_val.
    // It is assumed that new_val is smaller
    // than heapArray[key].
    public void decreaseKey(int key, int new_val) {
        heapArray[key] = new_val;

        while (key != 0 && heapArray[key] < heapArray[parent(key)]) {
            swap(heapArray, key, parent(key));
            key = parent(key);
        }
    }

    // Returns the minimum key (key at
    // root) from min heap
    public int getMin() {
        return heapArray[0];
    }

    // Method to remove minimum element
    // (or root) from min heap
    public int extractMin() {
        if (current_heap_size <= 0) {
            return Integer.MAX_VALUE;
        }

        if (current_heap_size == 1) {
            current_heap_size--;
            return heapArray[0];
        }

        // Store the minimum value,
        // and remove it from heap
        int root = heapArray[0];

        heapArray[0] = heapArray[current_heap_size - 1];
        current_heap_size--;
        MinHeapify(0);

        return root;
    }

    // This function deletes key at the
    // given index. It first reduced value
    // to minus infinite, then calls extractMin()
    public void deleteKey(int key) {
        decreaseKey(key, Integer.MIN_VALUE);
        extractMin();
    }

    // A recursive method to heapify a subtree
    // with the root at given index
    // This method assumes that the subtrees
    // are already heapified
    private void MinHeapify(int key) {
        int l = left(key);
        int r = right(key);

        int smallest = key;
        if (l < current_heap_size && heapArray[l] < heapArray[smallest]) {
            smallest = l;
        }
        if (r < current_heap_size && heapArray[r] < heapArray[smallest]) {
            smallest = r;
        }

        if (smallest != key) {
            swap(heapArray, key, smallest);
            MinHeapify(smallest);
        }
    }

    // Increases value of given key to new_val.
    // It is assumed that new_val is greater
    // than heapArray[key].
    // Heapify from the given key
    public void increaseKey(int key, int new_val) {
        heapArray[key] = new_val;
        MinHeapify(key);
    }

    // Changes value on a key
    public void changeValueOnAKey(int key, int new_val) {
        if (heapArray[key] == new_val) {
            return;
        }
        if (heapArray[key] < new_val) {
            increaseKey(key, new_val);
        } else {
            decreaseKey(key, new_val);
        }
    }

    // Function to perform Pre-order traversal
    public void preOrderTraversal(int index) {
        if (index >= current_heap_size) {
            return;
        }
        System.out.print(heapArray[index] + " ");
        preOrderTraversal(left(index));
        preOrderTraversal(right(index));
    }

    // Function to perform In-order traversal
    public void inOrderTraversal(int index) {
        if (index >= current_heap_size) {
            return;
        }
        inOrderTraversal(left(index));
        System.out.print(heapArray[index] + " ");
        inOrderTraversal(right(index));
    }

    // Function to perform Post-order traversal
    public void postOrderTraversal(int index) {
        if (index >= current_heap_size) {
            return;
        }
        postOrderTraversal(left(index));
        postOrderTraversal(right(index));
        System.out.print(heapArray[index] + " ");
    }

    public static void main(String[] args) {
        // Create an example array
        Heap h = new Heap(11);
        h.insertKey(3);
        h.insertKey(2);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);

        // Adding traversal calls in the main method
        System.out.print("Pre-order Traversal: ");
        h.preOrderTraversal(0); // Start traversal from the root (index 0)
        System.out.println();

        System.out.print("In-order Traversal: ");
        h.inOrderTraversal(0); // Start traversal from the root (index 0)
        System.out.println();

        System.out.print("Post-order Traversal: ");
        h.postOrderTraversal(0); // Start traversal from the root (index 0)
        System.out.println();

        // Delete some keys
        h.deleteKey(5);
        h.deleteKey(6);
        System.out.print("After deleting 45 and 15... \n");

        // Adding traversal calls in the main method
        System.out.print("Pre-order Traversal: ");
        h.preOrderTraversal(0); // Start traversal from the root (index 0)
        System.out.println();

        System.out.print("In-order Traversal: ");
        h.inOrderTraversal(0); // Start traversal from the root (index 0)
        System.out.println();

        System.out.print("Post-order Traversal: ");
        h.postOrderTraversal(0); // Start traversal from the root (index 0)
        System.out.println();

        System.out.println("The minimum number is: " + h.getMin());

        // Remove minimum number and replace by 1
        h.decreaseKey(0, 1);
        System.out.println("After replacing minimum value with 1: " + h.getMin());
        System.out.print("Pre-order Traversal: ");
        h.preOrderTraversal(0); // Start traversal from the root (index 0)
    }
}
