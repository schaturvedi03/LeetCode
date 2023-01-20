# https://leetcode.com/problems/two-sum/
# 
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
#


import java.util.*;
import java.io.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> a = new HashMap<>();
        int [] pos = new int[2];
        for(int i=0;i<nums.length;i++){
            a.put(i,nums[i]); 
        }
        for(int i=0;i<nums.length-1;i++){
            int diff = target - nums[i];
            if(a.containsValue(diff)){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]==diff){
                        pos[0] = i; pos[1] = j; 
                        return pos;
                    }
                }
            }
        }
        return pos;
    }
}
