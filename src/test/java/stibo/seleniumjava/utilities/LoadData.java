package stibo.seleniumjava.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import stibo.seleniumjava.helpers.DemoData;
import java.io.IOException;
import java.io.InputStream;

public class LoadData {
        public static DemoData deserializeJson(InputStream is, DemoData data) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(is, data.getClass());}
}
