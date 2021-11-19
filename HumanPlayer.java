import java.util.*;
public class HumanPlayer extends Player {
	private ArrayList<Ship> shiplist = new ArrayList<Ship>();
	
	public void attack(Board theboard) {}
	public void placeship(Board theboard) {}
	public ArrayList<Ship> getShiplist() {
		return shiplist;
	}
	public void setShiplist(ArrayList<Ship> shiplist) {
		this.shiplist = shiplist;
	}
	
}
