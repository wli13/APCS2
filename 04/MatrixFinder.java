//Team Cheesy Potatoes -- Wenting Li, Alexia Leong, Bing Li
//APCS2 pd01
//HW04
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
 * 
 * ===================================================
 * Phase II:
 * Runtime Experimentations
 * 
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

    //=============================================================================
    //Phase II: Runtime Experimentation

    public static double avgRuntime(int[][] matrix, int target, int totalTrials) {
        int trial = 1;
        double avg = 0.0;
        while (trial <= totalTrials) {
            long startTime = System.nanoTime();
            search(matrix, target); //code being tested 
            long estimatedTime = System.nanoTime() - startTime;
            //System.out.println("Run time for trial " + trial + " is " + estimatedTime + " nanoseconds.");
            trial++;
            avg += estimatedTime;
        }
        return avg / totalTrials;  
    }


    public static void main(String[] args) {
        int[][] pigeon = {{1,3,5},{2,6,9},{7,10,13}};

/*        String s = "Displaying matrix:\n";
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
*/

        //=============================================================================
        //Phase II: Runtime Experimentation

        System.out.println("\n\nPosition of 5 in x:");
        System.out.println("The average time to look for 5 (the best case so it should take the shortest) in x is "
                + avgRuntime(pigeon, 5, 10000) + " nanoseconds.");

        System.out.println("\n\nNew Target:\nPosition of 1 in x:");
        System.out.println("The average time to look for 1 in x is " 
                + avgRuntime(pigeon, 1,10000) + " nanoseconds.");

        System.out.println("\n\nNew Target:\nPosition of 7 in x:");
        System.out.println("The average time to look for 7 (the worst case so it should take the longest) in x is "
                + avgRuntime(pigeon, 7,10000) + " nanoseconds.");

    }

}//end of MatrixFinder