package antichess.piece;

import antichess.Board;
import antichess.Color;

import java.util.ArrayList;
import java.util.List;

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
        ( Location location, Board board );

   abstract public List<Location> getValidLocations
        ( Board board );

   public Color getColor(){
      return this.color;
   }

   public Location getLocation() {
      return this.location;
   }
}
