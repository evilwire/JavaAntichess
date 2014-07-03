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
   public void move( Location location ) {
      if( !this.isMoveValid( location ) )
        return;
   }

   public boolean isMoveValid( Location location ){
      // get current location
      Location currentLocation = this.getCurrentLocation();
      int deltaX = location.getX() - currentLocation.getX();
      int deltaY = location.getY() - currentLocation.getY();

      if( Math.abs( deltaX) > 1 )
         return false;

      if( Math.abs( deltaX ) == 1 && deltaY == 1 ) {
         // check to see if there are any pieces in the location

      }

      return false;
   }

   public Location getCurrentLocation(){
      return this.location;
   }

   public ArrayList<Location> getValidLocations() {
      ArrayList<Location> validLocations = new ArrayList<Location>();

      return validLocations;
   }

   public Pawn( Color color ) {
      this.color = color;
   }
}
