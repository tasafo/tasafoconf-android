package org.tasafo.tasafoconf;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.tasafo.tasafoconf.io.json.model.Schedule;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    TextView textMeetTasafo;
    TextView textShowSchedule;
    TextView textShowSpeakers;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        textMeetTasafo = (TextView) view.findViewById(R.id.text_meet_tasafo);
        textMeetTasafo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTasafoPage();
            }
        });
        textShowSchedule = (TextView) view.findViewById(R.id.text_show_schedule);
        textShowSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSchedule();
            }
        });
        textShowSpeakers = (TextView) view.findViewById(R.id.text_show_speakers);
        textShowSpeakers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSpeakers();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void showTasafoPage(){
        Uri uri = Uri.parse("http://tasafo.wordpress.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void showSchedule(){
        startActivity(new Intent(getActivity(), ScheduleActivity.class));
    }

    private void showSpeakers(){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new SpeakersFragment()).commit();
    }
}