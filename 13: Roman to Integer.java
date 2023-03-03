//https://leetcode.com/problems/roman-to-integer/

class Solution {
    public int romanToInt(String s) {
        int val = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1); map.put('V',5); 
        map.put('X',10); map.put('L',50);
        map.put('C',100); map.put('D',500);
        map.put('M',1000);
        for(int i=0;i<s.length();i++){
            if(i<s.length()-1 && s.charAt(i)=='I' && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X')){
                val += map.get(s.charAt(i+1))-1; i++;
            }
            else if(i<s.length()-1 && s.charAt(i)=='X' && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C')){
                val += map.get(s.charAt(i+1))-10; i++;
            }
            else if(i<s.length()-1 && s.charAt(i)=='C' && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M')){
                val += map.get(s.charAt(i+1))-100; i++;
            }
            else
                val += map.get(s.charAt(i));
        }     
        return val;  
    }
}
