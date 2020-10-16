class Solution:
    def twoSum(self, nums, target: int):
        compList = {}
        l = len(nums)
        for i in range(l):
            if nums[i] in compList:
                return [i, compList[nums[i]]]
            else:
                comp = target - nums[i]
                compList[comp] = i
s = Solution()
print(s.twoSum([3,2,3], 6))