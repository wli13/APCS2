//Wenting Li
//APCS2 pd01
//HW21 -- Rockin’ Through the Night
//2018-03-20

/*****************************************************
 * class LList - linear data structure where elements are linked using pointers
 * Implements List interface
 * Stores its data as a String
 *****************************************************/


public class LList implements List {

    //instance vars
    public LLNode head; //marks the first node of the list


    //add node to list, containing input String as its data
    //NOTE: added node to front of list, as in cons
    public boolean add(String x){
        LLNode temp = head;
        head = new LLNode(x); //set new node containing String x as "head" node
        head.next = temp; //link new "head" node with the rest of the list
        return true;
    }

    //precondition: position i is less than length of list
    //return data in element at position i
    public String get(int i){
        LLNode pigeon = head;
        for(; i > 0; i--){
            pigeon = pigeon.next; //traverse through nodes until you reach position i (ie. i becomes 0)
        }
        return pigeon.getCargo();
    }

    //overwrite data in element at position i
    public String set(int i, String x){
        LLNode pigeon = head;
        for(; i > 0; i--) {
            pigeon = pigeon.next; //traverse through nodes until you reach position i (ie. i becomes 0)
        }
        return pigeon.setCargo(x);

    }

    //return length of list, not including the null node
    public int size(){
        int i = 0;
        LLNode pigeon = head;
        while(pigeon != null) {
            pigeon = pigeon.next;
            i++; //i serves as counter for number of elements in the list
        }
        return i; 
    } 

    //main method for testing
    public static void main(String[] args) {

        //classwork LList ‘(moony wormtail padfoot prongs)
        LList llist = new LList();

        llist.head = new LLNode("prongs"); //sets first node to hold "prongs"
        llist.add("padfoot"); //adds new node holding "padfoot" at beginning
        llist.add("wormtail"); // ''(reference above)
        llist.add("moon"); // ''(reference above)
        System.out.println("llist: " + llist.head); //returns LList ‘(moon wormtail padfoot prongs)

        llist.set(0, "moony");
        System.out.println("llist(after the edit): " + llist.head); //returns LList ‘(moony wormtail padfoot prongs)

        System.out.println(llist.get(3)); //returns "prongs"
        System.out.println(llist.size()); //returns 4

    }//end main

}