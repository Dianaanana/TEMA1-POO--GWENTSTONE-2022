package fileio;

import cards.Card;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public final class Coordinates {
   private int x, y;

   public static ObjectMapper mapper = new ObjectMapper();

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

   @Override
   public String toString() {
      return "Coordinates{"
              + "x="
              + x
              + ", y="
              + y
              + '}';
   }

   public static ObjectNode mapperCoordinates(Coordinates coordinates) {
      ObjectNode coordinatesMapped = mapper.createObjectNode();
      coordinatesMapped.put("x", coordinates.x);
      coordinatesMapped.put("y", coordinates.y);
      return coordinatesMapped;
   }
}
