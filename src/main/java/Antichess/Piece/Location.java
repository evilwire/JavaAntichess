package Antichess.Piece;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/3/14
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Location {
   private int x;
   private int y;

   public Location(int x, int y) {
      this.x = x;
      this.y = y;
   }

   /**
    *
    * @return
    */
   public int getX() {
     return this.x;
   }

   /**
    *
    * @return
    */
   public int getY() {
     return this.y;
   }

   /**
    *
    * @return
    */
   public boolean isValid() {
     return this.x >= 1 && this.x <= 8 &&
            this.y >= 1 && this.y <= 8;
   }

   /**
    *
    * @return
    */
   public int hashCode(){
      return (this.x - 1) << 3 + (this.y - 1);
   }

   /**
    *
    * @param location
    * @return
    */
   public boolean equals( Location location ){
     return this.hashCode() == location.hashCode();
   }
}
