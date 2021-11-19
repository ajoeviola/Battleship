import java.util.*;
public class CompPlayerEasy extends Player {
	private ArrayList<Ship> shiplist = new ArrayList<Ship>();
	
	public ArrayList<Ship> getShiplist() {
		return shiplist;
	}
	public void setShiplist(ArrayList<Ship> shiplist) {
		this.shiplist = shiplist;
	}
	public void attack(Board theboard) {}
	public void placeship(Board theboard) {}
}
