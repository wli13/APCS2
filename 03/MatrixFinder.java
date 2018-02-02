public class MatrixFinder{

    public static String search(int[][] matrix, int target) {
        int row = 0, column = matrix.length - 1;
        while (row < matrix.length && column > -1) {
            if (matrix[row][column] == target) 
                return "(" + row + "," + column + ")";
            else if (matrix[row][column] < target) 
                row++;
            else column--;
        }
        return "(-1,-1)";
    }

    public static String display(int[][] matrix) {
        String s = "";
        for (int r = 0; r < matrix.length; r++) {
            s += "|  ";
            for (int c = 0; c < matrix.length; c++) {
                s += matrix[r][c] + "  ";
            }
            s += "|\n";
        }
        return s;
    }

    public static void main(String[] args) {
        int[][] pigeon = new int[3][3];
        int count = 1;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                pigeon[r][c] = count;
                count += 2;
            }
        }
        System.out.println(display(pigeon));
        System.out.println("\nSearching pigeon for 5: " + search(pigeon, 5) );
        System.out.println("Searching pigeon for 9: " + search(pigeon, 9) );
        System.out.println("Searching pigeon for 13: " + search(pigeon, 13) );
        System.out.println("Searching pigeon for 8: " + search(pigeon, 8) );
        
        
    }

}//end of MatrixFinder