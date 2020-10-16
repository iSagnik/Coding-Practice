#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'isPrime' function below.
#
# The function is expected to return an INTEGER.
# The function accepts LONG_INTEGER n as parameter.
#

def isPrime(n):
    div = float('inf')

    for i in range(2, n):
        if n % i == 0:
            return i
    return 1
