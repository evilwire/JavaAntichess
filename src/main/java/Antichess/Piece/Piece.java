package Antichess.Piece;

import Antichess.Color;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/3/14
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Piece implements IMoveable{
   protected String name;
   protected Color color;
   protected Location location;
   protected boolean captured;

   abstract public boolean isMoveValid
        ( Location location, ArrayList<Piece> opponentPieces );

   abstract public ArrayList<Location> getValidLocations
        ( ArrayList<Piece> opponentPieces );

   public Location getLocation()
   {
      return this.location;
   }
}
