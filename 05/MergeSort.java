//Wenting Li
//APCS2 pd01
//HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!. . .
//2018-02-07 W

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  1) merge() merges two sorted halves into a single sorted list by comparing the first element in each half, 
     appending the lesser value to a newly created empty array, and comparing the next element in the half of
     the lesser value and the first element of the other half. This comparing and appending continues until one
     half has no more element left to compare (ie. reached the end of the list),
        a. When this comparing and appending stops, we simply append the rest of the elements in the remaining
           half to the array. NOTE: We can automatically assume that the array will remain sorted.
        b. The newly created empty array has the size of the two halves combined and is returned at the end
           of this operation.
  2) sort() is a recursive that continues split a given array in roughly half and merges the sorted list of each 
     half to return a single sorted list.
        a. sort() sorts each half of its list by calling itself for each half.
        b. The splitting continues until sort() receives a single-element, which is guaranteed to be sorted, 
           which it simply spits back out to be merged.
  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   *  output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    int[] temp = new int[a.length + b.length]; //empty array with the size of lists a and b combined
    int x = 0, y = 0, z = 0; //respectively, the counters for a, b, and the empty array

    while(x < a.length && y < b.length) { //ensures that the comparisons stop when we reach the end of one half
      if (a[x] < b[y]) {
        temp[z] = a[x];
        x++; //x will now mark the next element in list a
      }
      else {
        temp[z] = b[y];
        y++; //y will now mark the next element in list b
      }
      z++; 
    }

    //appending the rest of the elements in the remaining half to the array
    while (x < a.length) { 
      temp[z] = a[x];
      x++;
      z++;
    }
    while (y < b.length) {
      temp[z] = b[y];
      y++;
      z++;
    }

    return temp;
  }//end merge()

  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
    if (arr.length > 1) {
      int index = arr.length / 2;
      int[] a = new int[index], b = new int[arr.length - index];

      for (int i = 0; i < arr.length; i++) { //splits the given array into roughly two
        if (i < index) 
          a[i] = arr[i];
        else
          b[i - index] = arr[i];
      }

      return merge(sort(a), sort(b)); //merges the sorted halves and returns one sorted list
    }
    else
      return arr; //for base case, when the given array consists of only one element
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }

  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {

      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );
    
      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) ); //returns {0,1}
    
      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) ); //returns {0,1,2,3,4,9,42,17,63,0,512,23}
      //NOTE: NOT merge() returns unsorted array precond requires all input arrays to be already sorted
    
      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) ); //returns {1,2,3,4}
      printArray( sort( arr5 ) ); //returns {1,2,3,4}
      printArray( sort( arr6 ) ); //returns {0,9,17,23,42,63,512}
      printArray( sort( arr7 ) ); //returns {0,9,9,9,17,23,42,63,512}
    /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
