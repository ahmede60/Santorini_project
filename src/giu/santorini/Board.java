package giu.santorini;

import giu.santorini.exceptions.InvalidMoveException;
import giu.santorini.exceptions.InvalidPlacementException;
import giu.santorini.players.Player;
import giu.santorini.tiles.Cube;
import giu.santorini.tiles.Piece;
import giu.santorini.tiles.Pyramid;
import giu.santorini.utilities.Location;

public class Board implements BoardInterface {
	Player Player1;
	Player Player2;
	int[][] Level;
	Piece Piece1a;
	Piece Piece1b;
	Piece Piece2a;
	Piece Piece2b;
	int turn;
	public Board(Player Player1,Player Player2){
		this.Player1 = Player1;
		this.Player2 = Player2;
		this.Level = new int[SIDE][SIDE];
		for(int i=0;i<SIDE;i++){
			for(int j=0;j<SIDE;j++){
				Level[i][j]=0;
			}
		}
		if (Player1.type == 1){
			Piece1a = new Cube(new Location(0,0));
			Piece1b = new Cube(new Location(4,1));
		}
		else{
			Piece1a = new Pyramid(new Location(0,0));
			Piece1b = new Pyramid(new Location(4,1));
		}
		if (Player2.type == 1){
			Piece2a = new Cube(new Location(0,0));
			Piece2b = new Cube(new Location(4,1));
		}
		else{
			Piece2a = new Pyramid(new Location(0,0));
			Piece2b = new Pyramid(new Location(4,1));
		}
		turn = 0;
	}
	public Board(){
	}
	int SIDE = 5;
	public void move(Piece Piece, Location newLocation) throws InvalidMoveException{
		Piece.Location = newLocation;
		// didnt deal with the exception yet// check turn use canmove method
	}
	public void place(Piece Piece, Location newLocation) throws InvalidPlacementException{
		Level[newLocation.x][newLocation.y]++;
		turn++;
		// didnt deal with the exception yet//
	}
	public boolean isGameOver(){
		return	hasNoMoves(Player1) |
				hasNoMoves(Player2) |
				Level[Piece1a.Location.y][Piece1a.Location.x]==3 |
				Level[Piece1b.Location.y][Piece1b.Location.x]==3 |
				Level[Piece2a.Location.y][Piece2a.Location.x]==3 |
				Level[Piece2b.Location.y][Piece2b.Location.x]==3 ;
	}
	public boolean isWinner(Player player){
		if (player.name.equals(Player1.name)){
			if (hasNoMoves(Player2) |
				Level[Piece1a.Location.y][Piece1a.Location.x]==3 |
				Level[Piece1b.Location.y][Piece1b.Location.x]==3)
				return true;
		}
		if (player.name.equals(Player2.name)){
			if (hasNoMoves(Player1) |
				Level[Piece2a.Location.y][Piece2a.Location.x]==3 |
				Level[Piece2b.Location.y][Piece2b.Location.x]==3)
				return true;
		}
		return false;
	}
	public boolean hasNoMoves(Player player){
		if (player.name.equals(Player1.name)){
			if (Piece1a.possibleMoves().isEmpty() & Piece1b.possibleMoves().isEmpty())
				return true;
			int possiblemoves = 0;
			for (int i = 0; i < Piece1a.possibleMoves().size();i++){
				if (Level[Piece1a.possibleMoves().get(i).y][Piece1a.possibleMoves().get(i).x]+1 <= Level[Piece1a.Location.y][Piece1a.Location.x])
					possiblemoves+=1;
			}
			for (int i = 0; i < Piece1b.possibleMoves().size();i++){
				if (Level[Piece1b.possibleMoves().get(i).y][Piece1b.possibleMoves().get(i).x]+1 <= Level[Piece1b.Location.y][Piece1b.Location.x])
					possiblemoves+=1;
			}
			if (possiblemoves>0)
				return false;
		}
		if (player.name.equals(Player2.name)){
			if (Piece2a.possibleMoves().isEmpty() & Piece2b.possibleMoves().isEmpty())
				return true;
			int possiblemoves = 0;
			for (int i = 0; i < Piece2a.possibleMoves().size();i++){
				if (Level[Piece2a.possibleMoves().get(i).y][Piece2a.possibleMoves().get(i).x]+1 <= Level[Piece2a.Location.y][Piece2a.Location.x])
					possiblemoves+=1;
			}
			for (int i = 0; i < Piece2b.possibleMoves().size();i++){
				if (Level[Piece2b.possibleMoves().get(i).y][Piece2b.possibleMoves().get(i).x]+1 <= Level[Piece2b.Location.y][Piece2b.Location.x])
					possiblemoves+=1;
			}
			if (possiblemoves>0)
				return false;
		}
		return false;
	}
	public Player getWinner(){
		if (isWinner(Player1))
			return Player1;
		if (isWinner(Player2))
			return Player2;
		return null;
	}
	public boolean canMove(Piece Piece, Location location){
		if (Piece.possibleMoves().isEmpty())
			return false;
		for (int i = 0; i < Piece.possibleMoves().size();i++){
			if ((Piece.possibleMoves().get(i).x == location.x)&
			(Piece.possibleMoves().get(i).y == location.y)&
			Level[Piece.possibleMoves().get(i).y][Piece.possibleMoves().get(i).x] <= (1+ Level[location.y][location.x]))
				return true;
		}
		return false;
	}
	public boolean canPlace(Piece Piece, Location location){
		if (Piece.possiblePlacements().isEmpty())
			return false;
		for (int i = 0; i < Piece.possiblePlacements().size();i++){
			if ((Piece.possiblePlacements().get(i).x == location.x)&
			(Piece.possiblePlacements().get(i).y == location.y)&
			Level[Piece.possibleMoves().get(i).y][Piece.possibleMoves().get(i).x] <= 3)
				return true;
		}
		return false;
	}
	public Player getTurn(){
		if (turn%2==0)
			return Player1;
		return Player2;
	}
	public String [][] display(){
		return new String[0][0];
	}
}
