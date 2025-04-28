package lakshmi.blind75;


// Time Complexity:**
// You are looping through the `stockPrices` array **once**
// Inside the loop, all operations (`Math.min`, subtraction, `Math.max`) are **O(1)** — constant time.
// Thus, the **time complexity is**: **O(n)** where `n` = number of elements in the `stockPrices` array.

// Space Complexity:**
// You are using a few variables (`profit`, `buyPrice`, `currentProfit`), but **no extra data structures** (like arrays, lists, etc.).
// The extra space you use is **constant** — it does **not** depend on input size.
// Thus, the **space complexity is**: **O(1)**
public class TimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] stockPrices = {7, 6, 5, 4, 3, 2};
        int maxProfit = findMaxProfit(stockPrices);
        System.out.println(maxProfit);
    }

    private static int findMaxProfit(int[] stockPrices) {
        int profit = 0;
        int buyPrice = stockPrices[0];

        for (int i = 1; i < stockPrices.length; i++) {
            buyPrice = Math.min(stockPrices[i], buyPrice);
            int currentProfit = stockPrices[i] - buyPrice;
            profit = Math.max(profit, currentProfit);
        }
        return profit;
    }
}
