#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the sockMerchant function below.
def sockMerchant(n, ar):
    pairs = 0
    ar.sort()
    print(ar)
    i = 0
    while i < n - 1:
        count = 0
        while( i < (n-1) and ar[i] == ar[i + 1] ):
            count += 1
            i += 2
        
        pairs += count
        i += 1
    return pairs


if __name__ == '__main__':
    n = 9

    ar = [10,20,20,10,10,30,50,10,20]

    result = sockMerchant(n, ar)

    print(result)

