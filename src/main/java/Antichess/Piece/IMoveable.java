package Antichess.Piece;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/3/14
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IMoveable {
   void setLocation( Location location );
   Location getLocation();
   boolean isMoveValid( Location location, ArrayList<Piece> opponentPieces );
   ArrayList<Location> getValidLocations( ArrayList<Piece> opponentPieces );
}
