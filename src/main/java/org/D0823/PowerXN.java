package org.D0823;

public class PowerXN {

    /*
    Time complexity: O(logn)

At each iteration, we reduce n by half, thus it means we will make only logn number of iterations using a while loop.
Thus, it will take overall O(logn) time.
Space complexity: O(1)

We don't use any additional space.
     */
    public double myPow(double x, int n) {
        //return Math.pow(x,n);
        if (n == 0) {
            return 1;
        }
        // Handle case where, n < 0.
        if (n < 0) {
            n = -1 * n; // for converting -ve number to +ve because n ^ -2 = 1/n^2
            x = 1.0 / x;
        }
        // Perform Binary Exponentiation.
        double result = 1;
        while (n != 0) {
            // If 'n' is odd we multiply result with 'x' and reduce 'n' by '1'.
            if (n % 2 == 1) {
                result = result * x;
                n -= 1;
            }
            // We square 'x' and reduce 'n' by half, x^n => (x^2)^(n/2).
            x = x * x;
            n = n / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PowerXN().myPow(-7,3));
        System.out.println(new PowerXN().myPow(2,-2));
    }
}
