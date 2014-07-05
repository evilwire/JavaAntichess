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
      Location currentLocation = this.getLocation();
      int deltaX = location.getX() - currentLocation.getX();
      int deltaY = location.getY() - currentLocation.getY();

      /*     A
       *   B C D
       *   E p F
       */

      if( deltaY < 0 || deltaY > 2 || Math.abs(deltaX) > 1 )
         return false;

      if( Math.abs(deltaX) == 1 )
      {
         if( deltaY != 1) return false;

         // otherwise, test to see if
      }

      return false;
   }

   public ArrayList<Location> getValidLocations( ArrayList<Piece> opponentPieces ) {
      ArrayList<Location> validLocations = new ArrayList<Location>();

      return validLocations;
   }
}
