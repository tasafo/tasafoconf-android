package org.tasafo.tasafoconf;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.tasafo.tasafoconf.io.json.model.SocialNetwork;
import org.tasafo.tasafoconf.io.json.model.Speaker;

/**
 * Created by ramonrabello on 28/11/15.
 */
public class SpeakerTest {

    private Speaker speaker;

    @Before
    public void setUp(){
        speaker = new Speaker();
    }

    @Test
    public void shouldCheckIfAllInfoArePresent(){
        speaker.setId("1jj334kkk22nn3j4jj22");
        speaker.setProfileImageUrl("http://wwww.url.com");
        speaker.setName("Ramon Rabello");
        speaker.setJob("Ramon Job");
        speaker.setBio("Ramon Bio");
        speaker.setWorkAt("Tá Safo");

        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.setType("twitter");
        socialNetwork.setUrl("http://www.twitter.com/ramonrabello");
        speaker.addSocialNetwork(socialNetwork);

        socialNetwork = new SocialNetwork();
        socialNetwork.setType("linkedin");
        socialNetwork.setUrl("http://www.linkedin.com/ramonrabello");
        speaker.addSocialNetwork(socialNetwork);

        socialNetwork = new SocialNetwork();
        socialNetwork.setType("github");
        socialNetwork.setUrl("http://www.github.com/ramonrabello");
        speaker.addSocialNetwork(socialNetwork);

        Assert.assertTrue(!speaker.getName().isEmpty());
        Assert.assertTrue(!speaker.getJob().isEmpty());
        Assert.assertTrue(!speaker.getBio().isEmpty());
        Assert.assertTrue(!speaker.getWorkAt().isEmpty());
        Assert.assertTrue(speaker.hasSocialNetworks());
    }
}