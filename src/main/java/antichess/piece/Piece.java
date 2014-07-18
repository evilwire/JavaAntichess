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
public abstract class Piece {
   protected String name;
   protected Color color;
   protected Location location;
   protected boolean captured = false;

   public Color getColor(){
      return this.color;
   }

   public Location getLocation() {
      return this.location;
   }

   public void setLocation(Location location){
      this.location = location;
   }

   public boolean getCaptured(){
       return this.captured;
   }

   public void setCaptured(boolean captured){
       this.captured = captured;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
