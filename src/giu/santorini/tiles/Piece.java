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
		return null;
	}
}
