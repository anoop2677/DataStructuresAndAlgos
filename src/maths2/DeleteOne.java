/*
Delete one
Problem Description

Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.



Problem Constraints
2 <= N <= 105
1 <= A[i] <= 109



Input Format
First argument is an integer array A.



Output Format
Return an integer denoting the maximum value of GCD.



Example Input
Input 1:

 A = [12, 15, 18]
Input 2:

 A = [5, 15, 30]


Example Output
Output 1:

 6
Output 2:

 15


Example Explanation
Explanation 1:


 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum vallue of gcd is 6.
Explanation 2:

 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.
 */
package maths2;

public class DeleteOne {
    public int gcd(int a, int b){
        if(b==0)return a;
        return gcd(b, a%b);
    }
    public int solve(int[] A) {
        int n = A.length;
        int[] prefix = new int[A.length];
        int[] suffix = new int[A.length];
        prefix[0] = A[0];
        suffix[A.length-1] = A[A.length-1];
        for(int i = 1; i < A.length; i++){
            prefix[i] = gcd(prefix[i-1], A[i]);
            suffix[n-i-1] = gcd(suffix[n-i], A[n-i-1]);
        }
        int max = suffix[1];
        for(int i = 1; i < A.length; i++){
            if(i<A.length-1 && i>0)
                max = Math.max(max,gcd(prefix[i-1],suffix[i+1]));
            else max = Math.max(max, prefix[i-1]);

        }
        return max;
    }
}
