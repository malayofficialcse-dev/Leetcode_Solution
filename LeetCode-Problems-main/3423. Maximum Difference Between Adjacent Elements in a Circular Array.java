class Solution {
    public int maxAdjacentDistance(int[] nums) {
       int max=0;
       for(int i=0;i<nums.length-1;i++){
        max=Math.max(max,Math.abs(nums[i+1]-nums[i]));
       }
       max=Math.max(max,Math.abs(nums[nums.length-1]-nums[0]));
       return max;
    }
}
