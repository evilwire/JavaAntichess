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

   public boolean isMoveValid
        ( Location location, Board board )
   {
      return false;
   }

   public List<Location> getValidLocations
        ( Board board )
   {
      List<Location> locations = new ArrayList<Location>();
      // based on the location, find all diagonals
      // and eliminate those which cannot be reached
      boolean NE = false,
              NW = false,
              SE = false,
              SW = false;



      return locations;
   }

   public void setLocation( Location location ){
      this.location = location;
   }
}
