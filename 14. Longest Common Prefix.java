//https://leetcode.com/problems/longest-common-prefix/

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix,0)!=0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
            if(prefix.equals(""))
                return ""; 
        }
        return prefix;
    }
}
