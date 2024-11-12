package LeetCode;

//[241112] 소요시간 : 10분

public class _121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int maxPrice = prices[prices.length-1];
        int result = 0;
        for(int i=prices.length-2; i>=0; i--){
            // 앞선 day 가 최대 가격 일 때
            if(prices[i]>maxPrice){
                maxPrice = prices[i];
            }
            // 수익 계산
            else{
                // 현재 얻은 최대 수익보다 더 큰 수익을 낼 수 있다면
                if(result < maxPrice-prices[i]){
                    result = maxPrice - prices[i];
                }
            }
        }
        return result;
    }
}
