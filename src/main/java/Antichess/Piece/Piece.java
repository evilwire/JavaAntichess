package Antichess.Piece;

import Antichess.Color;

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
   protected boolean captured;
}
