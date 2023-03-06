/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start_idx = 0, end_idx = nums.length - 1;
        int mid = -1;
        if(target > nums[nums.length-1])
            return nums.length;
        if(target < nums[0])
            return 0;
        if(nums.length == 2){
            if(target > nums[nums.length-1])
                return nums.length;
            else if(target <= nums[0])
                return 0;
            else
                return 1;

        }
        while(end_idx - start_idx > 1){
            mid = (start_idx + end_idx)/2;
            if (nums[mid] < target) {
                start_idx = mid + 1;
            }
            else {
                end_idx = mid;
            } 
        }
        if (nums[start_idx] == target) {
            return start_idx;
        }
        else if (nums[end_idx] == target) {
            return end_idx;
        }
        else {
            if (nums[mid] < target) {
                while(nums[mid] < target)
                    mid++;
            }
            return mid;
        }
    }
}
