package org.tasafo.tasafoconf;

import android.support.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;
import android.test.AndroidTestCase;
import android.test.AndroidTestRunner;
import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.tasafo.tasafoconf.io.json.model.Conference;
import org.tasafo.tasafoconf.io.json.model.Session;
import org.tasafo.tasafoconf.io.json.model.Speaker;
import org.tasafo.tasafoconf.io.json.parser.ConferenceParser;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 *
 * Created by ramonrabello on 17/11/15.
 */
@RunWith(AndroidJUnit4.class)
public class JsonParserTest extends AndroidTestCase {

    public JsonParserTest(){}

    @Test
    @SmallTest
    public void shouldLoadAllSpeakersInfoFromJson() {
        try {
            InputStream is = getContext().getResources().getAssets().open("json/data.json");
            ConferenceParser parser = new ConferenceParser();
            Conference conference = parser.parse(is);
            Assert.assertNotNull(conference);

            for (Speaker speaker:conference.getAllSpeakers()) {
                Assert.assertTrue(!speaker.getName().isEmpty());
                Assert.assertTrue(!speaker.getJob().isEmpty());
                Assert.assertTrue(!speaker.getBio().isEmpty());
                Assert.assertTrue(!speaker.getProfileImageUrl().isEmpty());
                Assert.assertTrue(!speaker.getSocialNetworks().isEmpty());
                Assert.assertTrue(!speaker.getWorkAt().isEmpty());
            }
        } catch (IOException e) {
            fail("JSON data is not complete. Please check.");
        }
    }

    @Test
    @SmallTest
    public void shouldLoadSessionFromJsonWithOneSpeaker() {
        try {
            InputStream is = getContext().getResources().getAssets().open("json/data.json");
            ConferenceParser parser = new ConferenceParser();
            Conference conference = parser.parse(is);
            Assert.assertNotNull(conference);
            Assert.assertTrue(!conference.getSessions().isEmpty());
            for (Session session: conference.getSessions()) {
                Assert.assertEquals(session.getSpeakers().size(), 1);
            }
        } catch (IOException e) {
            fail("JSON data is not complete. Please check.");
        }
    }

    @Test
    @SmallTest
    public void shouldLoadTracksFromJson() {
        try {
            InputStream is = getContext().getResources().getAssets().open("json/data.json");
            ConferenceParser parser = new ConferenceParser();
            Conference conference = parser.parse(is);
            Assert.assertNotNull(conference);
            Assert.assertNotNull(conference.getAbout());
            Assert.assertNotNull(conference.getLocation());
//            Assert.assertTrue(!conference.getTracks().isEmpty());
            Assert.assertTrue(!conference.getSessions().isEmpty());
//            Assert.assertTrue(!conference.getSpeakers().isEmpty());
        } catch (IOException e) {
            fail("JSON data is not complete. Please check.");
        }
    }
}
