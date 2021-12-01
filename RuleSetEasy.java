
public class RuleSetEasy implements Rules {
	private int amtHangars;
	private int amtSubmarines;
	private int amtSailboats;
	private Board gameboard;
	Player computer;
	
	public RuleSetEasy() {
		gameboard=setBoardSize();
		computer = new CompPlayerEasy();
	}
	
	
	@Override
	public void setCPUdifficulty(Player comptype) {
		// TODO Auto-generated method stub
		computer = comptype;
	}

	@Override
	public Board setBoardSize() {
		// TODO Auto-generated method stub
		Board myboard = new Board(8);
		return myboard;
	}

	@Override
	public void setamtTypeShips(int hangar, int sub, int sail) {
		setAmtHangars(hangar);
		setAmtSubmarines(sub);
		setAmtSailboats(sail);
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

	@Override
	public void initShipTypeamts() {
		// TODO Auto-generated method stub
		amtHangars=1;
		amtSubmarines=2;
		amtSailboats=2;
	}


}
