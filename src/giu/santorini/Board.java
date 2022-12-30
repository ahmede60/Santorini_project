package giu.santorini;

import giu.santorini.exceptions.InvalidMoveException;
import giu.santorini.exceptions.InvalidPlacementException;
import giu.santorini.players.Player;
import giu.santorini.tiles.Piece;
import giu.santorini.utilities.Location;

public class Board implements BoardInterface {
	Player Player1;
	Player Player2;
	public Board(Player Player1,Player Player2){
		this.Player1 = Player1;
		this.Player2 = Player2;
	}
	public Board(){
	}
	int SIDE = 5;
	public void move(Piece Piece, Location newLocation) throws InvalidMoveException{
	}
	public void place(Piece Piece, Location newLocation) throws InvalidPlacementException{
	}
	public boolean isGameOver(){
		return false;
	}
	public boolean isWinner(Player player){
		return false;
	}
	public boolean hasNoMoves(Player player){
		return false;
	}
	public Player getWinner(){
		return new Player();
	}
	public boolean canMove(Piece Piece, Location location){
		return false;
	}
	public boolean canPlace(Piece Piece, Location location){
		return false;
	}
	public Player getTurn(){
		return new Player();
	}
	public String [][] display(){
		return new String [0][0];
	}
}
