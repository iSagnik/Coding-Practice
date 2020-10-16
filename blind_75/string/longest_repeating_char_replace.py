class Solution(object):
    def characterReplacement(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        max_count = 0
        start = i = 0
        char_counts = {}

        while i < len(s):
            char_counts[s[i]] += 1
            max_count = max(max_count, char_counts[s[i]])
            if i - start + 1 > k + max_count:
                char_counts[s[start]] -= 1
                start += 1
            i += 1

        return min(max_count + k, len(s))