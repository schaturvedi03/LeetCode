/*

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

*/

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(m!=n){
            for(int i=0;i<=m-n;i++){
                String temp = haystack.substring(i, i+needle.length());
                if(temp.equals(needle))
                    return i;
            }
        }
        else{
            if(haystack.equals(needle))
                return 0;
        }
        return -1;
    }
}

