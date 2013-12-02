/*==================================================
  class SuperArray
  Wrapper class for array. Facilitates resizing, 
  getting and setting element values.
  ==================================================*/

public class SuperArray {

    private int[] _data;
    private int _lastPos;
    private int _size;


    //default constructor
    //initializes 10-item array
    public SuperArray() { 
	// *** YOUR IMPLEMENTATION HERE *** 
    }


    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() { 
	// *** YOUR IMPLEMENTATION HERE *** 
	return "foo"; //placeholder
    }


    //double capacity of this instance of SuperArray 
    private void expand() { 
	// *** YOUR IMPLEMENTATION HERE *** 
    }


    //accessor method -- return value at specified index
    public int get( int index ) {
	// *** YOUR IMPLEMENTATION HERE *** 
	return _data[index];
    }


    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) {
	// *** YOUR IMPLEMENTATION HERE *** 
	return -1; 
    }

    //main method for testing
    public static void main( String[] args ) {

	/*===========================================
	SuperArray curtis = new SuperArray();
	System.out.println( "Printing empty SuperArray curtis..." );
	System.out.println( curtis );

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set( i, i * 2 );
	    curtis._size++;
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);
	===========================================*/

    }

}//end class SuperArray