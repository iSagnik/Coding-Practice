'''
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
'''
class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        size = len(nums)
        if size == 0:
            return []
        if size == 1:
            return [nums[0]]
        if size == 2:
            return[nums[1], nums[0]]
        
        mul = 1
        numList = [1] * size
        
        zCount = nums.count(0)
        for i in range(size):
            if zCount > 1 or (zCount == 1 and nums[i] != 0):
                numList[i] = 0
            else:
                numList[i] = mul
            mul *= nums[i]
            
        mul = 1
        for i in range(size - 1, -1, -1):
            if zCount > 1 or (zCount == 1 and nums[i] != 0):
                numList[i] = 0
            else:
                numList[i] *= mul
            mul *= nums[i]
        return numList

# count = 0
# for ch in string:
#     if ch == given_char:
#         count += 1
# return count



# or return string.count( given_char ) #amaze right