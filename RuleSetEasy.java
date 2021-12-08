package application;

public class RuleSetEasy implements Rules {
	private int BOARD_SIZE=10;
	private int SHIP_AMOUNT=16;
	
	/**
	 * Default empty constructor to create basic object of RuleSetEasy
	 * 
	 */
	public RuleSetEasy() {};
	
	/**
	 * This method changes the size of the board to be used in the game
	 * 
	 * 
	 * @param bOARD_SIZE - the parameter that controls the size of the board
	 */
	@Override
	public void setBoardSize(int bOARD_SIZE) {
		BOARD_SIZE = bOARD_SIZE;

	}
	
	/**
	 * This method will return the size of the Board to be used in gameplay
	 * 
	 * @return BOARD_SIZE - to return size of the board
	 */
	public int getBOARD_SIZE() {
		return BOARD_SIZE;
	}
	
	/**
	 * This method will return the amount of ships to be used in gameplay
	 * 
	 * @return SHIP_AMOUNT - to return amount of ships for board use
	 */
	public int getSHIP_AMOUNT() {
		return SHIP_AMOUNT;
	}

	
	/**
	 * This method allows for the amount of ships to be used in gameplay to be changed.
	 * 
	 * @param sHIP_AMOUNT - To set amount of ships that will be used in game
	 */
	public void setSHIP_AMOUNT(int sHIP_AMOUNT) {
		SHIP_AMOUNT = sHIP_AMOUNT;
	}
	
	
}
