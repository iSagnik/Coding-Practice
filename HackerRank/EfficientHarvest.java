import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Results {

    /*
     * Complete the 'maxProfit' function below.
     *
     * The function is expected to return a LONG_INTEGER. The function accepts
     * following parameters: 1. INTEGER k 2. INTEGER_ARRAY profit
     */

    public static long maxProfit(int k, List<Integer> profit) {
        // Write your code here
        int value = 0, maxprofit = 0;
        int n = profit.size();
        // farm size and segment count are equal then return whole sum

        if (n == k * 2) {

            for (int i = 0; i < n; i++)

                maxprofit += profit.get(i);

        }

        else {

            for (int i = 0; i <= n / 2; i++) {

                int x = i;

                for (int j = 0; j < k; j++) {

                    int limit;

                    // rotate the index back to start if index crosses n

                    if (x + (n / 2) < n)

                        limit = x + (n / 2);

                    else

                        limit = x - (n / 2);

                    // compute value for single iteration

                    value += profit.get(x)+ profit.get(limit);

                    if (x + 1 < n)

                        x += 1;

                }

                if (value > maxprofit) {

                    maxprofit = value;

                    value = 0;

                }

                else
                    value = 0;

            }

        }

        // return output

        return maxprofit;
    }

}

class EfficientHarvest {
    public static void main(String args[]) {
        System.out.println(Results.maxProfit(1, Arrays.asList(3, -5)));
        System.out.println(Results.maxProfit(1, Arrays.asList(-3, -6, 3, 6)));
        System.out.println(Results.maxProfit(1, Arrays.asList(-6, 3, 6, -3)));

    }
}