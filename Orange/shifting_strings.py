
#
# Complete the 'getShiftedString' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING s
#  2. INTEGER leftShifts
#  3. INTEGER rightShifts
#

def getShiftedString(s, leftShifts, rightShifts):
    print(leftShifts, rightShifts)
    size = len(s)
    print(size)
    if leftShifts >= rightShifts:
        n = leftShifts - rightShifts
    else:
        n = size - (rightShifts - leftShifts)
    if n == 0:
        return s
    print(n)
    print(size)
        
    result = []
    i = 0
    pos = n % size
    while i < size:
        result.append( s[pos] )
        pos  = (pos + 1) % size
        i += 1
    
    return "".join( result )