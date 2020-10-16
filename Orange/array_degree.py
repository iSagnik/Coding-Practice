#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'degreeOfArray' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#

def degreeOfArray(arr):
    degreeMap = {}
    startIndex = {}
    endIndex = {}
    
    size = len(arr)
    maxVal = 0
    for i in range(0, size):
        val = arr[i]
        if val in degreeMap:
            degreeMap[val] = degreeMap[val] + 1
        else:
            startIndex[val] = i
            degreeMap[val] = 1
        endIndex[val] = i
        maxVal = max(maxVal, degreeMap[val])
    result = size
    for i in degreeMap.keys():
        if degreeMap[i] == maxVal:
           length = endIndex[i] - startIndex[i] + 1
           result = min(result, length)
    return result 
        