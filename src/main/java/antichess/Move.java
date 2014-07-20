package antichess;

import antichess.piece.Piece;

/**
 * Created by IntelliJ IDEA.
 * User: grimslock
 * Date: 7/18/14
 * Time: 4:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Move {
    private Piece piece;
    private Location location;

    public Move(Piece piece, Location location) {
        this.piece = piece;
        this.location = location;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
