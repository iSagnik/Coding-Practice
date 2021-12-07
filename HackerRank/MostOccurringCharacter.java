public class MostOccurringCharacter {
    public char maxOccurances(Striing text) {
        LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
        char charArray[] = text.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char key = charArray[i];
            if (charCount.containsKey(charArray[i])) {

                charCount.put(key, charCount.get(key) + 1);
            } else {
                charCount.put(key, 1);
            }
        }
        char currentMaxCharacter = ' ';
        int currentMaxCount = -1;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > currentMaxCount) {
                currentMaxCharacter = entry.getKey();
                currentMaxCount = entry.getValue();
            }
        }
        return currentMaxCharacter;
    }
}
