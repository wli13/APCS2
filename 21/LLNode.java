/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    private String cargo;
    public LLNode next; //the CDR in the CONS CELL leading to the next node

    // constructor 
    public LLNode(String x){
        cargo = x;
        next = null;
    }

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
        return cargo;
    }

    public LLNode getNext()
    {
        return next;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo(String x)
    {
        String temp = cargo;
        cargo = x;
        return temp;
    }

    public LLNode setNext(LLNode x)
    {
        LLNode temp = next;
        next = x;
        return next;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
        if (next != null)
            return cargo + " " + next;
        else 
            return cargo; //if statement such that null nodes aren't printed
    }


    //main method for testing
    public static void main( String[] args )
    {
	//PROTIP: try creating a few nodes: traversible, connected...
    //note anything notable as you develop and test...
    
        //NOTE: Through linking llist.head with the other two nodes, printing
        //      out llist.head would also print out the cargos of the other
        //      two nodes!
        LList llist = new LList();

        llist.head = new LLNode("I");
        LLNode second = new LLNode("hate");
        LLNode third = new LLNode("pigeons");

        llist.head.next = second; //links first node with the second node
        second.next = third; //links first node with the second node

        System.out.println("llist: " + llist.head); //returns LList '(I hate pigeons)

        System.out.println(llist.head.getCargo()); //returns I
        System.out.println(llist.head.getNext()); //returns '(hate pigeons)
        System.out.println(second.getCargo()); //returns hate
        System.out.println(second.getNext()); //returns '(pigeons)
        System.out.println(third.getCargo()); //returns pigeons
        System.out.println(third.getNext()); //returns '() null list

        LLNode edit = new LLNode("pigeon");
        second.setCargo("love"); //sets second element to "love"
        second.setNext(edit); //sets the cdr of second node/cargo of third node to "pigeon"
        System.out.println("llist(after the edit): " + llist.head); //returns LList '(I love pigeon)
        
    }//end main

}//end class LLNode
