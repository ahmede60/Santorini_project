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
			Piece2a = new Cube(new Location(0,3));
			Piece2b = new Cube(new Location(4,4));
		}
		else{
			Piece2a = new Pyramid(new Location(0,3));
			Piece2b = new Pyramid(new Location(4,4));
		}
		turn = 0;
	}
	public Board(){
	}
	int SIDE = 5;
	public void move(Piece Piece, Location newLocation) throws InvalidMoveException{
		if((Piece.equals(this.Piece1a))&(!this.Piece1a.moved)&(!this.Piece1b.moved)){
			this.Piece1a.Location = newLocation;
			this.Piece1a.moved = true;
		}
		else{
			throw new InvalidMoveException();
		}
		if((Piece.equals(this.Piece1b))&(!this.Piece1a.moved)&(!this.Piece1b.moved)){
			this.Piece1b.Location = newLocation;
			this.Piece1b.moved = true;
		}
		else{
			throw new InvalidMoveException();
		}
		if((Piece.equals(this.Piece2a))&(!this.Piece2a.moved)&(!this.Piece2b.moved)){
			this.Piece2a.Location = newLocation;
			this.Piece2a.moved = true;
		}
		else{
			throw new InvalidMoveException();
		}
		if((Piece.equals(this.Piece2b))&(!this.Piece2a.moved)&(!this.Piece2b.moved)){
			this.Piece2b.Location = newLocation;
			this.Piece2b.moved = true;
		}
		else{
			throw new InvalidMoveException();
		}
	}
	public void place(Piece Piece, Location newLocation) throws InvalidPlacementException{
		if((this.canMove(Piece, newLocation))&Piece.moved){
			Level[newLocation.y][newLocation.x]++;
		}
		else{
			throw new InvalidPlacementException();
		}
		turn++;
		Piece.moved = false;
	}
	public boolean isGameOver(){
		return	hasNoMoves(this.Player1) |
				hasNoMoves(this.Player2) |
				this.Level[this.Piece1a.Location.y][this.Piece1a.Location.x]==3 |
				this.Level[this.Piece1b.Location.y][this.Piece1b.Location.x]==3 |
				this.Level[this.Piece2a.Location.y][this.Piece2a.Location.x]==3 |
				this.Level[this.Piece2b.Location.y][this.Piece2b.Location.x]==3 ;
	}
	public boolean isWinner(Player player){
		if (player.name.equals(this.Player1.name)){
			if (hasNoMoves(Player2) |
				this.Level[Piece1a.Location.y][Piece1a.Location.x]==3 |
				this.Level[Piece1b.Location.y][Piece1b.Location.x]==3)
				return true;
		}
		if (player.name.equals(Player2.name)){
			if (hasNoMoves(this.Player1) |
				this.Level[Piece2a.Location.y][Piece2a.Location.x]==3 |
				this.Level[Piece2b.Location.y][Piece2b.Location.x]==3)
				return true;
		}
		return false;
	}
	public boolean hasNoMoves(Player player){
		if (player.name.equals(this.Player1.name)){
			int allowedmoves = 0;
			for (int i = 0; i < this.Piece1a.possibleMoves().size();i++){
				if (canMove(this.Piece1a, this.Piece1a.possibleMoves().get(i)))
					allowedmoves+=1;
			}
			for (int i = 0; i < this.Piece1b.possibleMoves().size();i++){
				if (canMove(this.Piece1b, this.Piece1b.possibleMoves().get(i)))
					allowedmoves+=1;
			}
			if (allowedmoves>0)
				return false;
		}
		if (player.name.equals(this.Player2.name)){
			int allowedmoves = 0;
			for (int i = 0; i < this.Piece2a.possibleMoves().size();i++){
				if (canMove(this.Piece2a, this.Piece2a.possibleMoves().get(i)))
					allowedmoves+=1;
			}
			for (int i = 0; i < this.Piece2b.possibleMoves().size();i++){
				if (canMove(this.Piece2b, this.Piece2b.possibleMoves().get(i)))
					allowedmoves+=1;
			}
			if (allowedmoves>0)
				return false;
		}
		return true;
	}
	public Player getWinner(){
		if (isWinner(this.Player1))
			return this.Player1;
		if (isWinner(this.Player2))
			return this.Player2;
		return null;
	}
	public boolean canMove(Piece Piece, Location location){
		for (int i = 0; i < Piece.possibleMoves().size();i++){
			if ((Piece.possibleMoves().get(i).x == location.x)&
			(Piece.possibleMoves().get(i).y == location.y)&
			!((this.Piece1a.Location.y == location.y)&(this.Piece1a.Location.x == location.x))&
			!((this.Piece1b.Location.y == location.y)&(this.Piece1b.Location.x == location.x))&
			!((this.Piece2a.Location.y == location.y)&(this.Piece2a.Location.x == location.x))&
			!((this.Piece2b.Location.y == location.y)&(this.Piece2b.Location.x == location.x))&
			this.Level[Piece.Location.y][Piece.Location.x] <= (1+ this.Level[location.y][location.x]))
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
			!((this.Piece1a.Location.y == location.y)&(this.Piece1a.Location.x == location.x))&
			!((this.Piece1b.Location.y == location.y)&(this.Piece1b.Location.x == location.x))&
			!((this.Piece2a.Location.y == location.y)&(this.Piece2a.Location.x == location.x))&
			!((this.Piece2b.Location.y == location.y)&(this.Piece2b.Location.x == location.x))&
			this.Level[Piece.possibleMoves().get(i).y][Piece.possibleMoves().get(i).x] <= 3)
				return true;
		}
		return false;
	}
	public Player getTurn(){
		if (this.turn%2==0)
			return this.Player1;
		return this.Player2;
	}
	public String [][] display(){
		String[][] display = new String[this.SIDE][this.SIDE];
		String m;
		for(int i=0;i<this.SIDE;i++){
			for(int j=0;j<this.SIDE;j++){
				m = "";
				m+= Level[i][j];
				if((i == this.Piece1a.Location.y)&(j == this.Piece1a.Location.x)){
					if(this.Player1.type == 1)
						m+= "C";
					if(this.Player1.type == 2)
						m+= "P";
					m+= "1";
				}if((i == this.Piece1b.Location.y)&(j == this.Piece1b.Location.x)){
					if(this.Player1.type == 1)
						m+= "C";
					if(this.Player1.type == 2)
						m+= "P";
					m+= "1";
				}if((i == this.Piece2a.Location.y)&(j == this.Piece2a.Location.x)){
					if(this.Player2.type == 1)
						m+= "C";
					if(this.Player2.type == 2)
						m+= "P";
					m+= "2";
				}if((i == this.Piece2b.Location.y)&(j == this.Piece2b.Location.x)){
					if(this.Player2.type == 1)
						m+= "C";
					if(this.Player2.type == 2)
						m+= "P";
					m+= "2";
				}
				display[i][j] = m;
			}
		}
		return display;
		
	}
}
