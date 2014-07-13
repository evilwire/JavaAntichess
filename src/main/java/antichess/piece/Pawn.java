package antichess.piece;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/3/14
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.List;

import antichess.*;

public class Pawn extends Piece {
   /**
    *
    * @param color
    */
   public Pawn( Color color ) {
      this.color = color;
   }

   /**
    *
    * @param location
    */
   public void setLocation( Location location ) {
      this.location = location;
   }

   /**
    *
    * @param location
    * @param board
    * @return
    */
   public boolean isMoveValid( Location location,
                               Board board ){
      Location currentLocation = this.getLocation();
      int deltaX = location.getX() - currentLocation.getX();
      int deltaY = location.getY() - currentLocation.getY();

      if( deltaY < 0 || deltaY > 2 || Math.abs(deltaX) > 1 ){
         return false;
      }

      if( Math.abs(deltaX) == 1 )
      {
         if( deltaY != 1){
             return false;
         }

         return !board.isLocationEmpty( location ) &&
                (board.getPieceAt( location ).getColor() != this.getColor());
      }

      if( deltaY == 2)
         return currentLocation.getY() ==
                 ((this.getColor() == Color.WHITE)? 2 : 7);

      return board.isLocationEmpty(location);
   }

   public List<Location> getValidLocations( Board board ) {
      List<Location> validLocations = new ArrayList<Location>();

      return validLocations;
   }
}
