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
 * A simple {@link Fragment} subclass.
 */
public abstract class TrackFragment extends Fragment {

    private RecyclerView recyclerView;
    private Conference conference;

    public TrackFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        conference = ((TasafoconfApplication) context.getApplicationContext()).getConference();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new SessionAdapter(getActivity(), getSessions()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public abstract List<Session> getSessions();

    protected Conference getConference(){
        return conference;
    }
}
