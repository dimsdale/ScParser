import com.utils.JsonWriter;
import com.utils.impl.BasicJsonWriter;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;


public class TestJsonWriter {

    JsonWriter testWriter = new BasicJsonWriter();
    @Test(expected = FileNotFoundException.class)
    public void testWriterOnNullableObjects() throws Exception {
        testWriter.writeInFile(null, "bla");

    }
}
