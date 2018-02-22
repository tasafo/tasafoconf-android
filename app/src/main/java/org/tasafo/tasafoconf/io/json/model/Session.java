package org.tasafo.tasafoconf.io.json.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramonrabello on 13/11/15.
 */
public class Session extends BaseModel {

    private String title;
    private String description;

    @SerializedName("start_time")
    private String startTime;

    @SerializedName("end_time")
    private String endTime;
    private String type;

    @SerializedName("presentation_url")
    private String presentationUrl;

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    private List<Speaker> speakers;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBreak(){
        return type.equals("break");
    }

    public boolean isKeynote(){
        return type.equals("keynote");
    }

    public boolean isInvitedSpeaker(){
        return type.equals("invited_speaker");
    }

    public boolean isDevOpsTrack(){
        return type.equals("devops");
    }

    public boolean isMobileAndGameTrack(){
        return type.equals("mobile_game");
    }

    public boolean isInnovationEnterpreneurshipAndCommunityTrack(){
        return type.equals("innovation_enterpreneurship_community");
    }

    public boolean isManagementBusinessAgileTrack(){
        return type.equals("management_business_agile");
    }

    public boolean hasOneSpeaker(){
        return (speakers!= null && !speakers.isEmpty() && speakers.size() == 1);
    }

    public boolean hasTwoSpeakers(){
        return (speakers!= null && !speakers.isEmpty() && speakers.size() == 2);
    }

    public void addSpeaker(Speaker speaker){
        if (speakers == null){
            speakers = new ArrayList<>();
        }
        speakers.add(speaker);
    }

    public String getPresentationUrl() {
        return presentationUrl;
    }

    public void setPresentationUrl(String presentationUrl) {
        this.presentationUrl = presentationUrl;
    }

    public boolean isPresentationAvailable(){
        return presentationUrl != null;
    }
}
