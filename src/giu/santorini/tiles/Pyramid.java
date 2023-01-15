package giu.santorini.tiles;
import java.util.ArrayList;

import giu.santorini.utilities.Location;
public class Pyramid extends Piece{
	public Pyramid(Location Location){
		super(Location);
	}
	public ArrayList<Location> possibleMoves(){
		ArrayList<Location> m = new ArrayList<Location>();
		if((this.Location.y+1>-1 & this.Location.y+1<5)&
		(this.Location.x-1>-1 & this.Location.x-1<5))
			m.add(new Location(this.Location.y+1,this.Location.x-1));
		if((this.Location.y-1>-1 & this.Location.y-1<5)&
				(this.Location.x-1>-1 & this.Location.x-1<5))
			m.add(new Location(this.Location.y-1,this.Location.x+1));
		if((this.Location.y-1>-1 & this.Location.y-1<5)&
				(this.Location.x-1>-1 & this.Location.x-1<5))
			m.add(new Location(this.Location.y-1,this.Location.x-1));
		if((this.Location.y+1>-1 & this.Location.y+1<5)&
				(this.Location.x-1>-1 & this.Location.x-1<5))
			m.add(new Location(this.Location.y+1,this.Location.x+1));
return m;	
	}
	
}
