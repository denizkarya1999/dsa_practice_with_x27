//Worst-Case Time Complexity O(N^2)
//Worst-Case Space Complexity O(1)
public class insertionSort {
    public static void main(String[] args) {
        int[] array = new int[] { 5, 4, 6, 7, 8, 1, 2, 6, 27 };
        System.out.println("Before sorting: ");
        printArray(array);
        sort(array);
        System.out.println("After sorting: ");
        printArray(array);
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    static void sort(int[] arr) {
        int j, key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}