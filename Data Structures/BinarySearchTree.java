class Node {
    int key;
    Node left;
    Node right;

    public Node(int item) {
        this.key = item;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    Node root;

    // BST Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Insert a key into the BST
    // Worst time complexity: O(N)
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Method to insert a key into Binary Search Tree.
    // Worst time complexity: O(N)
    Node insertRec(Node root, int key) {
        // If the root is null, initialize the root
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // If the root`s key is greater than the key, initialize the left
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        }

        // If key is greater than the root, initialize the right.
        else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        // Return the root
        return root;
    }

    // Search for a key in the BST
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Method to search for a key in Binary Search Tree.
    // Worst time complexity: O(N)
    private boolean searchRec(Node root, int key) {
        // Check if the key is found or the current subtree is empty
        if (root == null || root.key == key) {
            // If the key matches or subtree is not empty, return true
            return root != null;
        }

        // If the key is less than the current node's key, search in the left subtree
        if (key < root.key) {
            return searchRec(root.left, key);
        }

        // If the key is greater than the current node's key, search in the right
        // subtree
        return searchRec(root.right, key);
    }

    // Delete a key from the BST
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    // Method tdelete from a Binary Search Tree.
    // Worst time complexity: O(N)
    private Node deleteRec(Node root, int key) {
        // Base case: If the tree is empty
        if (root == null) {
            return root;
        }

        // Recursive cases
        if (key < root.key) {
            // If the key to be deleted is smaller, then it's in the left subtree
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            // If the key to be deleted is larger, then it's in the right subtree
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the in-order successor (smallest in the right
            // subtree)
            root.key = minValue(root.right);

            // Delete the in-order successor
            root.right = deleteRec(root.right, root.key);
        }

        // Return the root
        return root;
    }

    // Find the minimum value
    // Worst time complexity: O(N)
    private int minValue(Node root) {
        // First assign minimum value to its root key
        int minValue = root.key;

        // Go deeper in the left subtree of the binary search tree
        while (root.left != null) {
            minValue = root.left.key; // During this process minimum value will be the left tree
            root = root.left; // Root is going to be left of the root.
        }

        // Return the minimum value
        return minValue;
    }

    // Pre-order traversal of the BST
    public void preOrderTraversal() {
        System.out.print("Pre-order Traversal: ");
        preOrderTraversal(root);
        System.out.println();
    }

    // Method for pre-order traversal
    // Worst time complexity: O(1)
    private void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // In-order traversal of the BST
    public void inOrderTraversal() {
        System.out.print("In-order Traversal: ");
        inOrderTraversal(root);
        System.out.println();
    }

    // Method for in-order traversal
    // Worst time complexity: O(1)
    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
        }
    }

    // Post-order traversal of the BST
    public void postOrderTraversal() {
        System.out.print("Post-order Traversal: ");
        postOrderTraversal(root);
        System.out.println();
    }

    // Method for post-order traversal
    // Worst time complexity: O(1)
    private void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.key + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree exampleBST = new BinarySearchTree();

        exampleBST.insert(20);
        exampleBST.insert(10);
        exampleBST.insert(30);
        exampleBST.insert(100);
        exampleBST.insert(40);
        exampleBST.insert(70);
        exampleBST.insert(80);
        exampleBST.insert(50);
        exampleBST.insert(60);
        exampleBST.insert(90);

        exampleBST.preOrderTraversal();
        exampleBST.inOrderTraversal();
        exampleBST.postOrderTraversal();

        exampleBST.delete(50);
        exampleBST.delete(60);
        exampleBST.delete(90);

        exampleBST.preOrderTraversal();
        exampleBST.inOrderTraversal();
        exampleBST.postOrderTraversal();

        System.out.println(exampleBST.search(110));
    }
}
