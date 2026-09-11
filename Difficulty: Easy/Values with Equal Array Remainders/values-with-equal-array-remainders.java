import java.util.*;

class Solution {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int sameMod(int[] arr) {

        int g = 0;

        // Find GCD of differences
        for (int i = 1; i < arr.length; i++) {
            g = gcd(g, Math.abs(arr[i] - arr[0]));
        }

        // All elements are equal
        if (g == 0) {
            return -1;
        }

        // Count positive divisors of GCD
        int count = 0;

        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                count++;

                if (i != g / i) {
                    count++;
                }
            }
        }

        return count;
    }
}