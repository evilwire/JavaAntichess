package Antichess.Piece;

import java.util.ArrayList;
import Antichess.Board;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/3/14
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IMoveable {
   /**
    *
    * @param location
    */
   void setLocation( Location location );

   /**
    *
    * @return
    */
   Location getLocation();

   /**
    *
    * @param location
    * @param board
    * @return
    */
   boolean isMoveValid
           ( Location  location,
             Board     board );

   /**
    *
    * @param board
    * @return
    */
   ArrayList<Location> getValidLocations
           ( Board board );
}
