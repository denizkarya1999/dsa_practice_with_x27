//Worst-Case Time Complexity O(N^2)
//Worst-Case Space Complexity O(1)
public class bubbleSort {
    // Function to perform bubble sort on an array of integers
    public static void BubbleSort(int[] arr) {
        int n = arr.length; // Assign length to the element
        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            // Traverse the array from 0 to n-i-1
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Function to print an array of integers
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // Print each element followed by a space
        }
        System.out.println(); // Print a new line after printing all elements
    }

    // Main method to test the bubble sort implementation
    public static void main(String[] args) {
        // Sample array to be sorted
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("Array before sorting:");
        printArray(arr); // Print the array before sorting

        // Sort the array using bubble sort
        BubbleSort(arr);

        System.out.println("\nArray after sorting:");
        printArray(arr); // Print the array after sorting
    }

}
