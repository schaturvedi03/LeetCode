/*

Given a string s, find the length of the longest substring without repeating characters.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, max_len = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(i));
            if((i-start+1) > max_len)
                max_len = i-start+1;
        }
        return max_len;
    }
}
