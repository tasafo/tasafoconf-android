package org.tasafo.tasafoconf.io.json.model;

import android.provider.SearchRecentSuggestions;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ramonrabello on 12/11/15.
 */
public class Speaker extends BaseModel {

    private String name;

    @SerializedName("profile_url")
    private String profileImageUrl;
    private String job;
    private String bio;

    @SerializedName("work_at")
    private String workAt;

    @SerializedName("social_networks")
    private List<SocialNetwork> socialNetworks;

    public Speaker(){}

    public Speaker(String name, String profileImageUrl, String job, String bio, String workAt) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.job = job;
        this.bio = bio;
        this.workAt = workAt;
    }

    public String getWorkAt() {
        return workAt;
    }

    public void setWorkAt(String workAt) {
        this.workAt = workAt;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SocialNetwork> getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(List<SocialNetwork> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public boolean hasSocialNetworks(){
        return socialNetworks != null && !socialNetworks.isEmpty();
    }

    public void addSocialNetwork(SocialNetwork socialNetwork){
        socialNetworks.add(socialNetwork);
    }
}
