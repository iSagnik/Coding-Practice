def maxInversions(arr):
    largerThanRightCount = [0] * len(arr)
    print(type(largerThanRightCount))
    print(largerThanRightCount)
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            if arr[i] > arr[j]:
                largerThanRightCount[i] += 1
        
    result = 0
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            if arr[i] > arr[j]:
                result += largerThanRightCount[j]
        
    return result

maxInversions([5,8,7,9])