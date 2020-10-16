class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        left = 0
        right = len(nums) - 1
        
        if nums[right] > nums[left]:
            return nums[0]
        
        while right >= left:
            mid = (right + left) / 2
            
            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            
            if nums[mid] < nums[mid - 1]:
                return nums[mid]
            # if the mid elements value is greater than the 0th element this means
            # the least value is still somewhere to the right as we are still dealing with elements greater than nums[0]
            if nums[mid] > nums[0]:
                left = mid + 1
            # if nums[0] is greater than the mid value then this means the smallest value is somewhere to the left
            else:
                right = mid - 1