package org.tasafo.tasafoconf.io.json.parser;

import com.google.gson.stream.JsonReader;

import org.tasafo.tasafoconf.io.json.model.Conference;
import org.tasafo.tasafoconf.io.json.model.Speaker;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by ramonrabello on 13/11/15.
 */
public class SpeakerParser extends JsonParser<Speaker> {

    @Override
    protected Speaker parse(InputStream is) {
        return getGson().fromJson(new JsonReader(new InputStreamReader(is)), Speaker.class);
    }
}
