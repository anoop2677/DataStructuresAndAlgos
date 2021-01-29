/*
Pairs with given sum II
Problem Description

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:


A = [1, 1]
B = 2


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 Any two pairs sum up to 2.
Explanation 2:

 only pair (1, 2) sums up to 2.
 */
package TwoPointer;

public class PairsWithGivenSum {
    public int solve(int[] A, int B) {
        if(A.length == 1) return 0;
        int i = 0, j = A.length - 1;
        long count = 0;
        long mod = (long)1e9 + 7;
        while(i < j){
            long sum = A[i] + A[j];
            if(sum == B){
                int x = A[i], xx = i;
                while ((i < j ) && (A[i] == x)){
                    i++;
                }
                int y = A[j], yy = j;
                while ((j >= i )&& (A[j] == y)){
                    j--;
                }
                if (x == y){
                    long temp = i - xx + yy - j - 1;
                    count = (count + ((temp * (temp + 1)) / 2)%mod)%mod;
                }
                else
                    count = (count + ((i - xx) * (yy - j))%mod)%mod;
            }
            else if(sum < B){
                i++;
            }
            else j--;
        }
        return (int)(count%mod);
    }
}
