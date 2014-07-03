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
   void Move(int x, int y);
   boolean isMoveValid(int x, int y);
   ArrayList<Location> getValidLocations();
}
