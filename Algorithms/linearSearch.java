import java.util.ArrayList;
import java.util.List;

//Worst-Case Time Complexity O(N)
//Worst-Case Time Complexity O(1)
public class linearSearch {
    public static void main(String[] args) {
        int[] array = new int[] { 5, 4, 27, 6, 7, 8, 27, 1, 2, 6, 27 };
        int searchValue = 27;
        search(array, searchValue);
    }

    static void search(int[] arr, int sValue) {
        int hit = 0;
        List<Integer> hitList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == sValue) {
                hit++;
                hitList.add(i);
            }
        }
        System.out.println("The value " + sValue + " has found " + hit + " times. In " + hitList + " indexes");
    }
}
