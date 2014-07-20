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
   private boolean isAtStartingLocation(){
       return this.getLocation().getY() ==
               ( ( this.getColor() == Color.WHITE )? 2 : 7 );
   }

   private Location getTwoForward(){
       return new Location(
               this.getLocation().getX(),
               this.getLocation().getY() + ((this.getColor() == Color.WHITE)? 2 : -2 ));
   }

   private Location getForward(){
       return new Location(
               this.getLocation().getX(),
               this.getLocation().getY() + ((this.getColor() == Color.WHITE)? 1 : -1 ));
   }

   private Location getLeftDiagonal(){
      return new Location(
               this.getLocation().getX() + ((this.getColor() == Color.WHITE)? -1 : 1),
               this.getLocation().getY() + ((this.getColor() == Color.WHITE)? 1 : -1 ));
   }

   private Location getRightDiagonal(){
       return new Location(
               this.getLocation().getX() + ((this.getColor() == Color.WHITE)? 1 : -1),
               this.getLocation().getY() + ((this.getColor() == Color.WHITE)? 1 : -1 ));
   }

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
    * @param board
    * @return
    */
   public boolean isMoveValid( Location location,
                               Board board ){
      Location currentLocation = this.getLocation();
      int deltaX = location.getX() - currentLocation.getX();

      // Note: we want to keep the deltaY positive, so if the
      // piece is black, we want to reverse the coordinate
      // system
      int deltaY = ( this.getColor() == Color.WHITE)?
              location.getY() - currentLocation.getY() :
              currentLocation.getY() - location.getY();

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
      {
         Location forwardLocation = this.getForward();

         return this.isAtStartingLocation() &&
                board.isLocationEmpty( this.getForward() ) &&
                board.isLocationEmpty( location );
      }

      return board.isLocationEmpty(location);
   }

   public List<Location> getValidLocations( Board board ) {
      List<Location> validLocations = new ArrayList<Location>();
      Location currentLocation = this.getLocation(),
               forwardLocation = this.getForward();

      if( board.isLocationEmpty( forwardLocation )){
         validLocations.add( forwardLocation );

         Location twoForwardLocation = this.getTwoForward();
         if( this.isAtStartingLocation() &&
             board.isLocationEmpty( twoForwardLocation ) ){
            validLocations.add( twoForwardLocation );
         }
      }

      Location leftDiagonal = this.getLeftDiagonal();
      if( !board.isLocationEmpty( leftDiagonal ) ){
         validLocations.add( leftDiagonal );
      }

      Location rightDiagonal = this.getRightDiagonal();
      if( !board.isLocationEmpty( rightDiagonal )){
         validLocations.add( rightDiagonal );
      }

      return validLocations;
   }
}
