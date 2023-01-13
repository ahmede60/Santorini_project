package giu.santorini.tiles;
import giu.santorini.utilities.Location;
public class Cube extends Piece{
	public Cube(Location Location){
		super(Location);
	}
	public ArrayList<Location> possibleMoves(){
		ArrayList<Location>m=new ArrayList<Location>();
		if(this.Location.y+1<6)
			m.add(new Location(this.Location.y+1,this.Location.x));
		if(this.Location.x+1<6)
			m.add(new Location(this.Location.y,this.Location.x+1));
		if(this.Location.y-1>0)
			m.add(new Location(this.Location.y-1,this.Location.x));
		if(this.Location.x-1>0)
			m.add(new Location(this.Location.y,this.Location.x-1));


return m;
}
}
