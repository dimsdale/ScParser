package tests;

import com.utils.JsonParser;
import com.utils.impl.BasicJsonParser;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestJsonParser {

    private JsonParser testParser = new BasicJsonParser();

    @Test
    public void testOnNullableQuantityOfPages(){
        testParser.getQuantityOfPages(null);
        assertEquals(testParser.getQuantityOfPages(null), -1);
        assertEquals(testParser.getQuantityOfPages(new JSONObject()), -1);
    }
    @Test(expected = NullPointerException.class)
    public void testOnNullableResponse(){
        testParser.getJsonObjectFromResponse(null);
    }

    @Test
    public void testOnWritingOfProductinPojo(){
        assertEquals(testParser.getInfoAboutProduct(null).getId(), -1);
    }



}
