package iut.dam.maximumpawaaaaaa.utils;

import android.content.Context;
import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JsonUtils {

    public static String loadJSONFromRaw(Context context, int rawResourceId) {
        try {
            InputStream is = context.getResources().openRawResource(rawResourceId);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

