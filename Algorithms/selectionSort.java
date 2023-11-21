//Worst-Case Time Complexity O(N^2)
//Worst-Case Space Complexity O(1)
public class selectionSort {
    static void sort(int arr[]) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < arr.length - 1; i++) {
            // Find the minimum element in unsorted array
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min_index])
                    min_index = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] sampleArray = new int[] { 64, 25, 12, 22, 11 };
        System.out.println("Before sorting: ");
        for (int a = 0; a < sampleArray.length; a++) {
            System.out.print(sampleArray[a] + " ");
        }
        sort(sampleArray);
        System.out.println("\nAfter sorting: ");
        for (int b = 0; b < sampleArray.length; b++) {
            System.out.print(sampleArray[b] + " ");
        }
    }
}
