package giu.santorini.tiles;

import giu.santorini.utilities.Location;

import java.util.ArrayList;

public class Piece implements PieceInterface{
	Location Location;
	public Piece(Location Location){
		this.Location = Location;
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
