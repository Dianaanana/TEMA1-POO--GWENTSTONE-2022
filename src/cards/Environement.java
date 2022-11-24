package cards;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;

public class Environement extends Card implements Cloneable {

    /**
     * @param environement
     * @return
     */
    public ObjectNode cardMapper(final Environement environement) {
        ObjectNode environement1 = mapper.createObjectNode();
        environement1.put("mana", environement.getMana());
        environement1.put("description", environement.getDescription());

        ArrayNode arrayNode = mapper.createArrayNode();
        for (String color : environement.getColors()) {
            arrayNode.add(color);
        }
        environement1.set("colors", arrayNode);
        environement1.put("name", environement.getName());

        return environement1;
    }

    public Environement(final CardInput cardInput) {
        super(cardInput);
    }

    public Environement(final Card card) {
        super(card);
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Environement clone = (Environement) super.clone();
        return clone;
    }
}
