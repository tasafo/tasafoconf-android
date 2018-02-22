package org.tasafo.tasafoconf;

import android.app.Application;

import org.tasafo.tasafoconf.io.json.model.Conference;
import org.tasafo.tasafoconf.io.json.model.Session;
import org.tasafo.tasafoconf.io.json.model.Speaker;
import org.tasafo.tasafoconf.io.json.parser.ConferenceParser;

import java.io.IOException;
import java.util.List;

/**
 * Created by ramonrabello on 13/11/15.
 */
public class TasafoconfApplication extends Application {

    Conference conference;

    public Conference getConference() {
        return conference;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ConferenceParser parser = new ConferenceParser();
        try {
            conference = parser.parse(getApplicationContext().getAssets().open("json/data.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}