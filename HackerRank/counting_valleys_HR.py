#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'countingValleys' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER steps
#  2. STRING path
#

def countingValleys(steps, path):
    valleys = 0
    alt = 0
    inValley = False
    for ch in path:
        if ch == 'U':
            alt += 1
            if alt >= 0:
                inValley = False
        if ch == 'D':
            alt -= 1
            if alt < 0 and not inValley:
                valleys += 1
                inValley = True

    return valleys

if __name__ == '__main__':
    steps = 12
    path = 'DDUUDDUDUUUD'
    result = countingValleys( steps, path )
    print( result )
