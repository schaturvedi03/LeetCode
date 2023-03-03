/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

*/

class Solution {
    public static HashMap<Character, String> map;
    public void backTrack(int index, String digits, List<String> arr, Stack<Character> st){
        if(index == digits.length()){
            if(st.isEmpty())
                return;
            String str = "";
            for(char c : st){
                str += c;
            }
            arr.add(str);
            return;
        }
        for(char c : map.get(digits.charAt(index)).toCharArray()){
            st.push(c);
            backTrack(index+1, digits, arr, st);
            st.pop();
        }
    }
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        ArrayList<String> arr = new ArrayList<>();
        backTrack(0,digits,arr,new Stack<Character>());
        return arr;
    }
}

