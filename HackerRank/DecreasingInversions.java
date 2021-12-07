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



class Result {

    /*
     * Complete the 'maxInversions' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

   
//      LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
//      char charArray[] = text.toCharArray();
     
//      for(int i = 0; i < charArray.length; i++) {
//        char key = charArray[i];
//        if(charCount.containsKey(charArray[i])) {
           
//            charCount.put(key, charCount.get(key) + 1);
//        }
//        else {
//            charCount.put(key, 1);
//        }
//      }
//      char currentMaxCharacter = ' ';
//      int currentMaxCount = -1;
//      for(Map.Entry<Character, Integer> entry: charCount.entrySet()) {
//          if(entry.getValue() > currentMaxCount) {
//              currentMaxCharacter = entry.getKey();
//              currentMaxCount = entry.getValue();
//          }
//      }
//      return currentMaxCharacter;
//  }

    public static long maxInversions(List<Integer> arr) {
        long result = 0;
        for(int i = 0; i < arr.size() - 2; i++) {
            int countValue = 1;
            
            int temp = i;
            int counter = 1;
            for(int j = i + counter; j < arr.size() -1 ; j++) {
                if (arr.get(j) < arr.get(temp)) {
                    countValue++;
                    temp = j;
                }
                if (countValue == 3) {
                    result++;
                    countValue = 1;
                    j = i + counter + 1;
                }
            }
        }
        return result;
    
    }

}

public class DecreasingInversions {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.maxInversions(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
