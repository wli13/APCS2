//Team Cheesy Potatoes -- Wenting Li, Alexia Leong, Bing Li
//APCS2 pd01
//HW03 -- I Am Still Searching
//2018-02-02 T

/*
 *Consider an n x n 2D array of ints, wherein numbers increase across any row (L->R) and down any column...
 *
 *e.g.,
 *
 *| 1  3  5 |
 *
 *| 3  7  8 |
 *
 *| 5 12 15 |
 *... Given a target number returns the coordinates of the first occurence of the 
 *    target number if found
 *    If not found, (-1, -1) is returned
 *
 *Algorithm: 
 *    1. Start with the top right corner
 *    2. Compare element with target
 *        a. if element == target, return coordinate
 *        b. if element < target, increase row by 1
 *        c  if element > target, decrease column by 1
 *    3. Repeat step 2 until coordinates are returned or element is out of bound
 *       in which case we return (-1, -1)
 */
 
 public class MatrixFinder{

    public static String search(int[][] matrix, int target) {
        int row = 0, column = matrix.length - 1;
        while (row < matrix.length && column > -1) {
            if (matrix[row][column] == target) 
                return "(" + row + "," + column + ")"; //returns coordinates of target when found
            else if (matrix[row][column] < target) 
                row++; //check a greater number (move down the column)
            else column--; //check a lesser number (move left in the same row)
        }
        return "(-1,-1)"; //returns (-1,-1) if target doesn't exist in the matrix
    }

    public static void main(String[] args) {
		int[][] pigeon = {{1,3,5},{2,6,9},{7,10,13}};

        String s = "Displaying matrix:\n";
        for (int r = 0; r < pigeon.length; r++) {
            s += "|  ";
            for (int c = 0; c < pigeon.length; c++) {
                s += pigeon[r][c] + "  ";
            }
            s += "|\n";
        }
        System.out.println(s);
        
		System.out.println("Position of 6:  " + search(pigeon,6)); //(1,1)
		System.out.println("Position of 5:  " + search(pigeon,5)); //(0,2)
		System.out.println("Position of 7:  " + search(pigeon,7)); //(2,0)
		System.out.println("Position of 14 (not in matrix):  " + search(pigeon,14)); //(-1,-1)
    }

}//end of MatrixFinder