package tests;

import com.utils.JsonWriter;
import com.utils.impl.BasicJsonWriter;
import org.junit.Test;


public class TestJsonWriter {

    private JsonWriter testWriter = new BasicJsonWriter();

    @Test(expected = NullPointerException.class)
    public void testWriterOnNullableObjects() {
        testWriter.writeInFile(null, null);

    }
}
