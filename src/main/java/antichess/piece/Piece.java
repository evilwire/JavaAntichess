package antichess.piece;

import antichess.Color;
import antichess.rules.IMoveValidator;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/3/14
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Piece {
    protected PieceType type;
    protected Color color;
    protected Location location;
    protected boolean captured = false;
    protected Collection<IMoveValidator> moveValidators;

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

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

    public Collection<IMoveValidator> getMoveValidators() {
        return moveValidators;
    }
}
