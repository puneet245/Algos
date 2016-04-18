
//Find the longest increasing path in a matrix
public class LongestIncrPathMatr {

    int getLongestPath(int mat[][], int temp[][], int row, int col){

        if(temp[row][col]!=0)
            return temp[row][col];

        int curr = mat[row][col];
        int pathLength =1;

        if((row-1>=0) && curr < mat[row-1][col])
                pathLength= Math.max(pathLength, 1+getLongestPath(mat, temp, row-1, col));


        if((row+1<mat.length) && curr < mat[row+1][col])
            pathLength= Math.max(pathLength, 1+getLongestPath(mat, temp, row+1, col));


        if((col-1>=0) && curr < mat[row][col-1])
            pathLength= Math.max(pathLength, 1+getLongestPath(mat, temp, row, col-1));


        if((col+1<mat[0].length) && curr < mat[row][col+1])
            pathLength= Math.max(pathLength, 1+getLongestPath(mat, temp, row, col+1));

        temp[row][col] = pathLength;

        return pathLength;
    }

    public int longestIncreasingPath(int[][] mat) {

        if(mat == null || mat.length == 0)
            return 0;

        int temp[][] = new int[mat.length][mat[0].length];
        int max = 0;

        for (int i =0;i<mat.length;i++)
            for (int j=0;j<mat[0].length;j++) {
                int len = getLongestPath(mat, temp, i, j);
                if (len > max)
                    max = len;
            }

        return max;
    }

    public static void main(String[] args) {

        LongestIncrPathMatr lip = new LongestIncrPathMatr();

        //Below is a sample input, please change it to your own or take it from console/file
        int mat[][] = { {10,19,3,4},
                        {6,116,8,6},
                        {12,11,11,6},
                        {12,11,11,6}};

        System.out.println(lip.longestIncreasingPath(mat));

    }
}
