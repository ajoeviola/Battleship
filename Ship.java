package application;
public class Ship {
	
	/**
	 *  variables:
	 *  length: int (holds the length (vertical) of the ship)
	 *  width: int (holds the width (horizontal) of the ship)
	 *  orientation: String (horizontal or vertical)
	 *  sunk: boolean (contains whether or not the ship has sunk)
	 *  name: String (Name of the type of ship)
	 */
	int length;
	int width;
	String orientation;
	boolean sunk;
	String name;
	
	Ship(int l, int w, String ori, String n){
		length = l;
		width = w;
		orientation = ori;
		name = n;
		sunk = false;
	}
	
	/**
	 * sink is called once the ship is sunk, it changes the 'sunk' variable to true, and displays a message/visual
	 */
	public void sink() {
		sunk = true;
	}

	
	/**
	 * Create getters and setters for class ship
	 * @return
	 */
	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public String getOrientation() {
		return orientation;
	}


	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}


	public boolean isSunk() {
		return sunk;
	}


	public void setSunk(boolean sunk) {
		this.sunk = sunk;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
