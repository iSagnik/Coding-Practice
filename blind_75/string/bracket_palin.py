from collections import deque

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = deque()
        temp = {
            ')': '(',
            ']': '[',
            '}': '{'
        }
        for ch in s:
            if ch == '(' or ch == '[' or ch == '{':
                stack.append(ch)
            elif len(stack) != 0 and stack[-1] == temp[ch]:
                stack.pop()
            else:
                return False
        return len(stack) == 0