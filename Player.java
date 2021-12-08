package application;
public abstract class Player {
	
	/**
	 * 
	 * @param theboard: Passes in the board
	 * attack() prompts player for which tile they want to attack, and then attacks that tile.
	 */
	public void attack(Board theboard) {}
	
	/**
	 * 
	 * @param theboard: Passes in the board
	 * places the ship at the desired location on the board
	 */
	public void placeship(Board theboard) {}
}