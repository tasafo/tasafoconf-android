package org.tasafo.tasafoconf;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.tasafo.tasafoconf.io.json.model.Session;
import org.tasafo.tasafoconf.io.json.model.Speaker;

/**
 * Test class for {@link Session} model. All info
 * are filled according to the json data values,
 * located at assets/json/data.json.
 *
 * Created by ramonrabello on 28/11/15.
 */
public class SessionTest {

    private Session session;

    @Before
    public void setUp() throws Exception{
        session = new Session();
    }

    @Test
    public void shouldCheckIfSessionHasSpeakers(){

        Speaker firstSpeaker = new Speaker();
        firstSpeaker.setId("321311233");
        firstSpeaker.setName("Fulano de Tal");
        firstSpeaker.setProfileImageUrl("http://www.url.com");
        firstSpeaker.setBio("fulano bio");
        firstSpeaker.setJob("fulano job");
        firstSpeaker.setWorkAt("FulanoWorks");

        Speaker secondSpeaker = new Speaker();
        secondSpeaker.setId("1hh4h5k6k7jhh32");
        secondSpeaker.setName("Beltrano de Tal");
        secondSpeaker.setProfileImageUrl("");
        secondSpeaker.setBio("beltrano bio");
        secondSpeaker.setJob("beltrano job");
        secondSpeaker.setWorkAt("BeltranoWorks");

        session.addSpeaker(firstSpeaker);
        session.addSpeaker(secondSpeaker);

        Assert.assertTrue(session.hasOneSpeaker() || session.hasTwoSpeakers());
    }

    @Test
    public void shouldCheckIfSessionIsBreak(){
        session.setType("break");
        Assert.assertTrue(session.isBreak());
    }

    @Test
    public void shouldCheckIfSessionIsKeynote(){
        session.setType("keynote");
        Assert.assertTrue(session.isKeynote());
    }

    @Test
    public void shouldCheckIfSessionIsInvitedSpeaker(){
        session.setType("invited_speaker");
        Assert.assertTrue(session.isInvitedSpeaker());
    }

    @Test
    public void shouldCheckIfSessionIsDevOpsTrack(){
        session.setType("devops");
        Assert.assertTrue(session.isDevOpsTrack());
    }

    @Test
    public void shouldCheckIfSessionIsMobileGameTrack(){
        session.setType("mobile_game");
        Assert.assertTrue(session.isMobileAndGameTrack());
    }

    @Test
    public void shouldCheckIfSessionIsInnovationEnterpreneurshipAndCommunityTrack(){
        session.setType("innovation_enterpreneurship_community");
        Assert.assertTrue(session.isInnovationEnterpreneurshipAndCommunityTrack());
    }

    @Test
    public void shouldCheckIfSessionIsManagementBusinessAgileTrack(){
        session.setType("management_business_agile");
        Assert.assertTrue(session.isManagementBusinessAgileTrack());
    }
}