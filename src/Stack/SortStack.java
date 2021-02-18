/*
Sort stack using another stack
Problem Description

Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.



Problem Constraints
1 <= |A| <= 5000

0 <= A[i] <= 1000000000



Input Format
The only argument given is the integer array A.



Output Format
Return the array of integers after sorting the stack using another stack.



Example Input
Input 1:

 A = [5, 4, 3, 2, 1]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 [1, 2, 3, 4, 5]
Output 2:

 [5, 11, 17, 100]


Example Explanation
Explanation 1:

 Just sort the given numbers.
Explanation 2:

 Just sort the given numbers.
 */
package Stack;

import java.util.Stack;

public class SortStack {
    public int[] solve(int[] A) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        st.push(A[0]);
        for(int i = 1; i < A.length; i++){
            if(A[i] < st.peek()){
                st.push(A[i]);
            }
            else{
                while(!st.isEmpty() && A[i] > st.peek()){
                    temp.push(st.pop());
                }
                st.push(A[i]);
                while(!temp.isEmpty()){
                    st.push(temp.pop());
                }
            }
        }
        int i = 0;
        while(!st.isEmpty() && i < A.length){
            A[i] = st.pop();
            i++;
        }
        return A;
    }
}
