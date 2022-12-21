package giu.santorini.tiles;
import java.util.ArrayList;
import giu.santorini.utilities.Location;
public interface PieceInterface {
	ArrayList<Location> possibleMoves();
	ArrayList<Location> possiblePlacements();
}