class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        seen = {}
        for word in strs:
            key = ''.join(sorted(word))
            if key not in seen:
                seen[key] = [word]
            else:
                seen[key].append(word)
        
        return list(seen.values())
        