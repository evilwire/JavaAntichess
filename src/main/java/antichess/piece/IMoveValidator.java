package antichess.piece;

/**
 * Created by IntelliJ IDEA.
 * User: grimslock
 * Date: 7/18/14
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
import antichess.Board;
import java.util.List;

public interface IMoveValidator {
    public List<Location> getValidMove(Location location, Piece piece, Board board);
    public boolean isMoveValid(Location location, Piece piece, Board board);
}
