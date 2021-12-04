package application;
import java.util.*;
public class CompPlayerHard extends Player{
	private ArrayList<Ship> shiplist = new ArrayList<Ship>();
	public CompPlayerHard() {
		setShiplist();
		
	}
	public ArrayList<Ship> getShiplist() {
		return shiplist;
	}
	public void setShiplist() {
		Ship Hangar1 = new Ship(4,2,"Horizontal","Hangar");
		Ship Submarine1 = new Ship(5,2,"Vertical","Submarine");
		Ship Sailboat1 = new Ship(2,1,"Horizontal","Sailboat");
		Ship Submarine2 = new Ship(5,2,"Horizontal","Submarine");
		Ship Sailboat2 = new Ship(2,1,"Verticle","Sailboat");
		shiplist.add(Hangar1);
		shiplist.add(Submarine1);
		shiplist.add(Submarine2);
		shiplist.add(Sailboat1);
		shiplist.add(Sailboat2);
	}
	public void attack(Board theboard,int sp1, int sp2) {
		if (theboard.occupado(sp1, sp2)==true) {
			theboard.getTiles()[sp1][sp1]=2;
		}
		else if (theboard.occupado(sp1,sp2)==false) {
			theboard.getTiles()[sp2][sp2]=3;
		}
	}
	public void placeship(Board theboard) {
		
	}
}
