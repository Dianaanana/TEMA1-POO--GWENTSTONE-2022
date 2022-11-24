package cards;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;

public class Environement extends Card implements Cloneable {

    public ObjectNode CardMapper(Environement environement) {
        ObjectNode environement1 = mapper.createObjectNode();
        environement1.put("mana", environement.mana);
        environement1.put("description", environement.description);

        ArrayNode arrayNode = mapper.createArrayNode();
        for(String color : environement.colors) {
            arrayNode.add(color);
        }
        environement1.set("colors", arrayNode);
        environement1.put("name", environement.name);

        return environement1;
    }
    public Environement(CardInput cardInput) {
        super(cardInput);
    }

    public Environement(Card card) {
        super(card);
    }

    public Object clone() throws CloneNotSupportedException {
        Environement clone = (Environement) super.clone();
        return clone;
    }
}
