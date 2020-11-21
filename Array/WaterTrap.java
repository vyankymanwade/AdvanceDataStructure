/*
    WATER TRAPPING PROBLEM
    Given array having height of block at index i we have to find out how many unit of water is trapped in 
    between the bolcks

    a[] = {2,0,2}
    o/p = 2

    a[] = {3,0,1,2,5}
    o/p = 6                     

*/

import java.util.Scanner;

public class WaterTrap {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println("Maximum Water Trap: " + findNaive(a));
        System.out.println("Maximum Water Trap: " + findFast(a));

    }

    public static int findNaive(int a[]) {
        /*
         * here we know we cannot trap the water at corner block so for every middle
         * block we calculate max left anf max right and taking min from that as support
         * to water trap we minus the height of block
         */
        int res = 0;
        int n = a.length;
        for (int i = 1; i < n - 1; i++) {
            int lMax = a[i];
            int rMax = a[i];
            for (int j = 0; j < i; j++)
                lMax = Integer.max(lMax, a[j]);
            for (int j = i + 1; j < n; j++)
                rMax = Integer.max(rMax, a[j]);
            res = res + (Integer.min(lMax, rMax) - a[i]);
        }
        return res;
    }

    public static int findFast(int a[]) {
        /*
         * In Naive method we are calculating left max and right max for every element
         * here we calculate left and right max before hand in array
         */
        int res = 0;
        int n = a.length;
        int lMax[] = new int[n];
        int rMax[] = new int[n];
        lMax[0] = a[0];
        for (int i = 1; i < n; i++)
            lMax[i] = Integer.max(lMax[i - 1], a[i]);

        rMax[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rMax[i] = Integer.max(rMax[i + 1], a[i]);

        for (int i = 1; i < n - 1; i++)
            res = res + (Integer.min(lMax[i], rMax[i]) - a[i]);
        return res;
    }
}