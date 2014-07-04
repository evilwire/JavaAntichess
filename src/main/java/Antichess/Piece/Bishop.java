package Antichess.Piece;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/4/14
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import Antichess.Color;

public class Bishop extends Piece {
   public Bishop( Color color ) {
      this.color = color;
   }

   public boolean isMoveValid
        ( Location location, ArrayList<Piece> opponentPieces )
   {
      return false;
   }

   public ArrayList<Location> getValidLocations
        ( ArrayList<Piece> opponentPieces )
   {
      ArrayList<Location> locations = new ArrayList<Location>();

      return locations;
   }

   public void setLocation( Location location ){
      this.location = location;
   }
}
