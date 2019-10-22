import com.utils.JsonParser;
import com.utils.impl.BasicJsonParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;


public class TestJsonParser {

    JsonParser testParser = new BasicJsonParser();

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

    @Test(expected = NullPointerException.class)
    public void testOnNullableInfoAboutProduct(){
        testParser.getInfoAboutProduct(null);
    }



}
