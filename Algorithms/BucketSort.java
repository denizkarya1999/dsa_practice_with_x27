import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public void bucketSort(float[] arr, int n) {
        if (n <= 0)
            return;
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] bucket = new ArrayList[n];

        // Create empty buckets
        for (int i = 0; i < n; i++)
            bucket[i] = new ArrayList<Float>();

        // Add elements into the buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) arr[i] * n;
            bucket[bucketIndex].add(arr[i]);
        }

        // Sort the elements of each bucket
        for (int i = 0; i < n; i++) {
            Collections.sort((bucket[i]));
        }

        // Get the sorted array
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0, size = bucket[i].size(); j < size; j++) {
                arr[index++] = bucket[i].get(j);
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        BucketSort b = new BucketSort();
        float[] arr = { (float) 0.42, (float) 0.32, (float) 0.33, (float) 0.52, (float) 0.37, (float) 0.47,
                (float) 0.51 };

        System.out.println("Before Bucket Sort is being performed:");
        for (float i : arr)
            System.out.print(i + "  ");

        System.out.println();

        System.out.println("After Bucket Sort is being performed:");
        b.bucketSort(arr, arr.length);
        for (float i : arr)
            System.out.print(i + "  ");
    }
}