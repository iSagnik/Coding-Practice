'''
public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>(nums.length);
    for (int x: nums) {
        if (set.contains(x)) return true;
        set.add(x);
    }
    return false;
}
'''
class Solution:
    def containsDuplicate(self, nums: list(int)) -> bool:
        nSet = set()
        for n in nums:
            if n in nSet:
                return True
            else:
                nSet.add(n)
        return False