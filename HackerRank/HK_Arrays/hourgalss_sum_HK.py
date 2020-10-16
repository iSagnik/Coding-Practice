#!/bin/python3

import math
import os
import random
import re
import sys

def countSum(i, j, arr):
    addition = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]
    return addition

# Complete the hourglassSum function below.
def hourglassSum(arr):
    i = 0
    j = 0
    result = -99999999999
    while i < 4:
        j = 0
        while j < 4:
            temp = countSum(i, j, arr)
            if  temp > result:
                result = temp
            j += 1
        i += 1
    return result


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr = []

    for _ in range(6):
        arr.append(list(map(int, input().rstrip().split())))

    result = hourglassSum(arr)

    fptr.write(str(result) + '\n') 

    fptr.close()
