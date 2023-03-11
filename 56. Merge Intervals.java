/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
*/
class Solution {
    class sort implements Comparator<int[]>{
        public int compare(int[] x, int[] y){
            if(x[0] > y[0])
                return 1;
            else if(x[0] < y[0])
                return -1;
            else{
               if(x[1] > y[1])
                    return 1;
                else if(x[1] < y[1])
                    return -1; 
                else
                    return 0;
            }
        }
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new sort());
        ArrayList<int[]> arr = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(start <= intervals[i][0] && intervals[i][0] <= end){
                end = Math.max(intervals[i][1], end);
            }
            else{
                int[] temp = {start, end};
                arr.add(temp);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        int[] temp = {start, end};
        arr.add(temp);
        int[][] answer = new int[arr.size()][2];
        for(int i=0;i<arr.size();i++){
            answer[i][0] = arr.get(i)[0];
            answer[i][1] = arr.get(i)[1];
        } 
        return answer;
    }
}
