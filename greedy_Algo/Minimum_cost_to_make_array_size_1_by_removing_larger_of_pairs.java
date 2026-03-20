package Greedy_algo;

import java.util.Scanner;

public class Minimum_cost_to_make_array_size_1_by_removing_larger_of_pairs {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];

        // Input array
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Find minimum element
        int min = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // Calculate result
        int result = (size - 1) * min;

        // Output
        System.out.println(result);

        sc.close();
    }
}