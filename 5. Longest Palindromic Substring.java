/*

Given a string s, return the longest palindromic substring in s.

*/

class Solution {
    int max_len = 0;
    int [] pos = {0,0};
    public void check(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            if(max_len < r-l+1){
                max_len = r-l+1;
                pos[0] = l; pos[1] = r;
            }
            l--; r++;
        }
        
    }
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            check(s,i,i);
            check(s,i,i+1);
        }
        return s.substring(pos[0],pos[1]+1);
    }
}
