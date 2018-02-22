package org.tasafo.tasafoconf;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.tasafo.tasafoconf.io.json.model.Conference;
import org.tasafo.tasafoconf.io.json.model.Location;
import org.tasafo.tasafoconf.io.json.model.Session;

/**
 * Created by ramonrabello on 28/11/15.
 */
public class ConferenceTest {

    Conference conference;

    @Before
    public void setUp() {
        conference = new Conference();
    }

    @Test
    public void shouldCheckIfConferenceHaveAtLeastOneSession() {

        Session mockedSession = new Session();

        mockedSession.setTitle("Credenciamento e Café da Manhã");
        mockedSession.setType("break");
        mockedSession.setStartTime("0800");
        mockedSession.setEndTime("0900");
        conference.addSession(mockedSession);

        mockedSession = new Session();
        mockedSession.setTitle("Hacking the World");
        mockedSession.setType("keynote");
        mockedSession.setStartTime("0900");
        mockedSession.setEndTime("0950");
        conference.addSession(mockedSession);

        mockedSession = new Session();
        mockedSession.setTitle("Android Marshmallow na prática");
        mockedSession.setType("mobile_game");
        mockedSession.setStartTime("0950");
        mockedSession.setEndTime("1020");
        conference.addSession(mockedSession);

        Assert.assertTrue(conference.hasSessions());
    }

    @Test
    public void shouldCheckIfConferenceHasLocation() {
        Location location = new Location(-1.4217252, -48.458966, "Hangar Centro de Convenções e Feiras da Amazônia", "Av. Dr. Freitas, s/n - Marco,Belém - PA,66613-902");
        conference.addLocation(location);
        Assert.assertNotNull(conference.hasLocation());
    }
}
