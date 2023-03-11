/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int[] sum = new int[digits.length+1]; 
        boolean carry = false; 
        int pos = 0;
        sum[sum.length-1] = digits[digits.length-1] + 1;
        if(sum[sum.length-1] > 9){
            sum[sum.length-1] %= 10;
            carry = true;
        }
        for(int i=digits.length - 2;i>=0;i--){
            int temp = digits[i];
            if(carry == false){
                sum[i+1] = temp;
            }
            else{
                if(temp + 1 <= 9){
                    sum[i+1] = temp + 1; carry = false;
                }
                else{
                    sum[i+1] = (temp + 1)%10;
                }
            }
        }
        if(carry == true){
            sum[0] = 1; return sum;
        }
        return Arrays.copyOfRange(sum, 1, sum.length);
            
    }
}
