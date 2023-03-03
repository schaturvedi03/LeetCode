/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                System.out.println("Condition 1");
                st.push(s.charAt(i));
            }
            if((s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') &&
                            st.isEmpty()) {
                 System.out.println("Condition 3");
                 st.push(s.charAt(i));
             }  
            if((s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') &&
                            !st.isEmpty())   
            {
                System.out.println("Condition 2");
                switch(s.charAt(i)){
                    case ')': 
                        if(st.peek() == '('){
                            st.pop();
                            System.out.println("Popped");
                        }
                        else
                            st.push(s.charAt(i));
                        break;
                    case '}': 
                        if(st.peek() == '{')
                            st.pop();
                        else
                            st.push(s.charAt(i));
                        break;
                    case ']': 
                        if(st.peek() == '[')
                            st.pop();
                        else
                            st.push(s.charAt(i));
                        break;
                    default: System.out.println("Invalid Input!");
                }
                continue;
            }
            
        }
        if(st.isEmpty())
            return true;
        return false;
    }
}
