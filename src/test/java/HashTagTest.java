import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HashTagTest {

    @Test
    void foundHashTags() {
        ArrayList<String> list = new ArrayList<>(5);
        list.add("#My favourite #color #is #orange. It #is so #beautiful");
        list.add("#My name #is Tom. #country.");
        list.add("Ukraine #is a #beautiful #country. It #is #my #country");
        list.add("#My cat #is #orange. #beautiful.");
        list.add("#Beautiful places are #my weakness. #my. #orange");

        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("#my", 5);
        result.put("#beautiful", 4);
        result.put("#is", 4);
        result.put("#orange", 3);
        result.put("#country", 2);

        assertEquals(result, Main.FoundHashTags(list));

    }
}