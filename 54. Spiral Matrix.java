/*
Given an m x n matrix, return all elements of the matrix in spiral order.
*/

class Solution {
    public String DFS(int x, int y, int [][] matrix, HashMap<String, Boolean> map, String output, String direction){
        if(x<matrix.length && y<matrix[0].length && x>=0 && y>=0){
            String s = Integer.toString(x) + "," + Integer.toString(y);
            if(!map.containsKey(s) || !map.get(s)){
                output += ","+Integer.toString(matrix[x][y]);
                map.put(s, true);
                String pos = "";
                switch(direction){
                    case "RIGHT": 
                        pos = Integer.toString(x) + "," + Integer.toString(y+1);
                        if(y+1<matrix[0].length && !map.containsKey(pos))
                            output = DFS(x, y+1, matrix, map, output, "RIGHT");
                        else
                            output = DFS(x+1, y, matrix, map, output, "BOTTOM");  
                        break;
                    case "BOTTOM":
                        pos = Integer.toString(x+1) + "," + Integer.toString(y);
                        if(x+1<matrix.length  && !map.containsKey(pos))
                            output = DFS(x+1, y, matrix, map, output, "BOTTOM");
                        else
                            output = DFS(x, y-1, matrix, map, output, "LEFT");
                        break;
                    case "LEFT":
                        pos = Integer.toString(x) + "," + Integer.toString(y-1);
                        if(y>0  && !map.containsKey(pos))
                            output = DFS(x, y-1, matrix, map, output, "LEFT");
                        else
                            output = DFS(x-1, y, matrix, map, output, "UP");
                        break;
                    case "UP":
                        pos = Integer.toString(x-1) + "," + Integer.toString(y);
                        if(x>0  && !map.containsKey(pos))
                            output = DFS(x-1, y, matrix, map, output, "UP");
                        else
                            output = DFS(x, y+1, matrix, map, output, "RIGHT");
                        break;
                }
            }
        }
        return output;
                    
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        HashMap<String, Boolean> map = new HashMap<>();
        String result = DFS(0,0,matrix,map,"","RIGHT");
        System.out.println(result);
        String [] op = result.split(",");
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<op.length;i++){
            arr.add(Integer.parseInt(op[i]));
        }
        return arr;
    }
}
