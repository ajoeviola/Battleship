package application;
import java.util.*;
public class CompPlayerEasy extends Player {
	private ArrayList<Ship> shiplist = new ArrayList<Ship>();
	public Board theboard; 
	public CompPlayerEasy(){
		setShiplist();
	}
	public ArrayList<Ship> getShiplist() {
		return shiplist;
	}
	public void setShiplist() {
		Ship Hangar1 = new Ship(4,2,"Horizontal","Hangar");
		Ship Submarine1 = new Ship(5,1,"Vertical","Submarine");
		Ship Sailboat1 = new Ship(2,1,"Horizontal","Sailboat");
		Ship Submarine2 = new Ship(5,1,"Horizontal","Submarine");
		Ship Sailboat2 = new Ship(2,1,"Vertical","Sailboat");
		shiplist.add(Hangar1);
		shiplist.add(Submarine1);
		shiplist.add(Submarine2);
		shiplist.add(Sailboat1);
		shiplist.add(Sailboat2);
	}
	
	public void takeboard(Board insert) {
		theboard = insert;
	}
	public void attack(Board theboard,int sp1, int sp2) {
		if (theboard.occupado(sp1, sp2)==true) {
			theboard.getTiles()[sp1][sp2]=2;
		}
		else if (theboard.occupado(sp1,sp2)==false) {
			theboard.getTiles()[sp1][sp2]=3;
		}
	}
	public void placeship(Board theboard,Ship shiplace) {
		Random rand = new Random();
		//select random point on the board, x y coord
		int x = rand.nextInt(8);
		int y = rand.nextInt(8);
		
		//If ship is vertical, check vertically for space for ship
		if (shiplace.getOrientation()=="Vertical")
		{
			int shiplength = shiplace.getLength();
			int counter =0;
			while (shiplength>0) {
				if (theboard.occupado(x, y)==false) {
					theboard.getTiles()[x][y-counter]=1;
				}
				shiplength--;
				counter++;
			}
		}
	}
	public void autoboardplace() {
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
	
	public void boardplace() {
		Random rand = new Random();
		boolean isplaced = false;
		
		for (int i = 0; i < 16; i++) {
			
			int x = rand.nextInt(10);
			int y = rand.nextInt(10);
			
			if (theboard.getTiles()[x][y] != 1) {
				theboard.getTiles()[x][y] = 1;
			}else {
				i--;
			}
			
			isplaced = false;
			
	}
	}
}