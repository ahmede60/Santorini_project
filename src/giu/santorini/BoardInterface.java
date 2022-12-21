package giu.santorini;
import giu.santorini.exceptions.InvalidMoveException;
import giu.santorini.exceptions.InvalidPlacementException;
import giu.santorini.players.Player;
import giu.santorini.tiles.Piece;
import giu.santorini.utilities.Location;
public interface BoardInterface {
	int SIDE = 5;
	void move(Piece Piece, Location newLocation) throws InvalidMoveException;
	void place(Piece Piece, Location newLocation) throws InvalidPlacementException;
	boolean isGameOver();
	boolean isWinner(Player player);
	boolean hasNoMoves(Player player);
	Player getWinner();
	boolean canMove(Piece Piece, Location location); 
	boolean canPlace(Piece Piece, Location location);
	Player getTurn();
	String [][] display();
}