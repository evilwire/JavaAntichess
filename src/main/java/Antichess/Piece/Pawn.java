package Antichess.Piece;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/3/14
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import Antichess.Color;

public class Pawn extends Piece implements IMoveable {
   public Pawn( Color color ) {
      this.color = color;
   }

   public void setLocation( Location location ) {
      this.location = location;
   }

   public boolean isMoveValid( Location location,
                               ArrayList<Piece> opponentPieces ){
      ArrayList<Location> validLocations =
        this.getValidLocations( opponentPieces );

      return validLocations.contains(location);
   }

   public ArrayList<Location> getValidLocations( ArrayList<Piece> opponentPieces ) {
      ArrayList<Location> validLocations = new ArrayList<Location>();

      return validLocations;
   }
}
