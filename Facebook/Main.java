import java.util.*;
// Add any extra import statements you may need here

class Main {
    
    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        Arrays.sort(array_a);
        Arrays.sort(array_b);
        return Arrays.equals(array_a, array_b);
      }

    Node reverse(Node head) {
        // Write your code here
        Node cur = head;
        boolean subSequence = false;
        Node result = new Node(-1);
        Node curResult = result;
        while (cur != null) {
            Stack<Node> tempStack = new Stack<>();
            while (cur != null && cur.data % 2 == 0) {
                subSequence = true;
                tempStack.push(cur);
                cur = cur.next;
            }
            if (subSequence)
                while (!tempStack.isEmpty()) {
                    curResult.next = new Node(tempStack.pop().data);
                    curResult = curResult.next;
                    subSequence = false;
                }
            else {
                curResult.next = cur;
                curResult = curResult.next;
                cur = cur.next;

            }

        }
        return result.next;
    }

    int numberOfWays(int[] arr, int k) {
        HashMap<Integer, Integer> seenDiff = new HashMap<>();
        int ways = 0;
        for (int i = 0; i < arr.length; ++i) {

            int diff = k - arr[i];
            if (seenDiff.containsKey(diff)) {
                int count = seenDiff.get(diff);
                ways += count;
            }
            if (seenDiff.containsKey(arr[i])) {
                seenDiff.put(arr[i], seenDiff.get(arr[i]) + 1);
            } else {
                seenDiff.put(arr[i], 1);
            }
        }
        return ways;
    }

    String rotationalCipher(String input, int rotationFactor) {

        // Write your code here
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (Character.isDigit(chars[i])) {

                int position = (chars[i] - '0' + rotationFactor) % 10;
                chars[i] = (char) (position + '0');
            } else if (Character.isUpperCase(chars[i])) {

                int position = (chars[i] - 'A' + rotationFactor) % 26;
                chars[i] = (char) (position + 'A');
            } else if (Character.isLowerCase(chars[i])) {

                int position = (chars[i] - 'a' + rotationFactor) % 26;
                chars[i] = (char) (position + 'a');
            }
            // chars[i] = chars[i] + rotation;
        }
        return new String(chars);
    }

    int[] countSubarrays(int[] arr) {
        // Write your code here
        int[] result = new int[arr.length];

        Stack<Integer> train = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {

            while (!train.isEmpty() && arr[i] > arr[train.peek()]) {
                int dismounted = train.pop();
                result[dismounted] = i - dismounted;
            }
            train.push(i);
        }

        while (!train.isEmpty()) {
            int dismounted = train.pop();
            result[dismounted] = arr.length - dismounted;
        }

        for (int i = arr.length - 1; i >= 0; --i) {
            result[i]--;
            while (!train.isEmpty() && arr[i] > arr[train.peek()]) {
                int dismounted = train.pop();
                result[dismounted] += dismounted - i;
            }
            train.push(i);
        }
        while (!train.isEmpty()) {
            int dismounted = train.pop();
            result[dismounted] += dismounted + 1;
        }
        return result;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int[] test_1 = { 3, 4, 1, 6, 2 };
        int[] expected_1 = { 1, 3, 1, 5, 1 };
        int[] output_1 = countSubarrays(test_1);
        check(expected_1, output_1);

        int[] test_2 = { 2, 4, 7, 1, 5, 3 };
        int[] expected_2 = { 1, 2, 6, 1, 3, 1 };
        int[] output_2 = countSubarrays(test_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}