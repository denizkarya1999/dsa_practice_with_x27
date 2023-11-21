// Worst-Case Time Complexity O(logn)
// Worst-Case Space Complexity O(1)
public class binarySearch {
    public static void main(String[] args) {
        int[] array = new int[] { 10, 15, 11, 1, 8, 12, 13, 3 };
        int searchValue = 15;
        int low = 0;
        int high = array.length - 1;
        int result = search(array, searchValue, low, high);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println("Element is present at "
                    + "index " + result);
    }

    static int search(int array[], int x, int low, int high) {

        // Repeat until the pointers low and high meet each other
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == x)
                return mid;

            if (array[mid] < x)
                low = mid + 1;

            else
                high = mid - 1;
        }
        return -1;
    }
}
