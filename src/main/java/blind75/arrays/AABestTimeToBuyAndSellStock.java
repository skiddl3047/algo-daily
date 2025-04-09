package blind75.arrays;

public class AABestTimeToBuyAndSellStock {

    public int maxProfit2ms(int[] prices) {
        int buy = Integer.MAX_VALUE, max_profit = Integer.MIN_VALUE;
        for (int price : prices) {
            // Checking for lower buy value
            buy = Math.min(buy, price);
            // Checking for higher profit
            max_profit = Math.max(max_profit, price - buy);
        }
        return max_profit;
    }

    public static void main(String[] args) {
        System.out.println(new AABestTimeToBuyAndSellStock().maxProfit1ms(new int[]{7,1,5,3,6,4}));
        System.out.println(new AABestTimeToBuyAndSellStock().maxProfit2ms(new int[]{7,1,5,3,6,4}));
        System.out.println(new AABestTimeToBuyAndSellStock().maxProfit1ms(new int[]{7,6,4,3,1}));
        System.out.println(new AABestTimeToBuyAndSellStock().maxProfit2ms(new int[]{7,6,4,3,1}));
    }

    public int maxProfit1ms(int[] prices) {
        int maxProfit = 0;
        int minBuy = prices[0];
        for(int currentDayPrice : prices){
            maxProfit = Math.max(maxProfit, currentDayPrice - minBuy);
            if(currentDayPrice < minBuy)
                minBuy = currentDayPrice;
        }
        return maxProfit;
    }
}
