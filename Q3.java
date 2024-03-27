//You are given an array/list of ‘N’ integers. You are supposed to return the maximum sum of the subsequence with the
//        constraint that no two elements are adjacent in the given array/list.
//
//        Note:
//        A subsequence of an array/list is obtained by deleting some number of elements (can be zero) from the array/list,
//        leaving the remaining elements in their original order.
//        Detailed explanation ( Input/output format, Notes, Images )
//        Constraints:
//        1 <= T <= 500
//        1 <= N <= 1000
//        0 <= ARR[i] <= 10^5
//
//        Where 'ARR[i]' denotes the 'i-th' element in the array/list.
//
//        Time Limit: 1 sec.
//        Sample Input 1:
//        2
//        3
//        1 2 4
//        4
//        2 1 4 9
//        Sample Output 1:
//        5
//        11
//        Explanation to Sample Output 1:
//        In test case 1, the sum of 'ARR[0]' & 'ARR[2]' is 5 which is greater than 'ARR[1]' which is 2 so the answer is 5.

package March_26_Assignment;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt(); // number of test cases

        while (t-- > 0) {
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt(); // size of the array
            int[] arr = new int[n]; // array to store the elements

            System.out.print("Enter the elements of the array separated by spaces: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt(); // input elements of the array
            }

            int result = maxSumNoAdjacent(arr); // calculate the maximum sum
            System.out.println("Maximum sum of subsequence with no adjacent elements: " + result); // print the result
        }
        scanner.close();
    }

    public static int maxSumNoAdjacent(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int incl = arr[0]; // maximum sum including the current element
        int excl = 0; // maximum sum excluding the current element

        for (int i = 1; i < n; i++) {
            int temp = incl; // store the previous value of incl
            incl = Math.max(incl, excl + arr[i]); // update incl
            excl = temp; // update excl with the previous value of incl
        }

        return Math.max(incl, excl); // return the maximum of incl and excl
    }
}
