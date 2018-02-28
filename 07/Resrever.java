//Team Spooks -- Wenting Li, Hasif Ahmed
//APCS2 pd01
//HW07 -- A Man, A Plan, A Canal: Panama!
//2018-02-14 W

/*======================================
  class Resrever
  Given a String, reverse the String...
    e.g., "stressed"  ->  "desserts"

  ...in a) O(n) time
        b) O(log2n) time (recursive?)
  ======================================*/

public class Resrever {

    //O(n) time, linear runtime
    //traverses through the String from right to left, reversing each element in the String.
    public static String reverse(String str) {
        String retStr = ""; //final string
        for (int i = str.length(); i > 0; i--) { //for loop starting from the end of the string
            retStr += str.substring(i-1,i);
        }
        return retStr;
    }


    //O(log2n) time
    /* After talking it over, we reached the general consensus that a runtime of O(logn) is impossible. In an attempt
    to utilize O(logn) time, we designed a code where the given string was split in half recursively until the method
    focused on individual characters. Next, the same logic used in MergeSort, was employed here. So, the method built
    back up the string but in reverse order. We combined the group of single-element Strings in reverse to form the
    given String reversed. However,because the combining process requires a pass for each element in the String, it
    unavoidably had a runtime of O(n). Therefore, the runtime is O(nlogn), not O(logn).
    */ 
    public static String reverseR(String x) {
        int size = ( x.length() - 1 ) / 2; //variable to hold the midpoint
        String left = x.substring(0,size); //left half of string
        String right = x.substring(size,x.length()); //right half of string

        if( x.length() == 1){ //base case, when the string only has one character left
            return x.substring(0,1); //return it
        }
        if( x.length() == 2){ //when the string only has two characters left
            left = x.substring(0,1); //override the values for left and right so no errors are made
            right = x.substring(1,2);
        }
        //this is needed because when splitting the string, one can end up with a 2 length and a 1 length, and to counter for the
        //2 length this code is essential (n is odd)
        if(right.length() == 1 && left.length() == 1){ //if there is only one character in left and right
            return right + left; //return the characters in reverse order
        }
        return reverseR(right) + reverseR(left); //recursive: return right plus left because strings being reversed
    }

    public static void main(String[] args){
        String test1 = "hallo";
        System.out.println(reverse(test1));
        //System.out.println(test1.substring(0,(test1.length() - 1) / 2));
        //System.out.println(test1.substring((test1.length() - 1) / 2,test1.length()));
        System.out.println(reverseR(test1));
    }

}//end of class