#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'palindrome' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING s as parameter.
#

def palindrome(s):
    m = dict() 
    n = len(s) 
  
    # table for storing results (2 rows for odd- 
    # and even-length palindromes 
    R = [[0 for x in range(n+1)] for x in range(2)] 
  
    s = "@" + s + "#"
  
    for j in range(2): 
        rp = 0   
        R[j][0] = 0
  
        i = 1
        while i <= n: 
  
            while s[i - rp - 1] == s[i + j + rp]: 
                rp += 1   

            R[j][i] = rp 
            k = 1
            while (R[j][i - k] != rp - k) and (k < rp): 
                R[j][i+k] = min(R[j][i-k], rp - k) 
                k += 1
            rp = max(rp - k, 0) 
            i += k 
  
    s = s[1:len(s)-1] 

    m[s[0]] = 1
    for i in range(1,n): 
        for j in range(2): 
            for rp in range(R[j][i],0,-1): 
                m[s[i - rp - 1 : i - rp - 1 + 2 * rp + j]] = 1
        m[s[i]] = 1
    return len(m)