package org.tasafo.tasafoconf;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.tasafo.tasafoconf.adapters.SessionAdapter;
import org.tasafo.tasafoconf.io.json.model.Conference;
import org.tasafo.tasafoconf.io.json.model.Session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ramonrabello on 19/11/15.
 */
public class DevOpsFragment extends TrackFragment {

    public DevOpsFragment(){}

    public List<Session> getSessions() {
        List<Session> allSessions = getConference().getSessions();
        List<Session> trackSessions = new ArrayList<>();
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

        for (Session session:allSessions){
            if (session.isBreak() ||
                    session.isKeynote() ||
                    session.isInvitedSpeaker() ||
                    session.isDevOpsTrack()){
                trackSessions.add(session);
            }
        }
        return trackSessions;
    }
}
