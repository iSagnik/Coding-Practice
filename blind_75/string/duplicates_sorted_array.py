class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2:
            return len(nums)
        
        i = 1
        while i <= len(nums) -1:
            if nums[i] == nums[i-1] and i != 0:
                nums.pop(i-1)
                i -= 1
                
            i += 1
        return len(nums)
        