package antichess.piece;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/4/14
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import antichess.Color;
import antichess.Board;

public class Bishop extends Piece {
   public Bishop( Color color ) {
      this.color = color;
   }

   public boolean isMoveValid
        ( Location location, Board board )
   {
      return false;
   }

   public ArrayList<Location> getValidLocations
        ( Board board )
   {
      ArrayList<Location> locations = new ArrayList<Location>();

      return locations;
   }

   public void setLocation( Location location ){
      this.location = location;
   }
}
