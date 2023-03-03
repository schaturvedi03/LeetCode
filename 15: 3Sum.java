/*

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=0,k=0;
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for(i=0;i<nums.length;i++){
            j = i + 1;
            k = nums.length - 1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0)
                {
                    ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k]));
                    if(!set.contains(list)){
                        set.add(list); 
                        arr.add(list);
                    }
                    j++; k--;
                }
                else if(sum > 0){
                    k--;
                }
                else if(sum < 0){
                    j++;
                }
            }
        }
        return arr;
    }
}
