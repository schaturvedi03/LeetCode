/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
*/
class Solution {
    public boolean canJump(int[] nums) {
        int [] sum = new int [nums.length];
        Arrays.fill(sum, 0);
        int l = 0, r = 0;
        if(nums.length==1)
            return true;
        if(nums[0]>0){
            if(1 < nums.length)
                sum[1] = 1;
            if((1+nums[0])<nums.length)
                sum[1+nums[0]] = -1;
        }
        for(int i=1;i<nums.length;i++){
            sum[i] += sum[i-1];
            if(nums[i] > 0 && sum[i] > 0){
                l = i+1; r = l + nums[i]; 
                if(l < nums.length)
                    sum[l]++;
                if(r<nums.length)
                    sum[r]--;
            }
        }
        return (sum[nums.length-1] > 0);
    }
}
