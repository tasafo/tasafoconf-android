package org.tasafo.tasafoconf.io.json.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Model that represents a Conference.
 */
public class Conference implements Serializable {

    private List<Session> sessions;
    private String about;
    private Location location;
    private List<Speaker> allSpeakers = new ArrayList<>();

    public Conference(){}

    public Conference(Location location, String about) {
        this.location = location;
        this.about = about;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Speaker> getAllSpeakers(){

        allSpeakers.clear();

        for(Session session:sessions){

            if (!session.isBreak()){
                allSpeakers.addAll(session.getSpeakers());
            }
        }
        return allSpeakers;
    }

    public void addSession(Session session){
        if (sessions == null){
            sessions = new ArrayList<>();
        }
        sessions.add(session);
    }

    public void addLocation(Location location){
        setLocation(location);
    }

    public boolean hasSessions(){
        return sessions != null && !sessions.isEmpty();
    }

    public boolean hasLocation(){
        return (location != null) &&
                location.getLongitude() != -1 &&
                location.getLatitude() != -1 &&
                (location.getName() != null && !location.getName().equals("")) &&
                (location.getAddress() != null && !location.getAddress().equals(""));
    }
}
