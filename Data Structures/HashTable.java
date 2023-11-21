// Worst-case time complexity: O(n)
// Worst-case space complexity: O(n)
public class HashTable {
    private int tableSize; // is used for getting the size for HashTable
    private String[] table; // is the HashTable

    // The constructor assigns size of the HashTable
    public HashTable(int size) {
        tableSize = size;
        table = new String[tableSize];
    }

    // Get the ASCII code of each character and divide them by TableSize and return
    // the remainder
    // Worst-case time complexity: O(n)
    public int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % tableSize;
    }

    // Insert function shall get the index from hash and assign an index into an
    // array then value will be inserted into that location
    // Worst-case time complexity: O(n)
    public void insert(String key, String value) {
        int index = hash(key);
        table[index] = value;
    }

    // Key will be used to get the index and the index will return the associated
    // value
    // Worst-case time complexity: O(n)
    public String lookup(String key) {
        int index = hash(key);
        return table[index];
    }

    // Remove function shall remove the value based on its key
    // Worst-case time complexity: O(n)
    public void remove(String key) {
        int index = hash(key);
        if (table[index] != null) {
            table[index] = null;
        }
    }

    public static void main(String[] args) {
        HashTable hashFunction = new HashTable(10);

        hashFunction.insert("Alice", "123-456-7890");
        hashFunction.insert("Bob", "987-654-3210");
        hashFunction.insert("Dave", "555-123-4567");

        System.out.println("Alice's Phone Number: " + hashFunction.lookup("Alice"));
        System.out.println("Bob's Phone Number: " + hashFunction.lookup("Bob"));
        System.out.println("Dave's Phone Number: " + hashFunction.lookup("Dave"));

        System.out.println("After removing Alice...");
        hashFunction.remove("Alice");
        System.out.println("Alice's Phone Number: " + hashFunction.lookup("Alice"));
    }
}