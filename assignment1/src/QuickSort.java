import java.util.Random;

public class QuickSort  {
    public static void main(String[] args) {
        int n = 20;
        int[] array = new int[n];

        Random random = new Random();

        System.out.println("Before sort");
        for (int i = 0; i < n; i++)array[i] = random.nextInt(100);
        for (int i : array) System.out.print(i + " ");
        System.out.println();

        quickSort(array, 0, array.length - 1);

        System.out.println("After sort");
        for (int i : array) System.out.print(i + " ");

        System.out.println();
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");

    }

    private static void quickSort(int[] array, int start, int end) {
        if(end <= start) return;


        Random random = new Random();
        int i = start + random.nextInt(end - start + 1);
        swap(array, i, end);

        int pivot = partition(array, start, end);

        // smaller partition
        if(pivot - start < end - pivot){
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1 , end);
        }else{
            quickSort(array, pivot + 1, end);
            quickSort(array, start, pivot - 1);
        }
//        quickSort(array, start, pivot - 1);
//        quickSort(array, pivot + 1, end);

    }
    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++){
            if(array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i; // loation of pivot
    }
    private static void swap(int[] array, int i, int end) {
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
    }
}
