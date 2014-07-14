package antichess.piece;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/4/14
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.List;

import antichess.Color;
import antichess.Board;

public class Bishop extends Piece {
   public Bishop( Color color ) {
      this.color = color;
   }

   public boolean isMoveValid( Location location, Board board ) {
      if( !this.isLocationReachable( location )) {
          return false;
      }

      Location currentLocation = this.getLocation();

      if( location == currentLocation){
         return true;
      }

      int deltaX = location.getX() - currentLocation.getX(),
          deltaY = location.getY() - currentLocation.getY(),
          xStep = ( deltaX > 0 )? 1 : -1,
          yStep = ( deltaY > 0 )? 1 : -1;

      for( int i = 1; i < Math.abs(deltaX); i++ ){
         Location intermediateLocation = new Location( xStep * i, yStep * i );
         if( !board.isLocationEmpty( intermediateLocation ) ){
             return false;
         }
      }

      if( !board.isLocationEmpty( location ) &&
          ( board.getPieceAt( location ).getColor() == this.getColor() ) ){
         return false;
      }

      return true;
   }

   private boolean isLocationReachable( Location location ){
      Location currentLocation = this.getLocation();

      return Math.abs(location.getX() - currentLocation.getX()) ==
             Math.abs(location.getY() - currentLocation.getY());
   }

   private List<Location> getValid( Board board ){
      List<Location> locations = new ArrayList<Location>();
      return locations;
   }

   public List<Location> getValidLocations( Board board )
   {
      List<Location> locations = new ArrayList<Location>();

      return locations;
   }

   public void setLocation( Location location ){
      this.location = location;
   }
}
