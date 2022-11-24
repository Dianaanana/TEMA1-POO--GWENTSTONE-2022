package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public final class Coordinates {
   private int x, y;

   private static ObjectMapper mapper = new ObjectMapper();

   public Coordinates() {
   }

   public int getX() {
      return x;
   }

   public void setX(final int x) {
      this.x = x;
   }

   public int getY() {
      return y;
   }

   public void setY(final int y) {
      this.y = y;
   }

   /**
    *
    * @param coordinates
    * @return
    */
   public static ObjectNode mapperCoordinates(final Coordinates coordinates) {
      ObjectNode coordinatesMapped = mapper.createObjectNode();
      coordinatesMapped.put("x", coordinates.x);
      coordinatesMapped.put("y", coordinates.y);
      return coordinatesMapped;
   }
}
