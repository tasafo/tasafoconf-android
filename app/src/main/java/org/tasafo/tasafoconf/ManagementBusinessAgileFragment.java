package org.tasafo.tasafoconf;

import org.tasafo.tasafoconf.io.json.model.Session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ramonrabello on 19/11/15.
 */
public class ManagementBusinessAgileFragment extends TrackFragment {

    public ManagementBusinessAgileFragment(){}

    @Override
    public List<Session> getSessions() {
        List<Session> allSessions = getConference().getSessions();
        Collections.sort(allSessions, new Comparator<Session>() {
            @Override
            public int compare(Session s1, Session s2) {

                if (Integer.parseInt(s1.getStartTime()) > Integer.parseInt(s2.getStartTime())) {
                    return 1;
                }

                if (Integer.parseInt(s1.getStartTime()) == Integer.parseInt(s2.getStartTime())) {
                    return 0;
                }
                return -1;
            }
        });

        List<Session> trackSessions = new ArrayList<>();
        for (Session session:allSessions){
            if (session.isBreak() ||
                    session.isKeynote() ||
                    session.isInvitedSpeaker() ||
                    session.isManagementBusinessAgileTrack()){
                trackSessions.add(session);
            }
        }
        return trackSessions;
    }
}
