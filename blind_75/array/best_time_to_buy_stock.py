class Solution:
    def maxProfit(self, prices: list(int)) -> int:
        profit = 0
        minPrice = 999999999999999999
        l = len(prices)
        for i in range(l):
            if prices[i] < minPrice:
                minPrice = prices[i]
            elif prices[i] - minPrice > profit:
                profit = prices[i] - minPrice
        return profit