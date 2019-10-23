import com.utils.JsonWriter;
import com.utils.impl.BasicJsonWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;


public class TestJsonWriter {

    private JsonWriter testWriter = new BasicJsonWriter();

    @Test(expected = NullPointerException.class)
    public void testWriterOnNullableObjects() {
        testWriter.writeInFile(null, null);

    }
}
