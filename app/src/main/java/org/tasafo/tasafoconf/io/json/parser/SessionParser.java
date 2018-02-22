package org.tasafo.tasafoconf.io.json.parser;

import com.google.gson.stream.JsonReader;

import org.tasafo.tasafoconf.io.json.model.Conference;
import org.tasafo.tasafoconf.io.json.model.Session;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramonrabello on 13/11/15.
 */
public class SessionParser extends JsonParser<Session> {

    @Override
    protected Session parse(InputStream is) {
        List<Session> sessions = new ArrayList<>();
        return getGson().fromJson(new JsonReader(new InputStreamReader(is)), Session.class);
    }
}
