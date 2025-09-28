import java.util.Arrays;
import java.util.Random;

public class DeterministicSelect {
    public static void main(String[] args) {
        int n = 20;
        int[] array = new int[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));

        int k = 5;
        int kth = select(array, 0, n - 1, k);

        System.out.println((k+1) + " " + kth);
    }
    static int select(int[] arr, int left, int right, int k) {
        while (true) {
            if (left == right) return arr[left];

            int n = right - left + 1; // cur size
            int numMedians = (n + 4) / 5;
            int[] medians = new int[numMedians]; // for each group

            // for each group median
            for (int i = 0; i < numMedians; i++) {
                int subLeft = left + i * 5; // 0 then 5(index) then 10 and etc. the border of groupd
                int subRight = Math.min(subLeft + 4, right); // opposite , firstly 4(index) then 9 and etc
                medians[i] = median(arr, subLeft, subRight);
            }

            // median of medians
            int pivot;
            if (numMedians == 1) pivot = medians[0];
            else pivot = select(medians, 0, numMedians - 1, numMedians / 2);

            int pivotIndex = partition(arr, left, right, pivot);

            if (k == pivotIndex) return arr[k];
            else if (k < pivotIndex) right = pivotIndex - 1; // if smaller than pivot we drop the right part recruit the left
            else left = pivotIndex + 1; // opposite
        }
    }
    static int median(int[] arr, int left, int right) {
        Arrays.sort(arr, left, right + 1); // sortng of the group of 5
        return arr[left + (right - left) / 2]; // just get the median
    }
    static int partition(int[] arr, int left, int right, int pivot) {
        int pivotIndex = left;
        for (int i = left; i <= right; i++) {
            if (arr[i] == pivot) { pivotIndex = i; break; }
        }
        swap(arr, pivotIndex, right);

        int storeIndex = left; // for storing elements less than pivot
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) { // if the element is smaller that pivot = > swap with storeIndex
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right); 
        return storeIndex;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }
}
