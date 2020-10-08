public class Solution {
    
    
    private int[] stock_prices = new int[]{};
    
    public static int getMaxProfit(int[] stockPrices) {
        
            if(stockPrices.length == 1){
                throw new RuntimeException();
            }
                            
            int initial_stock_price = stockPrices[0]; 
            int higher_stock_price = initial_stock_price;
            // calculate the max profit
            for (int i=1;i<stockPrices.length;i++){
                if(stockPrices[i] > stockPrices[i+1]){
                    if(stockPrices[i] > stockPrices[i+1]){
                        higher_stock_price = stockPrices[i];
                    } else{
                        higher_stock_price = stockPrices[i+1];
                    }
                }
            }
            
            return higher_stock_price - initial_stock_price;
        
    }
}


