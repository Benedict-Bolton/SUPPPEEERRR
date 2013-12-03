// BENEDICT BOLTON
// HW#36
// PD08
// 2013-12-2


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
	_data = new int[10];
	_lastPos = -1; //as there are no significant thinsg in the array this is -1
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
	    fin = fin.substring(0,fin.length()-2)  + " ]";
	else
	    fin += " ]"; //empty [] if _lastPos == -1
	return fin;

    }


    //double capacity of this instance of SuperArray 
    private void expand() { 
	int[] bar = new int[ (_data.length * 2) ];
	for (int k = 0; k < _data.length; k++) {
	    bar[k] = _data[k];
	}
	_data = bar; //copies the local to the instance
    }


    //accessor method -- return value at specified index
    public int get( int index ) {
	return _data[index];
    }


    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) {
	int oldVal = _data[index];
	if (index > _lastPos) {
	    _lastPos = index; //updates last pos as you set things beyond furthest set index (size is done in main)
	}
	_data[index] = newVal;
	return oldVal; 
    }

    //main method for testing
    public static void main( String[] args ) {


	SuperArray curtis = new SuperArray();
	System.out.println( "Printing empty SuperArray curtis..." );
	System.out.println( curtis );

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set( i, i * 2 );
	    curtis._size++;
	}


	System.out.println("Printing populated SuperArray curtis variables...");
	System.out.println(curtis._size);
	System.out.println(curtis._lastPos);


	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	/*===========================================
	===========================================*/

    }

}//end class SuperArray
