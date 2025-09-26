import java.util.Random;

public class MergeSort {
    private static final int cutoff = 16;

    public static void main(String[] args) {
        int n = 50;
        int[] array = new int[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Before sort");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        mergeSort(array);

        System.out.println("After sort");

        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    private static void mergeSort(int[] array) {
        int length = array.length;
        if (length <= 1) return;
        if (length <= cutoff){
            insertionSort(array);
            return;
        }


        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; // left array
        int j = 0; // right array

        for(; i < length; i++){
            if(i < middle){
                leftArray[i] = array[i];
            }
            else{
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(leftArray, rightArray, array);
    }
    private static void merge(int[] leftArray, int[] rightArray, int[] array){
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0;

        while(l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        // for one single element that was left
        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }
}
