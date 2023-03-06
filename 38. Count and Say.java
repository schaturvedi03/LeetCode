/*

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.


Given a positive integer n, return the nth term of the count-and-say sequence
*/
class Solution {
    public String countAndSay(int n) {
        String[] count = new String[n+1];
        count[1] = "1";
        for(int i=2;i<=n;i++){
            say(count, i);
        }
        return count[n];
    }
    public void say(String[] count, int n){
        String temp = "";
        if(count[n-1].length() == 1){
            temp += "1" + count[n-1];
        }
        else{
            for(int i=0;i<=count[n-1].length()-1;i++){
                if(i == count[n-1].length()-1){
                    temp += "1" + count[n-1].charAt(i);
                    continue;
                }
                if(count[n-1].charAt(i)!=count[n-1].charAt(i+1)){
                    temp += "1" + count[n-1].charAt(i);
                }
                else{
                    int counter = 1;
                    while(i<count[n-1].length()-1 &&
                        count[n-1].charAt(i)==count[n-1].charAt(i+1)){
                        counter++; i++;
                    }
                    temp += Integer.toString(counter) + count[n-1].charAt(i);
                }
            }
        }
        count[n] = temp;
    }
}

