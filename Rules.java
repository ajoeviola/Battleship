
public interface Rules {
	
	/**
	 * Sets the difficulty of the CPU to either the Easy or Hard CPU
	 */
	public void setCPUdifficulty(Player comptype);
	
	/**
	 * Sets the size of the board
	 */
	public Board setBoardSize();
	
	
	/**
	 * Sets the amount of each type of ship
	 */
	public void setamtTypeShips(int hangar, int sub, int sail);
	
	public void initShipTypeamts();
}
