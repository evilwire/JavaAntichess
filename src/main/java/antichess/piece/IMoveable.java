package antichess.piece;

import java.util.List;
import antichess.Board;

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
   List<Location> getValidLocations
           ( Board board );
}
