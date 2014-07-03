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
   public void Move( Location location ) {
      if( !this.isMoveValid( location ) )
        return;
   }

   public boolean isMoveValid( Location location ){

      return false;
   }

   public ArrayList<Location> getValidLocations() {
      ArrayList<Location> validLocations = new ArrayList<Location>();

      return validLocations;
   }

   public Pawn( Color color ) {
      this.color = color;
   }
}
