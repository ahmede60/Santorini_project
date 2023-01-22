package giu.santorini.tiles;

import giu.santorini.utilities.Location;
import java.util.ArrayList;

public class Piece implements PieceInterface{
	public Location Location;
	public boolean moved;
	public Piece(Location Location){
		this.Location = Location;
		this.moved = false;
	}
public Piece(){
	}
	public ArrayList<Location> possibleMoves(){
		return null;
	}
	public ArrayList<Location> possiblePlacements(){
		ArrayList<Location>m=new ArrayList<Location>();
		if((this.Location.y-1>-1)&(this.Location.x-1>-1))
			m.add(new Location(this.Location.y-1,this.Location.x-1));
		if(this.Location.y-1>-1)
			m.add(new Location(this.Location.y-1,this.Location.x));
		if((this.Location.y-1>-1)&(this.Location.x+1<5))
			m.add(new Location(this.Location.y-1,this.Location.x+1));
		if(this.Location.x-1>-1)
			m.add(new Location(this.Location.y,this.Location.x-1));
		if(this.Location.x+1<5)
			m.add(new Location(this.Location.y,this.Location.x+1));
		if((this.Location.y+1<5)&(this.Location.x-1>-1))
			m.add(new Location(this.Location.y+1,this.Location.x-1));
		if(this.Location.y+1<5)
			m.add(new Location(this.Location.y+1,this.Location.x));
		if((this.Location.y+1<5)&(this.Location.x+1<5))
			m.add(new Location(this.Location.y+1,this.Location.x+1));
		return m;
	}
}
