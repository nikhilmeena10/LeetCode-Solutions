public class _121_Best_Time_to_Buy_and_Sell_Stock {

    //another solution mentions that the interviewer might give differences array
    //in that case maximum subarray will give the answer
    /*
    Suppose we have original array:
    [a0, a1, a2, a3, a4, a5, a6]

    what we are given here(or we calculate ourselves) is:
    [b0, b1, b2, b3, b4, b5, b6]

    where,
    b[i] = 0, when i == 0
    b[i] = a[i] - a[i - 1], when i != 0

    suppose if a2 and a6 are the points that give us the max difference (a2 < a6)
    then in our given array, we need to find the sum of sub array from b3 to b6.

    b3 = a3 - a2
    b4 = a4 - a3
    b5 = a5 - a4
    b6 = a6 - a5

    adding all these, all the middle terms will cancel out except two
    i.e.

    b3 + b4 + b5 + b6 = a6 - a2

    a6 - a2 is the required solution.
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int profit = 0, maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                profit = prices[i] - min;
                maxProfit = Math.max(maxProfit, profit);
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return maxProfit;
    }

}
