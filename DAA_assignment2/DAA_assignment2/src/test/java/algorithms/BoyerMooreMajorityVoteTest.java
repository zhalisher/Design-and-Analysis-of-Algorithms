package algorithms;

import metrics.PerformanceTracker;

import java.util.Random;

public class BoyerMooreMajorityVoteTest {
    public static void main(String[] args) {
        testCase(new int[]{1, 2, 1, 1, 3, 1, 1}, 1);
        testCase(new int[]{1, 2, 3, 4, 5}, -1);
        testCase(new int[]{7}, 7);
        testCase(new int[]{}, -1);
        testCase(new int[]{5, 5, 5, 5, 5}, 5);
    }

    private static void testCase(int[] input, int expected) {
        PerformanceTracker tracker = new PerformanceTracker();
        int result = BoyerMooreMajorityVote.findMajority(input, tracker);

        System.out.print("Test array: ");
        for (int x : input) System.out.print(x + " ");
        System.out.println();

        System.out.println("Expected: " + expected + ", Got: " + result);
        System.out.println((result == expected ? "Passed" : "Failed"));
        System.out.println("--------------------------");


        int[] sizes = {100, 1000, 10000, 100000};
        Random rand = new Random();

        for (int n : sizes) {
            int[] arr = new int[n];
            // случайные данные
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(100);
            }

            long start = System.nanoTime();
            BoyerMooreMajorityVote.findMajority(arr, tracker);
            long end = System.nanoTime();

            long duration = end - start;

            System.out.println("n = " + n);
            System.out.println("Time (ns): " + duration);
            tracker.printStats();
            System.out.println("-----------------------");
        }
    }
}
