package Greedy_algo;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // number of items
        int n = sc.nextInt();

        int[] val = new int[n];
        int[] wt = new int[n];

        // capacity of knapsack
        int w = sc.nextInt();

        // input values
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        // input weights
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        // combine value and weight
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = val[i]; // value
            items[i][1] = wt[i];  // weight
        }

        // sort by value/weight ratio (descending)
        Arrays.sort(items, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                double r1 = (double) a[0] / a[1];
                double r2 = (double) b[0] / b[1];
                return Double.compare(r2, r1);
            }
        });

        double totalValue = 0.0;
        int currentCapacity = w;

        // main logic
        for (int i = 0; i < n; i++) {

            // take full item
            if (items[i][1] <= currentCapacity) {
                totalValue += items[i][0];
                currentCapacity -= items[i][1];
            } 
            // take fraction
            else {
                double fraction = (double) currentCapacity / items[i][1];
                totalValue += items[i][0] * fraction;
                break;
            }
        }

        System.out.println("Maximum value in Knapsack = " + totalValue);

        sc.close();
    }
}
