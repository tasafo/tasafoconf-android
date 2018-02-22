package org.tasafo.tasafoconf.io.json.model;

import java.io.Serializable;

/**
 * Created by ramonrabello on 13/11/15.
 */
public class SocialNetwork implements Serializable {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public boolean isTwitter(){
        return type != null && type.equals(SocialNetworkType.TWITTER.name().toLowerCase());
    }

    public boolean isLinkedIn(){
        return type != null && type.equals(SocialNetworkType.LINKEDIN.name().toLowerCase());
    }

    public boolean isGitHub(){
        return type != null && type.equals(SocialNetworkType.GITHUB.name().toLowerCase());
    }

    private enum SocialNetworkType {
        LINKEDIN,
        TWITTER,
        GITHUB
    }
}