package antichess.piece;

/**
 * Created by IntelliJ IDEA.
 * User: grimslock
 * Date: 7/18/14
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public enum PieceType {
    PAWN("Pawn"),
    ROOK("Rook"),
    KNIGHT("Knight"),
    BISHOP("Bishop"),
    QUEEN("Queen"),
    KING("King");

    private final String value;

    private PieceType( String value){
        this.value = value;
    }

    public String getCompactName(){
        return this.toString().substring(0, 1);
    }

    @Override
    public String toString(){
       return this.value;
    }
}
