//Wenting Li
//APCS2 pd01
//HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2018-02-28

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
  private int[][] _board;
    
  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }

  
  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
  public boolean solve()
  {
    int sz = _board.length;
    int row = 0;
    int col = 0;
    int QCount = 0;
    while (row < sz && col < sz){
      if (QCount == sz){
        return true;
      }
      else if (solveH(col)){
        col++;
        row = 0;
        QCount += 1;
        //		printSolution();
        //		System.out.println(toString());
      }
	    else {
		    col--;
		    row = 0;
		    while (_board[row][col] != 1){
		        row++;
		    }
      return false;
      }
      //STILL DEVELOPING
    }
  }

  
  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) 
  {
    for (int x = 0; x < _board.length; x++){
	    if (_board[x][col] == 0){
		    return addQueen(x,col);
	    }
	  }
	  return false;
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */

    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        if (_board[r][c] <= 0){
          ans += "_";
        }
        if (_board[r][c] == 1){
          ans += "Q";
        }
        ans += "\t";
      }
      ans += "\n";
    }
    System.out.println(ans);
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * places a Queen in the specified slot if slot holds a 0, an empty slot,
   * and marks its range
   * (ie. the slot isn't empty and isn't in the range of another Queen)
   * precondition: 
   *  - given a board of n by n of any values
   * postcondition: 
   *  - places a Queen in the specified slot, returns true
   *  - offsets the rest of the current row, column, and diagonal by -1 to 
   *    mark the range of the new Queen.
   *  - if the specified slot doesn't hold 0, don't place anything and 
   *    return false
   */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
	    return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
        _board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * removes a Queen in the specified slot if slot holds a 1, an occupied
   * slot, and unmarks its range
   * precondition:
   *  - given a board of n by n of any values
   * postcondition: 
   *  - if slot holds a 1, remove the Queen and unmark all of the offsets
   *    (ie. marked range) return true
   *  - if slot doesn't hold a 1, return false
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
	    return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * Prints the layout of the board of a QueenBoard object
   * precondition: Given a board of n by n by any value
   * postcondition: Prints the layout of the given board
   */
  public String toString() 
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
    b.addQueen(0,2); //if a tile selected contains a negative number, queen not placed
    System.out.println(b);
    b.addQueen(1,0); //preference on columns to the left, if I add a queen to the left of existing queens, board focuses on modifying board to accomodate queen on the left. However, its markings on diagonals and rows do not disappear(does this cause a problem?)
    System.out.println(b);    
    b.addQueen(1,2); //unless removeQueen is used, markings on diagonals and rows will stay and cause probelms
    System.out.println(b);
  }
    
}//end class
