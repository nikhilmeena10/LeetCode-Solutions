import java.util.Arrays;
import java.util.Stack;

public class _85_Maximal_Rectangle {

    //Using logic from Maximum area rectangle in a histogram
    //For each row, update height array and find max area
    public int maximalRectangleStack(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        int[] height = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= n; j++) {
                int h = (j == n) ? 0 : height[j];
                if (stack.isEmpty() || h >= height[stack.peek()]) {
                    stack.push(j);
                } else {
                    int top = stack.pop();
                    maxArea = Math.max(maxArea, height[top] * (stack.isEmpty() ? j : j - 1 - stack.peek()));
                    j--;
                }
            }
        }
        return maxArea;
    }

    //Interesting solution: https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution
    //Every row, find max left limit and min right limit for that index, then multiply by height for that range
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int[] left = new int[m];
        int[] right = new int[m];
        Arrays.fill(right, m);
        int[] height = new int[m];
        for (int i = 0; i < n; i++) {
            int currRight = m;
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], currRight);
                } else {
                    right[j] = m;
                    currRight = j;
                }
            }
            int currLeft = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                    left[j] = Math.max(left[j], currLeft);
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j]));
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }
        }
        return maxArea;
    }

}
