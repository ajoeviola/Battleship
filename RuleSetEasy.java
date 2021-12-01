
public class RuleSetEasy implements Rules {
	private int amtHangars;
	private int amtSubmarines;
	private int amtSailboats;
	private Board gameboard;
	
	public RuleSetEasy() {
		gameboard=setBoardSize();
	}
	
	
	@Override
	public void setCPUdifficulty() {
		// TODO Auto-generated method stub
		CompPlayerHard = new CompPlayerHard
	}

	@Override
	public Board setBoardSize() {
		// TODO Auto-generated method stub
		Board myboard = new Board(8);
		return myboard;
	}

	@Override
	public void setamtTypeShips() {
		
	}

	public int getAmtHangars() {
		return amtHangars;
	}

	public void setAmtHangars(int amtHangars) {
		this.amtHangars = amtHangars;
	}

	public int getAmtSubmarines() {
		return amtSubmarines;
	}

	public void setAmtSubmarines(int amtSubmarines) {
		this.amtSubmarines = amtSubmarines;
	}

	public int getAmtSailboats() {
		return amtSailboats;
	}

	public void setAmtSailboats(int amtSailboats) {
		this.amtSailboats = amtSailboats;
	}

}
