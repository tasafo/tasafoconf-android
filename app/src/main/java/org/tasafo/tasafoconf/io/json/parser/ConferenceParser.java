package org.tasafo.tasafoconf.io.json.parser;

import com.google.gson.stream.JsonReader;

import org.tasafo.tasafoconf.io.json.model.Conference;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Parser for {@linkplain Conference} model.
 */
public class ConferenceParser extends JsonParser<Conference> {

    @Override
    public Conference parse(InputStream is) {
        return getGson().fromJson(new JsonReader(new InputStreamReader(is)), Conference.class);
    }
}
