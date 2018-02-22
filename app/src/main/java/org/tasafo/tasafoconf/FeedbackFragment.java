package org.tasafo.tasafoconf;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.tasafo.tasafoconf.io.json.io.retrofit.FeedbackPollSender;
import org.tasafo.tasafoconf.io.json.model.Feedback;
import org.tasafo.tasafoconf.util.Utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * Feedback fragment.
 */
public class FeedbackFragment extends Fragment {

    View view;

    public FeedbackFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        if (Utils.todayIsTheDay()){
            view = inflater.inflate(R.layout.fragment_feedback_webview, container, false);
            ((WebView)view).loadUrl(getString(R.string.feedback_form_url));
            return view;
        } else {
            view = inflater.inflate(R.layout.not_at_the_day, container, false);
            TextView notAtTheDayTitle = (TextView) view.findViewById(R.id.not_at_the_day_title);
            TextView notAtTheDayContent = (TextView) view.findViewById(R.id.not_at_the_day_content);

            if (Utils.beforeTheDay()){
                notAtTheDayTitle.setText(getString(R.string.before_the_day_title));
                notAtTheDayContent.setText(getString(R.string.before_the_day_content));
            }

            if (Utils.afterTheDay()){
                notAtTheDayTitle.setText(getString(R.string.after_the_day_title));
                notAtTheDayContent.setText(getString(R.string.after_the_day_content));
            }
            return view;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.feedback, menu);
    }
}
