// BENEDICT BOLTON
// HW#37
// PD08
// 2013-12-3

/*==================================================
  class SuperArray version 2.0
  Wrapper class for array. Facilitates 
  resizing 
  expansion 
  read/write capability on elements
  adding an element to end of array
  adding an element at specified index
  removing an element at specified index
  ==================================================*/

public class SuperArray {

    private int[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() { 
	_data = new int[10];
	_lastPos = -1;
	_size = 0;	
    }

    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() {
 
	String fin = "[ ";

	for (int i = 0; i <= _lastPos; i++) {
	    fin += _data[i] + ", ";
	}
	if (fin.length() > 2)  
	    //shaves off trailing comma
	    fin = fin.substring(0,fin.length()-2)  + " ]";
	else
	    fin += " ]"; //empty [] if _lastPos == -1
	return fin;

    }

    /*  public String toString() { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ", ";
	}
	if ( foo.length() > 1 )
	    //shave off trailing comma
	    foo = foo.substring( 0, foo.length()-1 );
	foo += " ]";
	return foo;
    }
    */

    //double capacity of this instance of SuperArray 
    private void expand() { 
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

    //accessor method -- return value at specified index
    public int get( int index ) {
	return _data[index];
    }

    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) {
	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    //adds an item after the last item
    public void add( int newVal ) { 
	if (_lastPos >= (_data.length - 1) ) {
	    expand(); //expands if movement will push out of array's bounds
	}
	set ( (_lastPos + 1), newVal);
	_lastPos++;
	_size++;
    }


    //inserts an item at index
    //shifts elements left to accomodate in newly-empted slot    
    public void add( int index, int newVal ) { 
	if ( index > _lastPos ) { //must be left justified, so one cannot add beyond the end without adding inbetween first
	    add( newVal ); //exemption for if something is being added at or beyond the end
	}
	else {
	    if (_lastPos >= (_data.length - 1) ) {
		expand();
	    }	    
	    for (int i = _lastPos; i >= index; i--) {
		_data[i + 1] = _data[i];
	    }
	    set ( index, newVal );
	    _lastPos++;
	    _size++;
	}
    }
       


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) { 	    
	for (int i = index; i <  _lastPos; i++) {
	    _data[i] = _data[i + 1];
	}
	_data[_lastPos] = 0;
	_lastPos--;
	_size--;
    }
    


    //return number of meaningful items in _data
    public int size() {
	//*** YOUR SIZE HNYAH ***
	return _size; 
    }


    public static void main( String[] args ) {

	SuperArray curtis = new SuperArray();
	System.out.println( "Printing empty SuperArray curtis..." );
	System.out.println( curtis );

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.add( i, i * 2 );
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < 3; i++ ) {
	    curtis.expand();
	    System.out.println("Printing expanded SuperArray curtis...");
	    System.out.println(curtis);
	    System.out.println("new length of underlying array: " 
			       + curtis._data.length );
	}


	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);

	/*===========================================
	===========================================*/
    }//end main()

}//end class SuperArray
