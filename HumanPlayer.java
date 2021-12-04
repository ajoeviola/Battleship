package application;
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
	public void autoboardplace(Board theboard) {
		for (int i=0;i<4;i++) {
			theboard.getTiles()[i][0]=1;
			theboard.getTiles()[i][1]=1;
		}
		for (int i=0;i<5;i++) {
			theboard.getTiles()[i][3]=1;
		}
		for (int i=2;i<4;i++) {
			theboard.getTiles()[i][5]=1;
		}
		for (int i=0;i<5;i++) {
			theboard.getTiles()[5][i]=1;
		}
		for (int i=1;i<3;i++) {
			theboard.getTiles()[6][i]=1;
		}
	}
}
