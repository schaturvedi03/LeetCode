/*

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order

*/

class Solution {
    public void swap(int x, int y, int [] nums){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public void scramble(int l, int r, int [] nums, List<List<Integer>> answer) { 
        if(l == r){ 
            List<Integer> arr = new ArrayList<Integer>();
            for(int a : nums)
                arr.add(a);
            answer.add(arr);
            return;
        }
        for(int i=l;i<=r;i++){
            swap(l,i,nums);
            scramble(l+1,r,nums,answer);
            swap(l,i,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        scramble(0,nums.length-1,nums, answer);
        return answer;
    }
}
