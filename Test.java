// import java.util.Collection;
// import java.util.HashMap;
// import java.util.Random;
import java.util.*;
class Test {

    private static int countPairs(int[] list, int n) {
        HashMap<Integer, Integer> diffFreq = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int diff = list[i] - i;
            if(diffFreq.containsKey(diff)) {
                diffFreq.computeIfPresent(diff, (k, v) -> v + 1);
            }
            else {
                diffFreq.put(diff, 1);
            }
        }
        System.out.print(diffFreq.toString());
        int count = 0;
        for(int freq: diffFreq.values()) {
            count += (freq * (freq - 1)) / 2;
        }
        return count;
    }

    private static int getStringCostABAB(String s) {
        int firstIndex = s.indexOf("b"); // # of a's before first occurence of b
        int lastIndex = s.lastIndexOf("b"); //
        int strLen = s.length();
        //System.out.println(s);
        
        // (strLen - 1 - lastIndex) => # of a's after last occurence of b
        if (firstIndex > 1 && (strLen - 1 - lastIndex) > 1) {

            return 2 + getStringCostABAB(s.substring(0, firstIndex) + s.substring(firstIndex + 1));

        } else if (firstIndex == 0 || firstIndex == 1) {

            return 1 + firstIndex + getStringCostABAB(s.substring(firstIndex + 1));
            
        } else if (lastIndex >= 0 && (strLen - 1 - lastIndex) == 0 || (strLen - 1 - lastIndex) == 1) {

            return 1 + (strLen - 1 - lastIndex) + getStringCostABAB(s.substring(0, lastIndex));
        }

        return 0;
    }
    
    private static int getStringCost(String s) {
        int len = s.length();
        int firstIdx = s.indexOf("b");
        int lastIdx = s.lastIndexOf("b");

        if( firstIdx > 1 && (len - 1 - lastIdx) > 1 ) {
            return 2 + getStringCost( s.substring(0, firstIdx) + s.substring(firstIdx + 1) );
        }
        else if( firstIdx == 0 || firstIdx == 1 ) {
            return 1 + firstIdx + getStringCost(s.substring(firstIdx + 1));
        }
        else if( lastIdx >= 0 && (len - 1 - lastIdx) == 0 || (len - 1 - lastIdx) == 1 ) {
            return 1 + (len - 1 - lastIdx) + getStringCost( s.substring(0, lastIdx) );
        }
        return 0;
    }

    static int serverLoads(Integer[] loads) {
        int sum = 0;
        for(int i : loads)
            sum+= i;
        int serverMax = sum/2;
        int[] dp = new int[serverMax+1];
        for(int load : loads) {
            if(dp[serverMax] == serverMax)
                break;
            if(load > serverMax)
                continue;
            for(int i=serverMax; i >= load; i--) {
                dp[i] = Math.max(dp[i], load + dp[i - load]);
            }
        }
        return (sum - dp[serverMax]) - dp[serverMax];
    }

    public int rings(String s)
    {
        int points=0; //to store all the points
        //create a map that will store the count of each color type corresponding to it
        Map<Integer,Set<Character>> table = new HashMap<>();
        //now traverse the input string and fill the hashmap and compute the points
        int i=0;
        while(i<s.length())
        {
                Character color = s.charAt(i);
                i++;//increment i
                int rodNumber = s.charAt(i)-'0';
                //if entry not present
                if(!table.containsKey(rodNumber))
                {
                        Set<Character> set = new HashSet<>();
                        set.add(color);
                        table.put(rodNumber, set);
                }
                else
                {
                        Set<Character> set = table.get(rodNumber);
                        //add color 
                        set.add(color);
                        //if set size is 3 it means all three color ring are present on the rod
                        if(set.size()==3)
                                        points++;
                        //add set back to the map
                        table.put(rodNumber, set); 
                }
                //increment i
                i++;
        }
        return points;
    }
    
    public static int maxPalindromes(String[] A) {
        if(A == null || A.length == 0)
        return 0;
      HashMap<String, Integer> freqEqual = new HashMap<>();

      HashMap<String, Integer> freqReverse = new HashMap<>();
      for(String s: A) {
          if(s.charAt(0) == s.charAt(1)) {
            if(freqEqual.containsKey(s)) {
                freqEqual.compute(s, (k, v) -> v + 1);

            }
            else {
              freqEqual.put(s, 1);
            }
              
          }
          char[] revStringArray = new char[]{s.charAt(1), s.charAt(0)};
          String revString = new String(revStringArray);
          if(freqReverse.containsKey(revString)) {
              freqReverse.compute(revString, (k, v) -> v + 1);
          }
          else {
              freqReverse.put(s, 0);
          }
      }
      int length = 0;
      length += Collections.max(freqEqual.values()) * 2;
      for(int i: freqReverse.values()) {
          if((i + 1) % 2 == 0) {
              length += i * 2;
          }
      }

      return length;
    }
    
    public static int[] quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quicksort(int[] arr, int l, int r) {
        if(l < r + 1) {
           int p = partition(arr, l, r);
           quicksort(arr, l, p - 1);
           quicksort(arr, p + 1, r); 
        }
    }

    private static int partition(int[] arr, int l, int r) {
        swap(arr, l, getPivot(l, r));
        int border_pointer = l + 1;
        for(int i = border_pointer; i <= r; ++i) {
            if(arr[i] < arr[l])
                swap(arr, i, border_pointer++);
        }
        swap(arr, l, border_pointer - 1);
        return border_pointer - 1;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    private static int getPivot(int l, int r) {
        Random rn = new Random();
        return rn.nextInt((r - l) + 1) + l;
    }
    
    public static void main(String args[]) {
        int arr[] = { 1, 5, 6, 7, 9 };
        int n = arr.length;
        System.out.println(maxPalindromes(new String[] {"gh", "bc", "hg", "bb"}));
        System.out.println(maxPalindromes(new String[] {"gh", "bc", "hg"}));
        System.out.println(maxPalindromes(null));
        System.out.println(maxPalindromes(new String[] {"pq", "qp", "gh", "bc", "hg", "aa", "xy", "yx", "aa", "aa"}));
        System.out.println(maxPalindromes(new String[] {"pq", "qp", "gh", "bc", "hg", "aa", "xy", "yx", "aa"}));
        System.out.println(maxPalindromes(new String[] {"gh", "bc", "hg", "aa", "xy", "yx", "aa"}));
        System.out.println(countPairs(arr, n));
        System.out.println(getStringCostABAB("abbbaabaabbba"));
        System.out.println(getStringCostABAB("bbb"));
        System.out.println(getStringCostABAB("aaaa"));
        System.out.println(getStringCostABAB("bbabaa"));


        System.out.println(getStringCost("abbbaabaabbba"));
        System.out.println(getStringCost("bbabaa"));

        System.out.println(serverLoads(new Integer[] {1,2,3,4,5}));
    
       int[] sorting = new int[]{ 9,0,0,2,8,7,3,6,8,4,1,5,9,1,0,9 };
       quicksort(sorting);
       System.out.println(Arrays.toString(sorting));
    
    }
}