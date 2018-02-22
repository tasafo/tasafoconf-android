package org.tasafo.tasafoconf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BriefsFragment extends Fragment {

    private CircleImageView image1;
    private CircleImageView image2;
    private CircleImageView image3;
    private CircleImageView image4;

    public BriefsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_briefs, container, false);
        image1 = (CircleImageView) view.findViewById(R.id.image1);
        image2 = (CircleImageView) view.findViewById(R.id.image2);
        image3 = (CircleImageView) view.findViewById(R.id.image3);
        image4 = (CircleImageView) view.findViewById(R.id.image4);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Glide.with(getActivity()).load(getString(R.string.edgar_silva_profile_image_url)).into(image1);
        Glide.with(getActivity()).load(getString(R.string.alexandre_magno_profile_image_url)).into(image2);
        Glide.with(getActivity()).load(getString(R.string.caike_profile_image_url)).into(image3);
        Glide.with(getActivity()).load(getString(R.string.manoel_profile_image_url)).into(image4);
    }
}