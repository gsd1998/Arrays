package interviewQA;

public class BestTmeToBuyandSellStock {

    public static void main(String[] args) {
        int[] prices ={2,1,2,0,1};
        System.out.println(maxProfit(prices));
    }

    /*
        'i' represents the day we will sell. We will check if price at day 'i' - minimum of 0 to i-1 is greater than
        current profit or not. If greater we take this as the new profit.
        Before moving to the next day (which is i++) we will check which day has the minimum amount to buy from 0 to i-1 nth day.
        Whichever day has the minimum amount is updated as the minimum.
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int cost = 0;
        int minimum = prices[0];
        for(int i = 1; i <= prices.length-1; i++){
            cost = prices[i] - minimum;
            profit = Math.max(cost, profit);
            minimum = Math.min(minimum,prices[i]);
        }
        return profit;
    }


}
