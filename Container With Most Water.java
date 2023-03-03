/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
*/

class Solution {
    public int maxArea(int[] height) {
        int low = 0, high = height.length-1;
        int max_area = 0;
        while(low<high){
            int temp_area = Math.min(height[low],height[high])*(high-low);
            if(temp_area > max_area)
                max_area = temp_area;
            if(height[low]<height[high])
                low++;
            else
                high--;
        }
        return max_area;
    }
}
