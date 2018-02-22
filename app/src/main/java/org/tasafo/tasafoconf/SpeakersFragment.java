package org.tasafo.tasafoconf;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.tasafo.tasafoconf.adapters.SpeakersAdapter;
import org.tasafo.tasafoconf.io.json.model.Speaker;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpeakersFragment extends Fragment {

    private RecyclerView recyclerView;


    public SpeakersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_speakers, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        List<Speaker> speakers = ((TasafoconfApplication) getContext().getApplicationContext()).getConference().getAllSpeakers();
        recyclerView.setAdapter(new SpeakersAdapter(getActivity(), speakers));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }
}